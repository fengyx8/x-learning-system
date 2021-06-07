package com.learning.learning.service;

import com.learning.learning.grpc.ManagerOperationRequest;
import com.learning.learning.grpc.ManagerOperationResponse;
import com.learning.learning.grpc.ManagerOperationServiceGrpc;
import com.learning.learning.mapper.CommentMapper;
import com.learning.learning.mapper.NoteMapper;
import com.learning.learning.mapper.UserMapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.stereotype.Service;

/**
 * @author jbk-xiao
 * @version 2021-06-06-22:00
 */
@GRpcService
@Slf4j
@Service
public class ManagerOperationServiceImpl extends ManagerOperationServiceGrpc.ManagerOperationServiceImplBase {
    private final NoteMapper noteMapper;
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;

    public ManagerOperationServiceImpl(NoteMapper noteMapper, CommentMapper commentMapper, UserMapper userMapper) {
        this.noteMapper = noteMapper;
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
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
}
