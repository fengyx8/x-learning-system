package com.learning.learning.controller;

import com.learning.learning.util.sg.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "管理员进行评论、心得的审核")
    @PutMapping("/ncStatus")
    public AjaxJson putNCStatus() {
        //TODO 完成管理员审核逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "用户积分“强制管理”")
    @PutMapping("/score")
    public AjaxJson putScore() {
        //TODO 完成管理员修改用户积分逻辑
        return AjaxJson.getSuccess();
    }
    /**
     *   一般用户增删改查：单用户/多用户，controller层获取传输的内容，service层进行单用户添加及循环单用户方法多用户添加。
     */

    @ApiOperation(value = "管理员添加单个一般用户")
    @PostMapping("/user")
    public AjaxJson postUser() {
        //TODO 完成管理员添加单个用户逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员批量添加一般用户")
    @PostMapping("/users")
    public AjaxJson postUsers() {
        //TODO 完成管理员批量添加用户逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员删除单个用户")
    @DeleteMapping("/user")
    public AjaxJson deleteUser() {
        //TODO 完成管理员删除单个用户逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员批量删除用户")
    @DeleteMapping("/users")
    public AjaxJson deleteUsers() {
        //TODO 完成管理员批量删除用户逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员更新单个用户信息")
    @PutMapping("/user")
    public AjaxJson putUser() {
        //TODO 完成管理员更新单个用户信息逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员批量更新用户信息")
    @PutMapping("/users")
    public AjaxJson putUsers() {
        //TODO 完成管理员批量更新用户信息逻辑
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员查询单个用户信息")
    @GetMapping("/user")
    public AjaxJson getUser() {
        //TODO 完成管理员查询单个用户信息接口
        return AjaxJson.getSuccess();
    }

    @ApiOperation(value = "管理员批量查询用户信息")
    @GetMapping("/users")
    public AjaxJson getUsers() {
        //TODO 完成管理员批量查询用户信息接口
        return AjaxJson.getSuccess();
    }
}
