package com.learning.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.entity.AnsRecord;
import com.learning.learning.grpc.CommunityUserServiceGrpc;
import com.learning.learning.grpc.UserInfoRequest;
import com.learning.learning.grpc.UserInfoResponse;
import com.learning.learning.mapper.AnsRecordMapper;
import com.learning.learning.util.so.SoMap;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jbk-xiao
 * @version 2021-05-16-23:44
 */
@GRpcService
@Slf4j
@Service
public class CommunityUserServiceImpl extends CommunityUserServiceGrpc.CommunityUserServiceImplBase {
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final GetUserInfoService getUserInfoService;
    private final AnsRecordMapper ansRecordMapper;
    @Autowired
    public CommunityUserServiceImpl(GetUserInfoService getUserInfoService, AnsRecordMapper ansRecordMapper) {
        this.getUserInfoService = getUserInfoService;
        this.ansRecordMapper = ansRecordMapper;
    }

    @Override
    public void getUserInfo(UserInfoRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        String userId = request.getUserId();
        String userInfo;
        int roleId = request.getRoleId();
        //TODO 处理当用户是管理员时的信息返回逻辑
        if (roleId == 1) {
            userInfo = getUserInfoService.getManagerInfo(userId);
        } else {
            userInfo = getUserInfoService.getUserInfo(userId);
        }
        log.info("Service gotten userInfo: {}", userInfo);
        UserInfoResponse response = UserInfoResponse.newBuilder()
                .setUserInfo(userInfo).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAnsRecords(UserInfoRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        String userId = request.getUserId();
        List<AnsRecord> ansRecords = ansRecordMapper.getList(SoMap.getSoMap("userId", userId));
        String ansRecord = gson.toJson(ansRecords);
        log.info("Service gotten ansRecord: {}", ansRecord);
        UserInfoResponse response = UserInfoResponse.newBuilder()
                .setUserInfo(ansRecord).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
