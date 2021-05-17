package com.learning.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.grpc.CommunityServiceGrpc;
import com.learning.learning.grpc.UserInfoRequest;
import com.learning.learning.grpc.UserInfoResponse;
import com.learning.learning.mapper.UserMapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jbk-xiao
 * @version 2021-05-16-23:44
 */
@GRpcService
@Slf4j
@Service
public class CommunityServiceImpl extends CommunityServiceGrpc.CommunityServiceImplBase {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final CommunityUserInfo communityUserInfo;

    @Autowired
    public CommunityServiceImpl(CommunityUserInfo communityUserInfo) {
        this.communityUserInfo = communityUserInfo;
    }

    @Override
    public void getUserInfo(UserInfoRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        String userId = request.getUserId();
        String userInfo = communityUserInfo.getUserInfo(userId);
        UserInfoResponse response = UserInfoResponse.newBuilder()
                .setUserInfo(userInfo).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
