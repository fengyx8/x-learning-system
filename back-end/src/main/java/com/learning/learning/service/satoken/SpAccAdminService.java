package com.learning.learning.service.satoken;


import cn.dev33.satoken.spring.SpringMVCUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.learning.learning.config.SystemObject;
import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.mapper.satoken.SpAccAdminMapper;
import com.learning.learning.mapper.satoken.XUserMapper;
import com.learning.learning.util.sg.AjaxJson;
import com.learning.learning.util.sg.NbUtil;
import com.learning.learning.util.sg.WebNbUtil;
import com.learning.learning.util.so.SoMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

/**
 * service：admin账号相关
 * @author kong
 *
 */
@Service
public class SpAccAdminService {
	private final SpAccAdminMapper spAccAdminMapper;

	private final XUserMapper xUserMapper;
	
	private final SpRolePermissionService spRolePermissionService;

	public SpAccAdminService(SpAccAdminMapper spAccAdminMapper, XUserMapper xUserMapper, SpRolePermissionService spRolePermissionService) {
		this.spAccAdminMapper = spAccAdminMapper;
		this.xUserMapper = xUserMapper;
		this.spRolePermissionService = spRolePermissionService;
	}


	/**
	  * 登录 
	 * @param id 用户ID
	 * @param password 用户密码
	 * @return
	 */
	public AjaxJson doLogin(String id, String password) {
		
		// 0、判断 way (1=ID, 2=昵称，3=邮箱)
    	int way = 2;	
    	if (NbUtil.isNumber(id)){
    		way = 1;
    	}
    	if (NbUtil.isEmail(id)) {
    		way = 3;
		}
		
		// 2、获取admin
        XUser xUser = null;
        if(way == 1) {
        	xUser = xUserMapper.getById(id);
        }
        if(way == 2) {
        	xUser = xUserMapper.getByName(id);
        }
        if(way == 3) {
        	xUser = xUserMapper.getByMail(id);
        }
        

        // 3、开始验证
        if(xUser == null){
        	return AjaxJson.getError("无此账号");	
        }
        if(NbUtil.isNull(xUser.getPassword2())) {
        	return AjaxJson.getError("此账号尚未设置密码，无法登陆");
        }
        String md5Password = SystemObject.getPasswordMd5(xUser.getId(), password);
        if(!xUser.getPassword2().equals(md5Password)){
        	return AjaxJson.getError("密码错误");	
        }
        
        // 4、是否禁用
        if(xUser.getStatus() == 2) {
        	return AjaxJson.getError("此账号已被禁用，如有疑问，请联系管理员");	
        }

        // =========== 至此, 已登录成功 ============ 
        successLogin(xUser);
        StpUtil.setLoginId(xUser.getId());
        
        // 组织返回参数  
		SoMap map = new SoMap();
		map.put("xUser", xUser);
		map.put("per_list", spRolePermissionService.getPcodeByRid2(xUser.getRoleId()));
		map.put("tokenInfo", StpUtil.getTokenInfo());
		return AjaxJson.getSuccessData(map);	
	}
	
	
	/**
	 * 指定id的账号成功登录一次 （修改最后登录时间等数据 ）
	 * @param xUser
	 * @return
	 */
	public int successLogin(XUser xUser){
		String loginIp = WebNbUtil.getIP(SpringMVCUtil.getRequest());
		int line = spAccAdminMapper.successLogin(xUser.getId(), loginIp);
		if(line > 0) {
	        xUser.setLoginIp(loginIp);
	        xUser.setLoginTime(new Timestamp(System.currentTimeMillis()));
	        xUser.setLoginCount(xUser.getLoginCount() + 1);
		}
        return line;
	}
	
	/**
	 * 修改手机号  
	 * @param adminId
	 * @param newPhone
	 * @return
	 */
//	@Transactional(rollbackFor = Exception.class, propagation=Propagation.REQUIRED)
//	public AjaxJson updatePhone(String adminId, String newPhone) {
//		// 修改admin手机号
//		int line = SP.publicMapper.updateColumnById("sys_admin", "phone", newPhone, adminId);
//		return AjaxJson.getByLine(line);
//	}
	
	
	
	
}
