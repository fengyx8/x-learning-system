package com.learning.learning.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.grpc.UserOperationRequest;
import com.learning.learning.grpc.UserOperationResponse;
import com.learning.learning.grpc.UserOperationServiceGrpc;
import com.learning.learning.util.sg.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author jbk-xiao
 * @version 2021-06-02-14:54
 */
@Slf4j
@CrossOrigin("*")
@RequestMapping("/userOperation/")
@RestController
@Api(tags = "负责一般用户的社群内活动api")
public class UserOperationController {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final UserOperationServiceGrpc.UserOperationServiceBlockingStub userOperationServiceBlockingStub;

    public UserOperationController(UserOperationServiceGrpc.UserOperationServiceBlockingStub userOperationServiceBlockingStub) {
        this.userOperationServiceBlockingStub = userOperationServiceBlockingStub;
    }

    @ApiOperation(value = "一般用户激活账号（已登录状态）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true),
            @ApiImplicitParam(name = "secureQue", value = "密保问题", required = true),
            @ApiImplicitParam(name = "secureAns", value = "密保答案", required = true),
            @ApiImplicitParam(name = "password", value = "密码（无需原密码）", required = true),
            @ApiImplicitParam(name = "mail", value = "邮箱", required = true)
    })
    @PostMapping("/activeAccount")
    public AjaxJson activeAccount(@RequestParam("userId") String userId, @RequestParam("name") String name,
        @RequestParam("secureQue") String sercureQue, @RequestParam("secureAns") String sercureAns,
        @RequestParam("password") String password, @RequestParam("mail") String mail,
                                  HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException e) {
            log.info("Not login...");
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        log.info("Get loginId: {}.", loginId);
        if (!loginId.equals(userId)) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_JUR);
            return AjaxJson.getNotJur("学号输入有误！");
        }
        UserOperationResponse userOperationResponse = this.userOperationServiceBlockingStub.activeAccount(
                UserOperationRequest.newBuilder()
                        .setUserId(userId).setName(name)
                        .setSecureQue(sercureQue).setSecureAns(sercureAns)
                        .setPassword(password).setMail(mail).build()
        );
        boolean isUploaded = userOperationResponse.getIsUploaded();
        log.info("Response: {}, taking {} ms.", isUploaded, System.currentTimeMillis() - start);
        if (isUploaded) {
            return AjaxJson.getSuccess();
        } else {
            httpServletResponse.setStatus(AjaxJson.CODE_ERROR);
            return AjaxJson.getError("激活失败");
        }
    }

    @ApiOperation(value = "一般用户或管理员修改密码（已登录状态）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPw", value = "原来的密码", required = true),
            @ApiImplicitParam(name = "newPw", value = "新的密码", required = true)
    })
    @PutMapping("/password")
    public AjaxJson changePassword(@RequestParam("oldPw") String oldPw, @RequestParam("newPw") String newPw,
                                   HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException e) {
            log.info("Not login...");
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        log.info("Get loginId: {}.", loginId);
        UserOperationResponse userOperationResponse = this.userOperationServiceBlockingStub.changePassword(
                UserOperationRequest.newBuilder()
                        .setUserId(loginId).setPassword(oldPw).setNewPassword(newPw)
                        .build()
        );
        boolean isUploaded = userOperationResponse.getIsUploaded();
        log.info("Response: {}, taking {} ms.", isUploaded, System.currentTimeMillis() - start);
        if (isUploaded) {
            return AjaxJson.getSuccess();
        } else {
            httpServletResponse.setStatus(AjaxJson.CODE_ERROR);
            return AjaxJson.getError("修改失败");
        }
    }

    @ApiOperation(value = "一般用户忘记密码（未登录状态）")
    @PutMapping("/forgetPassword")
    public AjaxJson forgetPassword(@RequestParam("userId") String userId, @RequestParam("secureQue") String sercureQue,
                       @RequestParam("secureAns") String sercureAns, @RequestParam("password") String password,
                                   HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        UserOperationResponse userOperationResponse = this.userOperationServiceBlockingStub.forgetPassword(
                UserOperationRequest.newBuilder()
                        .setUserId(userId).setSecureQue(sercureQue).setSecureAns(sercureAns)
                        .setPassword(password).build()
        );
        boolean isUploaded = userOperationResponse.getIsUploaded();
        log.info("Response: {}, taking {} ms.", isUploaded, System.currentTimeMillis() - start);
        if (isUploaded) {
            return AjaxJson.getSuccess();
        } else {
            httpServletResponse.setStatus(AjaxJson.CODE_ERROR);
            return AjaxJson.getError("重置失败，请联系管理员。");
        }
    }

    @ApiOperation(value = "一般用户发布心得，待管理员审核通过后加2分。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content", value = "心得内容", required = true)
    })
    @PostMapping("/note")
    public AjaxJson postNote(@RequestParam(value = "content") String content, HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException e) {
            log.info("Not login...");
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        log.info("Get loginId: {}.", loginId);
        log.info("Get note content: {}.", content);
        UserOperationResponse userOperationResponse = this.userOperationServiceBlockingStub.postNote(
                UserOperationRequest.newBuilder()
                        .setUserId(loginId).setContent(content).build());
        boolean isUploaded = userOperationResponse.getIsUploaded();
        log.info("Response: {}, taking {} ms.", isUploaded, System.currentTimeMillis() - start);
        if (isUploaded) {
            return AjaxJson.getSuccess();
        } else {
            httpServletResponse.setStatus(AjaxJson.CODE_ERROR);
            return AjaxJson.getError("上传失败");
        }
    }

    @ApiOperation(value = "一般用户对心得发布评论，待管理员审核通过后加1分。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noteId", value = "评论对应的心得ID", required = true),
            @ApiImplicitParam(name = "content", value = "对心得评论的内容", required = true)
    })
    @PostMapping("/comment")
    public AjaxJson postComment(@RequestParam("noteId") String noteId, @RequestParam("content") String content,
                                HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException e) {
            log.info("Not login...");
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        log.info("Get loginId: {}.", loginId);
        log.info("Get comment: \"{}\" for note: {}", content, noteId);
        UserOperationResponse userOperationResponse = this.userOperationServiceBlockingStub.postComment(
                UserOperationRequest.newBuilder()
                        .setUserId(loginId).setContent(content).setNoteId(noteId).build());
        boolean isUploaded = userOperationResponse.getIsUploaded();
        log.info("Response: {}, taking {} ms.", isUploaded, System.currentTimeMillis() - start);
        if (isUploaded) {
            return AjaxJson.getSuccess();
        } else {
            httpServletResponse.setStatus(AjaxJson.CODE_ERROR);
            return AjaxJson.getError("上传失败");
        }
    }

    @ApiOperation(value = "一般用户对心得或评论进行点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "心得/评论ID", required = true)
    })
    @PostMapping("/like")
    public AjaxJson postLike(@RequestParam("contentId") String contentId, HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException e) {
            log.info("Not login...");
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        log.info("Get loginId: {}, contentId: {}.", loginId, contentId);
        UserOperationResponse userOperationResponse = this.userOperationServiceBlockingStub.postLike(
                UserOperationRequest.newBuilder()
                        .setUserId(loginId).setContentId(contentId)
                        .build());
        boolean isUploaded = userOperationResponse.getIsUploaded();
        log.info("Response: {}, taking {} ms.", isUploaded, System.currentTimeMillis() - start);
        if (isUploaded) {
            return AjaxJson.getSuccess();
        } else {
            httpServletResponse.setStatus(AjaxJson.CODE_ERROR);
            return AjaxJson.getError();
        }
    }

    @ApiOperation(value = "一般用户进行答题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queId", value = "问题ID", required = true),
            @ApiImplicitParam(name = "ans", value = "回答", required = true)
    })
    @PostMapping("/answer")
    public AjaxJson postAnswer(@RequestParam("queId") String queId, @RequestParam("ans") String ans,
                               HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        String loginId;
        try {
            loginId = StpUtil.getLoginIdAsString();
        } catch (NotLoginException e) {
            log.info("Not login...");
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        log.info("Get loginId: {}.", loginId);
        log.info("Get queId: {}.", queId);
        log.info("Get ans: \"{}\"", ans);
        UserOperationResponse userOperationResponse = this.userOperationServiceBlockingStub.postAnswer(
                UserOperationRequest.newBuilder()
                        .setUserId(loginId).setQueId(queId).setAns(ans).build());
        boolean isUploaded = userOperationResponse.getIsUploaded();
        boolean isCorrect = userOperationResponse.getIsCorrect();
        String analysis = userOperationResponse.getAnalysis();
        log.info("Response: state:{}, correct:{}, analysis:{}, taking {} ms.", isUploaded, isCorrect, analysis, System.currentTimeMillis() - start);
        if (isUploaded) {
            @Data
            class AnsResult{
                public AnsResult(boolean success, boolean correct, String analyse) {
                    this.analyse = analyse;
                    this.correct = correct;
                    this.success = success;
                }
                final boolean success;
                final boolean correct;
                final String analyse;
            }
            return AjaxJson.getSuccessData(new AnsResult(isUploaded, isCorrect, analysis));
        } else {
            httpServletResponse.setStatus(AjaxJson.CODE_ERROR);
            return AjaxJson.getError("UFO绑架了您的答题记录");
        }
    }
}
