package com.learning.learning.config;

import cn.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 有关当前项目的一些全局工具方法封装 
 * @author jbk-xiao
 *
 */
@Component
public class SystemObject {

	// ===================================== 一些二次封装的方法 ===================================================
	
	/** 返回md5加密后的密码，根据当前配置的salt
	 *   格式为： md5(salt + userid + password) 
	 */ 
	public static String getPasswordMd5(String userId, String password) {
		return SecureUtil.md5(config.getMd5Salt() + userId + password).toUpperCase();
	}
	
	/** 返回md5加密后的密码，根据当前配置的salt
	 *  格式为： md5(salt + 0 + password) 
	 */ 
	public static String getPasswordMd5(String password) {
		return getPasswordMd5("0", password);
	}
	
	
	
	// ===================================== yml自定义配置信息 ===================================================
	
	public static com.learning.learning.config.MyConfig config;
	@Autowired
	void setMyConfig(com.learning.learning.config.MyConfig config) {
		SystemObject.config = config;
	}
		
	
}
