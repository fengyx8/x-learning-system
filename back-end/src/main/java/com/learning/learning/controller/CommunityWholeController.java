package com.learning.learning.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.learning.learning.entity.Comment;
import com.learning.learning.entity.Note;
import com.learning.learning.entity.Question;
import com.learning.learning.entity.User;
import com.learning.learning.grpc.CommunityWholeRequest;
import com.learning.learning.grpc.CommunityWholeResponse;
import com.learning.learning.grpc.CommunityWholeServiceGrpc;
import com.learning.learning.util.sg.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author jbk-xiao
 * @version 2021-06-01-15:49
 */
@Slf4j
@CrossOrigin("*")
@RequestMapping("/communityWhole/")
@RestController
@Api(tags = "社群已登录用户公用api")
public class CommunityWholeController {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final CommunityWholeServiceGrpc.CommunityWholeServiceBlockingStub communityWholeServiceBlockingStub;

    public CommunityWholeController(CommunityWholeServiceGrpc.CommunityWholeServiceBlockingStub communityWholeServiceBlockingStub) {
        this.communityWholeServiceBlockingStub = communityWholeServiceBlockingStub;
    }

    @ApiOperation(value = "查询社群中所有用户发布的心得，展示出来")
    @GetMapping("/noteList")
    public AjaxJson getNoteList(HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        try {
            StpUtil.checkLogin();
        } catch (NotLoginException notLoginException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        CommunityWholeResponse communityWholeResponse = this.communityWholeServiceBlockingStub
                .getNoteList(CommunityWholeRequest.newBuilder()
                        .build());
        String noteList = communityWholeResponse.getNoteList();
        log.info("Response: {}, taking {}", noteList, System.currentTimeMillis() - start);
        return AjaxJson.getSuccessData(gson.fromJson(noteList, new TypeToken<List<Note>>() {}.getType()));
    }
    @ApiOperation(value = "通过noteId查找心得所对应的评论列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noteId", value = "心得Id", required = true, paramType = "path")
    })
    @GetMapping("/commentList/{noteId}")
    public AjaxJson getCommentList(@PathVariable("noteId") String noteId, HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        try {
            StpUtil.checkLogin();
        } catch (NotLoginException notLoginException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        CommunityWholeResponse communityWholeResponse = this.communityWholeServiceBlockingStub.getCommentList(
                CommunityWholeRequest.newBuilder().setContentId(noteId).build()
        );
        String commentList = communityWholeResponse.getCommentList();
        log.info("Get commentList of {}, return: {}", noteId, commentList);
        return AjaxJson.getSuccessData(gson.fromJson(commentList, new TypeToken<List<Comment>>() {}.getType()));
    }
    @ApiOperation(value = "查询社群中所有用户的积分，返回积分列表")
    @GetMapping("/scoreBoard")
    public AjaxJson getScoreBoard(HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        try {
            StpUtil.checkLogin();
        } catch (NotLoginException notLoginException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        CommunityWholeResponse communityWholeResponse = this.communityWholeServiceBlockingStub.getScoreBoard(
                CommunityWholeRequest.newBuilder()
                        .build());
        String scoreBroad = communityWholeResponse.getScoreBoard();
        log.info("Response: {}, taking {}", scoreBroad, System.currentTimeMillis() - start);
        return AjaxJson.getSuccessData(gson.fromJson(scoreBroad, new TypeToken<List<User>>() {}.getType()));
    }

    @ApiOperation(value = "根据题目id获取一道题目的所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queId", value = "题目ID", required = true, paramType = "path")
    })
    @GetMapping("/question/{queId}")
    public AjaxJson getQuestion(@PathVariable("queId") String queId, HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        try {
            StpUtil.checkLogin();
        } catch (NotLoginException notLoginException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        CommunityWholeResponse communityWholeResponse = this.communityWholeServiceBlockingStub.getQuestion(
                CommunityWholeRequest.newBuilder()
                        .setQueId(queId).build());
        String question = communityWholeResponse.getQuestion();
        log.info("Response: {}, taking {}", question, System.currentTimeMillis() - start);
        return AjaxJson.getSuccessData(gson.fromJson(question, Question.class));
    }

    @ApiOperation(value = "根据评论/心得ID获取其点赞用户ID列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "心得/评论ID", required = true, paramType = "path")
    })
    @GetMapping("/likeList/{contentId}")
    public AjaxJson getLikeList(@PathVariable("contentId") String contentId, HttpServletResponse httpServletResponse) {
        long start = System.currentTimeMillis();
        try {
            StpUtil.checkLogin();
        } catch (NotLoginException notLoginException) {
            httpServletResponse.setStatus(AjaxJson.CODE_NOT_LOGIN);
            return AjaxJson.getNotLogin();
        }
        CommunityWholeResponse communityWholeResponse = this.communityWholeServiceBlockingStub.getLikeList(
                CommunityWholeRequest.newBuilder()
                        .setContentId(contentId).build());
        String likeList = communityWholeResponse.getLikeList();
        log.info("Response: {}, taking {}", likeList, System.currentTimeMillis() - start);
        return AjaxJson.getSuccessData(gson.fromJson(likeList, new TypeToken<List<String>>() {}.getType()));
    }
}
