package com.learning.learning.service;

import com.learning.learning.grpc.CommunityServiceGrpc;
import com.learning.learning.grpc.UserInfoRequest;
import com.learning.learning.grpc.UserInfoResponse;
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

    @Override
    public void getUserInfo(UserInfoRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        //TODO
    }
}
