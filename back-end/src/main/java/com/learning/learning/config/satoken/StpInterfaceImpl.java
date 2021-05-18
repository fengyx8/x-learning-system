package com.learning.learning.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.learning.learning.mapper.satoken.XUserMapper;
import com.learning.learning.service.satoken.SpRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义权限验证接口扩展 
 * @author jbk-xiao
 *
 */
@Component	
public class StpInterfaceImpl implements StpInterface {

	
	private final XUserMapper XUserMapper;
	
	private final SpRolePermissionService spRolePermissionService;

	public StpInterfaceImpl(XUserMapper XUserMapper, SpRolePermissionService spRolePermissionService) {
		this.XUserMapper = XUserMapper;
		this.spRolePermissionService = spRolePermissionService;
	}

	/** 返回一个账号所拥有的权限码集合  */
	@Override
	public List<String> getPermissionList(Object loginId, String loginKey) {
		if(loginKey.equals("login")) {
			long roleId = XUserMapper.getById(loginId.toString()).getRoleId();
			return spRolePermissionService.getPcodeByRid(roleId);								
		}
		return null;
	}
	
	/** 返回一个账号所拥有的角色标识集合  */
	@Override
	public List<String> getRoleList(Object loginId, String loginKey) {
		return null;
	}

}
