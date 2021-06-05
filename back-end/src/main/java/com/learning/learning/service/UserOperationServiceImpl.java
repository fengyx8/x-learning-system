package com.learning.learning.service;

import com.learning.learning.entity.Like;
import com.learning.learning.grpc.UserOperationRequest;
import com.learning.learning.grpc.UserOperationResponse;
import com.learning.learning.grpc.UserOperationServiceGrpc;
import com.learning.learning.mapper.CommentMapper;
import com.learning.learning.mapper.LikeMapper;
import com.learning.learning.mapper.NoteMapper;
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
    public UserOperationServiceImpl(NoteMapper noteMapper, CommentMapper commentMapper, LikeMapper likeMapper) {
        this.noteMapper = noteMapper;
        this.commentMapper = commentMapper;
        this.likeMapper = likeMapper;
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
        super.postAnswer(request, responseObserver);
    }
}
