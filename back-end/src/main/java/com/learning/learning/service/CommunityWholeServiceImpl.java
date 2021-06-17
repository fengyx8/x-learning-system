package com.learning.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.entity.Comment;
import com.learning.learning.entity.Note;
import com.learning.learning.entity.Question;
import com.learning.learning.entity.User;
import com.learning.learning.grpc.CommunityWholeRequest;
import com.learning.learning.grpc.CommunityWholeResponse;
import com.learning.learning.grpc.CommunityWholeServiceGrpc;
import com.learning.learning.mapper.CommentMapper;
import com.learning.learning.mapper.LikeMapper;
import com.learning.learning.mapper.NoteMapper;
import com.learning.learning.mapper.QuestionMapper;
import com.learning.learning.mapper.UserMapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jbk-xiao
 * @version 2021-06-04-14:01
 */
@GRpcService
@Slf4j
@Service
public class CommunityWholeServiceImpl extends CommunityWholeServiceGrpc.CommunityWholeServiceImplBase {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final NoteMapper noteMapper;
    private final UserMapper userMapper;
    private final QuestionMapper questionMapper;
    private final LikeMapper likeMapper;
    private final CommentMapper commentMapper;
    public CommunityWholeServiceImpl(NoteMapper noteMapper, UserMapper userMapper, QuestionMapper questionMapper, LikeMapper likeMapper, CommentMapper commentMapper) {
        this.noteMapper = noteMapper;
        this.userMapper = userMapper;
        this.questionMapper = questionMapper;
        this.likeMapper = likeMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public void getNoteList(CommunityWholeRequest request, StreamObserver<CommunityWholeResponse> responseObserver) {
        List<Note> noteList = noteMapper.getPassedList();
        String noteListStr = gson.toJson(noteList);
        log.info("Get noteList: {}." + noteListStr);
        responseObserver.onNext(CommunityWholeResponse.newBuilder().setNoteList(noteListStr).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCommentList(CommunityWholeRequest request, StreamObserver<CommunityWholeResponse> responseObserver) {
        String noteId = request.getContentId();
        List<Comment> commentList = commentMapper.getCommentListByNoteId(noteId);
        String commentListStr = gson.toJson(commentList);
        log.info("Get commentList: {}", commentListStr);
        responseObserver.onNext(CommunityWholeResponse.newBuilder().setCommentList(commentListStr).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getScoreBoard(CommunityWholeRequest request, StreamObserver<CommunityWholeResponse> responseObserver) {
        List<User> scoreBoard = userMapper.getScoreBoard();
        String scoreBoardStr = gson.toJson(scoreBoard);
        log.info("Get scoreBoard: {}." + scoreBoardStr);
        responseObserver.onNext(CommunityWholeResponse.newBuilder().setScoreBoard(scoreBoardStr).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getQuestion(CommunityWholeRequest request, StreamObserver<CommunityWholeResponse> responseObserver) {
        String queId = request.getQueId();
        log.info("Request queId: {}", queId);
        Question question = questionMapper.getById(queId);
        String questionStr = gson.toJson(question);
        log.info("Get question: {}", questionStr);
        responseObserver.onNext(CommunityWholeResponse.newBuilder().setQuestion(questionStr).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getLikeList(CommunityWholeRequest request, StreamObserver<CommunityWholeResponse> responseObserver) {
        String contentId = request.getContentId();
        log.info("Get contentId: {}", contentId);
        List<String> likeList = likeMapper.getByContentId(contentId);
        String likeListStr = gson.toJson(likeList);
        log.info("Get likeList: {}", likeListStr);
        responseObserver.onNext(CommunityWholeResponse.newBuilder().setLikeList(likeListStr).build());
        responseObserver.onCompleted();
    }
}
