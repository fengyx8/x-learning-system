package com.learning.learning.mapper.satoken;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 账号相关 
 * @author jbk-xiao
 *
 */
@Mapper
public interface XAccUserMapper {

	/**
	 * 指定id的账号成功登录一次 
	 * @param id
	 * @param loginIp
	 * @return
	 */
	public int successLogin(@Param("id")String id, @Param("loginIp")String loginIp);
	
}
