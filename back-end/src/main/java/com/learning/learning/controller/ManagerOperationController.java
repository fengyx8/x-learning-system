package com.learning.learning.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.config.satoken.AuthConst;
import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.grpc.ManagerOperationRequest;
import com.learning.learning.grpc.ManagerOperationResponse;
import com.learning.learning.grpc.ManagerOperationServiceGrpc;
import com.learning.learning.util.sg.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author jbk-xiao
 * @version 2021-06-02-14:55
 */
@Slf4j
@CrossOrigin("*")
@RequestMapping("/managerOperation/")
@RestController
@Api(tags = "负责管理员用户的社群内活动api")
public class ManagerOperationController {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final ManagerOperationServiceGrpc.ManagerOperationServiceBlockingStub managerOperationServiceBlockingStub;

    public ManagerOperationController(ManagerOperationServiceGrpc.ManagerOperationServiceBlockingStub managerOperationServiceBlockingStub) {
        this.managerOperationServiceBlockingStub = managerOperationServiceBlockingStub;
    }

    @ApiOperation(value = "管理员进行评论、心得的审核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "心得/评论ID"),
            @ApiImplicitParam(name = "isChecked", value = "是否审核通过", dataType = "boolean", defaultValue = "true")
    })
    @PutMapping("/ncStatus")
    public AjaxJson putNCStatus(@RequestParam("contentId") String contentId, @RequestParam("isChecked") boolean isChecked,
                                HttpServletResponse httpServletResponse) {
        try {
            StpUtil.hasPermission(AuthConst.R1);
        } catch (NotRoleException notRoleException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("不是管理员。");
        }
        if (contentId.isEmpty() || (contentId.charAt(0) != 'n' && contentId.charAt(0) != 'c')) {
            httpServletResponse.setStatus(AjaxJson.CODE_INVALID_REQUEST);
            return AjaxJson.get(AjaxJson.CODE_INVALID_REQUEST, "Wrong contentId!");
        }
        ManagerOperationResponse managerOperationResponse = this.managerOperationServiceBlockingStub.putNCStatus(
                ManagerOperationRequest.newBuilder().setContentId(contentId).setIsChecked(isChecked).build());
        boolean isCompleted = managerOperationResponse.getIsCompleted();
        if (isCompleted) {
            return AjaxJson.getSuccess();
        } else {
            httpServletResponse.setStatus(AjaxJson.CODE_ERROR);
            return AjaxJson.getError();
        }
    }

    @ApiOperation(value = "用户积分“强制管理”")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deltaScore", value = "积分变化量，正或负", dataType = "double", defaultValue = "0",
                    example = "0"),
            @ApiImplicitParam(name = "userId", value = "要修改积分的用户的ID")
    })
    @PutMapping("/score")
    public AjaxJson putScore(@RequestParam("deltaScore") double deltaScore, @RequestParam("userId") String userId,
                             HttpServletResponse httpServletResponse) {
        try {
            StpUtil.hasPermission(AuthConst.R1);
        } catch (NotRoleException notRoleException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("不是管理员。");
        }
        ManagerOperationResponse managerOperationResponse = this.managerOperationServiceBlockingStub.putScore(
                ManagerOperationRequest.newBuilder().setDeltaScore(deltaScore).setUserId(userId).build());
        boolean isCompleted = managerOperationResponse.getIsCompleted();
        if (isCompleted) {
            return AjaxJson.getSuccess();
        } else {
            return AjaxJson.getError();
        }
    }
    /**
     *   一般用户增删改查：单用户/多用户，controller层获取传输的内容，service层进行单用户添加及循环单用户方法多用户添加。
     */

    @ApiOperation(value = "管理员添加单个一般用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户学号", required = true),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true),
            @ApiImplicitParam(name = "password", value = "用户初始密码", required = true)
    })
    @PostMapping("/xUser")
    public AjaxJson postXUser(@RequestParam("userId") String id, @RequestParam("name") String name,
                              @RequestParam("password") String pw, HttpServletResponse httpServletResponse) {
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException nle) {
            log.warn(nle.toString());
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        if (!StpUtil.hasPermission(AuthConst.R1)) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("不是管理员！");
        }

        ManagerOperationResponse managerOperationResponse = this.managerOperationServiceBlockingStub.operateXUser(
                ManagerOperationRequest.newBuilder()
                        .setOperation(ManagerOperationRequest.Operations.INSERT)
                        .setUserId(id)
                        .setName(name)
                        .setPassword(pw)
                        .setLoginId(loginId)
                        .build()
        );
        boolean isCompleted = managerOperationResponse.getIsCompleted();
        if (isCompleted) {
            return AjaxJson.getSuccess();
        } else {
            return AjaxJson.getError();
        }
    }

    @ApiOperation(value = "管理员批量添加一般用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "xUsersTable", value = "初始化用户excel表，包括userId、name、password三列，"
                                                            + "确保文件后缀为xls或xlsx",
            dataType = "__file", paramType = "form")
    })
    @PostMapping("/xUsers")
    public AjaxJson postXUsers(@RequestParam("xUsersTable") MultipartFile xUsersTable,
                               HttpServletResponse httpServletResponse) {
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException nle) {
            log.warn(nle.toString());
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        if (!StpUtil.hasPermission(AuthConst.R1)) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("不是管理员！");
        }

        String table = xUsersTable.getOriginalFilename();
        log.info("Received table: {}" + table);
        if (table == null || table.isEmpty() || (!table.endsWith("xls") && !table.endsWith("xlsx"))) {
            httpServletResponse.setStatus(AjaxJson.CODE_INVALID_REQUEST);
            return AjaxJson.get(AjaxJson.CODE_INVALID_REQUEST, "文件类型错误！");
        }

        ExcelReader excelReader;
        try {
            excelReader = ExcelUtil.getReader(xUsersTable.getInputStream());
        } catch (IOException e) {
            httpServletResponse.setStatus(AjaxJson.CODE_INVALID_REQUEST);
            return AjaxJson.get(AjaxJson.CODE_INVALID_REQUEST, "请检查文件内容是否符合要求！");
        }

        List<Map<String, Object>> xUsers = excelReader.readAll();
        if (xUsers.isEmpty() || !xUsers.get(0).containsKey("userId")
            || !xUsers.get(0).containsKey("password") || !xUsers.get(0).containsKey("name")) {
            httpServletResponse.setStatus(AjaxJson.CODE_INVALID_REQUEST);
            return AjaxJson.get(AjaxJson.CODE_INVALID_REQUEST, "请检查文件内容是否符合要求！");
        }

        String xUsersInfo = gson.toJson(xUsers);
        log.info("Received: {}", xUsersInfo);
        ManagerOperationResponse managerOperationResponse = this.managerOperationServiceBlockingStub.operateXUsers(
                ManagerOperationRequest.newBuilder()
                        .setXUsersInfo(xUsersInfo)
                        .setLoginId(loginId)
                        .setOperation(ManagerOperationRequest.Operations.INSERT).build()
        );
        boolean isCompleted = managerOperationResponse.getIsCompleted();
        if (isCompleted) {
            return AjaxJson.getSuccess();
        } else {
            return AjaxJson.getError();
        }
    }

    @ApiOperation(value = "管理员删除单个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "要删除用户的用户ID", required = true, paramType = "path")
    })
    @DeleteMapping("/xUser/{userId}")
    public AjaxJson deleteXUser(@PathVariable("userId") String userId, HttpServletResponse httpServletResponse) {
        try {
            StpUtil.hasPermission(AuthConst.R1);
        } catch (NotRoleException notRoleException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("不是管理员。");
        }
        ManagerOperationResponse managerOperationResponse = this.managerOperationServiceBlockingStub.operateXUser(
                ManagerOperationRequest.newBuilder()
                        .setOperation(ManagerOperationRequest.Operations.DELETE)
                        .setUserId(userId)
                        .build()
        );
        boolean isCompleted = managerOperationResponse.getIsCompleted();
        if (isCompleted) {
            return AjaxJson.getSuccess();
        } else {
            return AjaxJson.getError();
        }
    }

    @ApiOperation(value = "（空）管理员批量删除用户")
    @DeleteMapping("/xUsers")
    public AjaxJson deleteXUsers() {
        //TODO （考虑删除）完成管理员批量删除用户逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员更新单个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户学号", required = true),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true),
            @ApiImplicitParam(name = "password", value = "用户初始密码", required = true)
    })@PutMapping("/xUser")
    public AjaxJson putXUser(@RequestParam("userId") String id, @RequestParam("name") String name,
                             @RequestParam("password") String pw, HttpServletResponse httpServletResponse) {
        try {
            StpUtil.hasPermission(AuthConst.R1);
        } catch (NotRoleException notRoleException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("不是管理员。");
        }
        ManagerOperationResponse managerOperationResponse = this.managerOperationServiceBlockingStub.operateXUser(
                ManagerOperationRequest.newBuilder()
                        .setOperation(ManagerOperationRequest.Operations.UPDATE)
                        .setUserId(id)
                        .setName(name)
                        .setPassword(pw)
                        .build()
        );
        boolean isCompleted = managerOperationResponse.getIsCompleted();
        if (isCompleted) {
            return AjaxJson.getSuccess();
        } else {
            return AjaxJson.getError();
        }
    }

    @ApiOperation(value = "（空）管理员批量更新用户信息")
    @PutMapping("/xUsers")
    public AjaxJson putXUsers() {
        //TODO （考虑删除）完成管理员批量更新用户信息逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员查询单个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "要查找用户的用户ID", required = true, paramType = "path")
    })
    @GetMapping("/xUser/{userId}")
    public AjaxJson getXUser(@PathVariable("userId") String userId, HttpServletResponse httpServletResponse) {
        try {
            StpUtil.hasPermission(AuthConst.R1);
        } catch (NotRoleException notRoleException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("不是管理员。");
        }
        ManagerOperationResponse managerOperationResponse = this.managerOperationServiceBlockingStub.operateXUser(
                ManagerOperationRequest.newBuilder()
                        .setOperation(ManagerOperationRequest.Operations.SELECT)
                        .setUserId(userId).build()
        );
        String xUserInfo = managerOperationResponse.getXUserInfo();
        return AjaxJson.getSuccessData(gson.fromJson(xUserInfo, XUser.class));
    }

    @ApiOperation(value = "管理员批量查询用户信息")
    @GetMapping("/xUsers")
    public AjaxJson getXUsers(HttpServletResponse httpServletResponse) {
        try {
            StpUtil.hasPermission(AuthConst.R1);
        } catch (NotRoleException notRoleException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("不是管理员。");
        }
        ManagerOperationResponse managerOperationResponse = this.managerOperationServiceBlockingStub.operateXUsers(
                ManagerOperationRequest.newBuilder()
                        .setOperation(ManagerOperationRequest.Operations.SELECT)
                        .build()
        );
        String xUserInfo = managerOperationResponse.getXUserInfo();
        return AjaxJson.getSuccessData(gson.fromJson(xUserInfo, new TypeToken<List<XUser>>() {}.getType()));
    }
}
