package com.learning.learning.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import com.learning.learning.config.satoken.AuthConst;
import com.learning.learning.grpc.CommunityLoggedServiceGrpc;
import com.learning.learning.grpc.UserInfoRequest;
import com.learning.learning.grpc.UserInfoResponse;
import com.learning.learning.pojo.UserInfo;
import com.learning.learning.util.sg.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author jbk-xiao
 * @version 2021-05-16-20:53
 */
@Slf4j
@CrossOrigin("*")
@RequestMapping("/community/")
@RestController
@Api(tags = "社群功能api")
public class CommunityLoggedController {
    private final CommunityLoggedServiceGrpc.CommunityLoggedServiceBlockingStub communityLoggedServiceBlockingStub;

    @Autowired
    public CommunityLoggedController(CommunityLoggedServiceGrpc.CommunityLoggedServiceBlockingStub communityLoggedServiceBlockingStub) {
        this.communityLoggedServiceBlockingStub = communityLoggedServiceBlockingStub;
    }

    @ApiOperation(value = "接收传入的用户id，并与已登录用户的token对比，匹配则返回用户主页所有信息。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "path")
    })
    @GetMapping("/userInfo/{userId}")
    public AjaxJson getUserInfo(@PathVariable("userId") String userId, HttpServletResponse response) {
        log.info("Get UserInfo: {}", userId);
        long start = System.currentTimeMillis();
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException e) {
            log.info("{} not login.", userId);
            response.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        log.info("Get loginId: {}", loginId);
        if (!loginId.equals(userId)) {
            response.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("用户信息不一致！");
        }
        int roleId = 2;
        if (StpUtil.hasRole(AuthConst.R1)) {
            roleId = 0;
        }
        if (StpUtil.hasRole(AuthConst.R2)) {
            roleId = 1;
        }
        UserInfoResponse userInfoResponse = this.communityLoggedServiceBlockingStub
                .getUserInfo(UserInfoRequest.newBuilder()
                        .setUserId(userId).setRoleId(roleId).build());
        String userInfo = userInfoResponse.getUserInfo();
        log.info("Response: {}, taking {}", userInfo, System.currentTimeMillis() - start);
        return AjaxJson.getSuccessData(new Gson().fromJson(userInfo, UserInfo.class));    }
}
