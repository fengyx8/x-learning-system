package com.learning.learning.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.service.satoken.SpAccAdminService;
import com.learning.learning.service.satoken.SpRolePermissionService;
import com.learning.learning.util.sg.AjaxJson;
import com.learning.learning.util.sg.NbUtil;
import com.learning.learning.util.so.SoMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * admin账号相关的接口 
 * @author jbk-xiao
 *
 */
@RestController
@RequestMapping("/AccAdmin/")
public class SpAccAdminController {
	
	private final SpAccAdminService spAccAdminService;
	
	private final SpRolePermissionService spRolePermissionService;

	public SpAccAdminController(SpAccAdminService spAccAdminService, SpRolePermissionService spRolePermissionService) {
		this.spAccAdminService = spAccAdminService;
		this.spRolePermissionService = spRolePermissionService;
	}


	/** 账号、密码登录  */
	@RequestMapping("doLogin")
	AjaxJson doLogin(String key, String password) {
		// 1、验证参数 
		if(NbUtil.isOneNull(key, password)) {
			return AjaxJson.getError("请提供key与password参数");
		}
		return spAccAdminService.doLogin(key, password);
	}
	
	
	/** 退出登录  */
	@RequestMapping("doExit")
	AjaxJson doExit() {
		StpUtil.logout();
		return AjaxJson.getSuccess();
	}
	

	/** 管理员登录后台时需要返回的信息 */
//	@RequestMapping("fristOpenAdmin")
//	AjaxJson fristOpenAdmin(HttpServletRequest request) {
//		// 当前user
//		XUser xUser = SpAdminUtil.getCurrAdmin();
//
//		// 组织参数 (admin信息，权限信息，配置信息)
//		SoMap map = new SoMap();
//		map.set("xUser", SpAdminUtil.getCurrAdmin());
//		map.set("per_list", spRolePermissionService.getPcodeByRid2(xUser.getRoleId()));
////		map.set("app_cfg", SpCfgUtil.getAppCfg());
//		return AjaxJson.getSuccessData(map);
//	}
}
