package com.learning.learning.service;

import com.learning.learning.config.SystemObject;
import com.learning.learning.entity.AnsRecord;
import com.learning.learning.entity.Like;
import com.learning.learning.entity.Question;
import com.learning.learning.entity.User;
import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.grpc.UserOperationRequest;
import com.learning.learning.grpc.UserOperationResponse;
import com.learning.learning.grpc.UserOperationServiceGrpc;
import com.learning.learning.mapper.AnsRecordMapper;
import com.learning.learning.mapper.CommentMapper;
import com.learning.learning.mapper.LikeMapper;
import com.learning.learning.mapper.NoteMapper;
import com.learning.learning.mapper.QuestionMapper;
import com.learning.learning.mapper.UserMapper;
import com.learning.learning.mapper.satoken.XUserMapper;
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
    private final XUserMapper xUserMapper;
    public UserOperationServiceImpl(NoteMapper noteMapper, CommentMapper commentMapper, LikeMapper likeMapper, UserMapper userMapper, AnsRecordMapper ansRecordMapper, QuestionMapper questionMapper, XUserMapper xUserMapper) {
        this.noteMapper = noteMapper;
        this.commentMapper = commentMapper;
        this.likeMapper = likeMapper;
        this.userMapper = userMapper;
        this.ansRecordMapper = ansRecordMapper;
        this.questionMapper = questionMapper;
        this.xUserMapper = xUserMapper;
    }

    @Override
    public void activeAccount(UserOperationRequest request, StreamObserver<UserOperationResponse> responseObserver) {
        String userId = request.getUserId();
        String name = request.getName();
        String secureQue = request.getSecureQue();
        String secureAns = request.getSecureAns();
        String password = request.getPassword();
        String mail = request.getMail();
        String sPassword = SystemObject.getPasswordMd5(userId, password);
        boolean isUploaded = true;
        try {
            xUserMapper.updatePassword(userId, sPassword, password);
            User user = new User(userId, name, secureQue, secureAns, mail, "信息管理学院", .0);
            userMapper.add(user);
        } catch (Exception e) {
            log.error(e.toString());
            isUploaded = false;
        }
        responseObserver.onNext(UserOperationResponse.newBuilder().setIsUploaded(isUploaded).build());
        responseObserver.onCompleted();
    }

    @Override
    public void changePassword(UserOperationRequest request, StreamObserver<UserOperationResponse> responseObserver) {
        String userId = request.getUserId();
        String password = request.getPassword();
        String newPassword = request.getNewPassword();
        boolean isUploaded = true, isCorrect = true;
        XUser xUser = xUserMapper.getById(userId);
//        if (newPassword.equals(xUser.getPassword2())) {
            String sPassword = SystemObject.getPasswordMd5(userId, newPassword);
            try {
                xUserMapper.updatePassword(userId, sPassword, newPassword);
            } catch (Exception e) {
                isUploaded = false;
            }
//        } else {
//            isCorrect = false;
//            isUploaded = false;
//        }
        log.info("isCorrect? {}, isUploaded? {}.", isCorrect, isUploaded);
        responseObserver.onNext(UserOperationResponse.newBuilder()
                .setIsCorrect(isCorrect).setIsUploaded(isUploaded).build());
        responseObserver.onCompleted();
    }

    @Override
    public void forgetPassword(UserOperationRequest request, StreamObserver<UserOperationResponse> responseObserver) {
        String userId = request.getUserId();
        String secureQue = request.getSecureQue();
        String secureAns = request.getSecureAns();
        String password = request.getPassword();
        boolean isUploaded = true;
        try {
            User user = userMapper.getUserInfoById(userId);
            if (secureQue.equals(user.getSecureQue()) && secureAns.equals(user.getSecureAns())) {
                String sPassword = SystemObject.getPasswordMd5(userId, password);
                xUserMapper.updatePassword(userId, sPassword, password);
            } else {
                isUploaded = false;
            }
        } catch (Exception e) {
            isUploaded = false;
        }
        log.warn("{} reset password: {}", userId, password);
        responseObserver.onNext(UserOperationResponse.newBuilder().setIsUploaded(isUploaded).build());
        responseObserver.onCompleted();
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
        String userId = request.getUserId();
        String contentId = request.getContentId();
        log.info("Get userId: {}, contentId: {}.", userId, contentId);
        Like like = new Like(userId, contentId);
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
            question.setAnswererNumber(question.getAnswererNumber() + 1);
            if (ans.equals(question.getStdAns())) {
                isCorrect = true;
                question.setCorrectAnsNumber(question.getCorrectAnsNumber() + 1);
                ansRecord = new AnsRecord(queId, userId, ans, true);
                Double points = question.getPoints();
                User user = userMapper.getUserInfoById(userId);
                user.setScore(user.getScore() + points);
                userMapper.update(user);
            }
            else {
                ansRecord = new AnsRecord(queId, userId, ans, false);
            }
            questionMapper.update(question);
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
