package com.learning.learning.service;

import com.learning.learning.entity.AnsRecord;
import com.learning.learning.entity.Like;
import com.learning.learning.entity.Question;
import com.learning.learning.entity.User;
import com.learning.learning.grpc.UserOperationRequest;
import com.learning.learning.grpc.UserOperationResponse;
import com.learning.learning.grpc.UserOperationServiceGrpc;
import com.learning.learning.mapper.AnsRecordMapper;
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

/**
 * @author jbk-xiao
 * @version 2021-06-05-10:10
 */
@GRpcService
@Slf4j
@Service
public class UserOperationServiceImpl extends UserOperationServiceGrpc.UserOperationServiceImplBase {
    private final NoteMapper noteMapper;
    private final CommentMapper commentMapper;
    private final LikeMapper likeMapper;
    private final UserMapper userMapper;
    private final AnsRecordMapper ansRecordMapper;
    private final QuestionMapper questionMapper;
    public UserOperationServiceImpl(NoteMapper noteMapper, CommentMapper commentMapper, LikeMapper likeMapper, UserMapper userMapper, AnsRecordMapper ansRecordMapper, QuestionMapper questionMapper) {
        this.noteMapper = noteMapper;
        this.commentMapper = commentMapper;
        this.likeMapper = likeMapper;
        this.userMapper = userMapper;
        this.ansRecordMapper = ansRecordMapper;
        this.questionMapper = questionMapper;
    }

    @Override
    public void postNote(UserOperationRequest request, StreamObserver<UserOperationResponse> responseObserver) {
        String content = request.getContent();
        String userId = request.getUserId();
        boolean status = true;
        try {
            noteMapper.add(content, userId);
        } catch (Exception e) {
            status = false;
        }
        responseObserver.onNext(UserOperationResponse.newBuilder().setIsUploaded(status).build());
        responseObserver.onCompleted();
    }

    @Override
    public void postComment(UserOperationRequest request, StreamObserver<UserOperationResponse> responseObserver) {
        String content = request.getContent();
        String userId = request.getUserId();
        String noteId = request.getNoteId();
        boolean status = true;
        try {
            commentMapper.add(content, userId, noteId);
        } catch (Exception e) {
            status = false;
        }
        responseObserver.onNext(UserOperationResponse.newBuilder().setIsUploaded(status).build());
        responseObserver.onCompleted();
    }

    @Override
    public void postLike(UserOperationRequest request, StreamObserver<UserOperationResponse> responseObserver) {
        Like like = new Like(request.getUserId(), request.getContentId());
        boolean status = true;
        try {
            likeMapper.add(like);
        } catch (Exception e) {
            status = false;
        }
        responseObserver.onNext(UserOperationResponse.newBuilder().setIsUploaded(status).build());
        responseObserver.onCompleted();
    }

    @Override
    public void postAnswer(UserOperationRequest request, StreamObserver<UserOperationResponse> responseObserver) {
        String queId = request.getQueId();
        String ans = request.getAns();
        String userId = request.getUserId();
        Question question;
        AnsRecord ansRecord;
        boolean status = true;
        boolean isCorrect = false;
        String analysis = "";
        try {
            question = questionMapper.getById(queId);
            analysis = question.getAnalysis();
            if (ans.equals(question.getStdAns())) {
                isCorrect = true;
                ansRecord = new AnsRecord(queId, userId, ans, true);
                Double points = question.getPoints();
                User user = userMapper.getUserInfoById(userId);
                user.setScore(user.getScore() + points);
                userMapper.update(user);
            }
            else {
                ansRecord = new AnsRecord(queId, userId, ans, false);
            }
            ansRecordMapper.add(ansRecord);
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        responseObserver.onNext(UserOperationResponse.newBuilder()
                .setIsUploaded(status).setIsCorrect(isCorrect).setAnalysis(analysis).build());
        responseObserver.onCompleted();
    }
}
