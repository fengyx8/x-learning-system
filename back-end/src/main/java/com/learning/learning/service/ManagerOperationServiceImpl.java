package com.learning.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.grpc.ManagerOperationRequest;
import com.learning.learning.grpc.ManagerOperationResponse;
import com.learning.learning.grpc.ManagerOperationServiceGrpc;
import com.learning.learning.mapper.CommentMapper;
import com.learning.learning.mapper.NoteMapper;
import com.learning.learning.mapper.UserMapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author jbk-xiao
 * @version 2021-06-06-22:00
 */
@GRpcService
@Slf4j
@Service
public class ManagerOperationServiceImpl extends ManagerOperationServiceGrpc.ManagerOperationServiceImplBase {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final NoteMapper noteMapper;
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;
    private final OperateXUserService operateXUserService;
    public ManagerOperationServiceImpl(NoteMapper noteMapper, CommentMapper commentMapper, UserMapper userMapper, OperateXUserService operateXUserService) {
        this.noteMapper = noteMapper;
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
        this.operateXUserService = operateXUserService;
    }

    @Override
    public void putNCStatus(ManagerOperationRequest request, StreamObserver<ManagerOperationResponse> responseObserver) {
        String contentId = request.getContentId();
        boolean isChecked = request.getIsChecked();
        int status = isChecked ? 1 : 2;
        boolean isCompleted = true;
        try {
            if (contentId.charAt(0) == 'n') {
                this.noteMapper.updateStatus(contentId, status);
            } else {
                this.commentMapper.updateStatus(contentId, status);
            }
        } catch (Exception e) {
            isCompleted = false;
        }
        responseObserver.onNext(ManagerOperationResponse.newBuilder().setIsCompleted(isCompleted).build());
        responseObserver.onCompleted();
    }

    @Override
    public void putScore(ManagerOperationRequest request, StreamObserver<ManagerOperationResponse> responseObserver) {
        double deltaScore = request.getDeltaScore();
        String userId = request.getUserId();
        boolean isCompleted = true;
        try {
            this.userMapper.updateScore(deltaScore, userId);
        } catch (Exception e) {
            isCompleted = false;
        }
        responseObserver.onNext(ManagerOperationResponse.newBuilder().setIsCompleted(isCompleted).build());
        responseObserver.onCompleted();
    }

    @Override
    public void operateXUser(ManagerOperationRequest request, StreamObserver<ManagerOperationResponse> responseObserver) {
        ManagerOperationRequest.Operations operation = request.getOperation();
        boolean isComplete = true;
        XUser xUser = null;
        switch (operation) {
            case INSERT:
                isComplete = this.operateXUserService.insertXUser(request.getUserId(), request.getName(),
                        request.getPassword(), request.getLoginId());
                break;
            case DELETE:
                isComplete = this.operateXUserService.deleteXUser(request.getUserId());
                break;
            case UPDATE:
                isComplete = this.operateXUserService.updateXUser(request);
                break;
            case SELECT:
                try {
                    xUser = this.operateXUserService.selectXUser(request.getUserId());
                } catch (Exception e) {
                    isComplete = false;
                }
                break;
            default:
        }
        responseObserver.onNext(ManagerOperationResponse.newBuilder()
                .setIsCompleted(isComplete)
                .setXUserInfo(gson.toJson(xUser)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void operateXUsers(ManagerOperationRequest request, StreamObserver<ManagerOperationResponse> responseObserver) {
        super.operateXUsers(request, responseObserver);
    }
}
