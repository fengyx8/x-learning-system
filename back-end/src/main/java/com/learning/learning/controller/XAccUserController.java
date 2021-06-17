package com.learning.learning.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.learning.learning.service.satoken.XAccUserService;
import com.learning.learning.service.satoken.XRolePermissionService;
import com.learning.learning.util.sg.AjaxJson;
import com.learning.learning.util.sg.NbUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


/**
 * 账号登入登出相关的接口
 * @author jbk-xiao
 */
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/xUser/")
@Api(tags = "用户登入登出api")
public class XAccUserController {

    private final XAccUserService xAccUserService;

    private final XRolePermissionService xRolePermissionService;

    public XAccUserController(XAccUserService xAccUserService, XRolePermissionService xRolePermissionService) {
        this.xAccUserService = xAccUserService;
        this.xRolePermissionService = xRolePermissionService;
    }


    /**
     * 账号、密码登录
     */
    @ApiOperation(value = "实现用户登录功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "用户ID或用户邮箱", required = true, paramType = "query",
                    defaultValue = "18372052"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query",
                    format = "password", defaultValue = "123456")
    })
    @PostMapping("doLogin")
    AjaxJson doLogin(@RequestParam(value = "key") String key, @RequestParam(value = "password") String password,
                     HttpServletResponse httpServletResponse) {
//	AjaxJson doLogin(@RequestBody JsonObject jsonObject) {
//		String key = jsonObject.get("key").toString();
//		String password = jsonObject.get("password").toString();
        log.info("{} logging in...", key);
        // 1、验证参数
        if (NbUtil.isOneNull(key, password)) {
            return AjaxJson.getError("请提供key与password参数");
        }
        return xAccUserService.doLogin(key, password, httpServletResponse);
    }


    /**
     * 退出登录
     */
    @ApiOperation(value = "退出登录")
    @PostMapping("doExit")
    AjaxJson doExit(HttpServletResponse httpServletResponse) {
        String id;
        try {
            id = StpUtil.getLoginId().toString();
        } catch (NotLoginException e) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        log.info("{} logging out...", id);
        StpUtil.logout();
        return AjaxJson.getSuccess();
    }


//TODO 大段注释
    /* 管理员登录后台时需要返回的信息 */
/*
	@RequestMapping("firstOpenAdmin")
	AjaxJson firstOpenAdmin(HttpServletRequest request) {
		// 当前user
		XUser xUser = SpAdminUtil.getCurrAdmin();

		// 组织参数 (admin信息，权限信息，配置信息)
		SoMap map = new SoMap();
		map.set("xUser", SpAdminUtil.getCurrAdmin());
		map.set("per_list", spRolePermissionService.getPcodeByRid2(xUser.getRoleId()));
//		map.set("app_cfg", SpCfgUtil.getAppCfg());
		return AjaxJson.getSuccessData(map);
	}
*/
}
