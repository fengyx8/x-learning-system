package com.learning.learning.service.satoken;

import com.learning.learning.mapper.satoken.XRolePermissionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色权限中间表 
 * @author jbk-xiao
 *
 */
@Service
public class XRolePermissionService {

	
	private final XRolePermissionMapper xRolePermissionMapper;

	public XRolePermissionService(XRolePermissionMapper xRolePermissionMapper) {
		this.xRolePermissionMapper = xRolePermissionMapper;
	}

	/**
	 * 获取指定角色的所有权限码 【增加缓存】
	 */
//    @Cacheable(value="api_pcode_list", key="#roleId")
    public List<String> getPcodeByRid(long roleId){
    	return xRolePermissionMapper.getPcodeByRoleId(roleId);
    }

	/**
	 * 获取指定角色的所有权限码 (Object类型)  【增加缓存】
	 */
//    @Cacheable(value="api_pcode_list2", key="#roleId")
    public List<Object> getPcodeByRid2(long roleId){
		List<String> codeList = xRolePermissionMapper.getPcodeByRoleId(roleId);
		return codeList.stream().map(String::valueOf).collect(Collectors.toList());				
    }

    /**
     * [T] 修改角色的一组权限关系	【清除缓存 】
     */
    @Transactional(rollbackFor = Exception.class)
//    @CacheEvict(value= {"api_pcode_list", "api_pcode_list2"}, key="#roleId")
    public int updateRoleMenu(long roleId, String[] pcodeArray){

    	// 万一为空 
    	if(pcodeArray == null){
    		pcodeArray = new String[0];
    	}
    	
    	// 先删
    	xRolePermissionMapper.deleteByRoleId(roleId);
    	
    	// 再添加
    	for(String pcode : pcodeArray){
    		xRolePermissionMapper.add(roleId, pcode);
        }
    	
    	// 返回
        return pcodeArray.length;
    }
	
	
	
}
