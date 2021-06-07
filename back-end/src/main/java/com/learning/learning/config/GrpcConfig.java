package com.learning.learning.config;

import com.learning.learning.grpc.CommunityUserServiceGrpc;
import com.learning.learning.grpc.CommunityWholeServiceGrpc;
import com.learning.learning.grpc.ManagerOperationServiceGrpc;
import com.learning.learning.grpc.SearchServiceGrpc;
import com.learning.learning.grpc.UserOperationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {
    /**
     * 配置需要连接的server的ip:port
     */
    @Bean
    ManagedChannel channel(@Value("${app-config.grpc-server-name}") String name,
                           @Value("${app-config.grpc-server-port}") Integer port,
                           @Value("${app-config.max-message-size}") Integer size){
        return ManagedChannelBuilder.forAddress(name,port).maxInboundMessageSize(size)
                .usePlaintext()
                .build();
    }

    /**
     * 将proto生成的stub放入容器中，方便调用
     */
    @Bean
    SearchServiceGrpc.SearchServiceBlockingStub searchServiceBlockingStub(ManagedChannel channel) {
        return SearchServiceGrpc.newBlockingStub(channel);
    }
    @Bean
    CommunityUserServiceGrpc.CommunityUserServiceBlockingStub communityUserServiceBlockingStub(ManagedChannel channel) {
        return  CommunityUserServiceGrpc.newBlockingStub(channel);
    }
    @Bean
    CommunityWholeServiceGrpc.CommunityWholeServiceBlockingStub communityWholeServiceBlockingStub(ManagedChannel channel) {
        return CommunityWholeServiceGrpc.newBlockingStub(channel);
    }
    @Bean
    UserOperationServiceGrpc.UserOperationServiceBlockingStub userOperationServiceBlockingStub(ManagedChannel channel) {
        return UserOperationServiceGrpc.newBlockingStub(channel);
    }
    @Bean
    ManagerOperationServiceGrpc.ManagerOperationServiceBlockingStub managerOperationServiceBlockingStub(ManagedChannel channel) {
        return ManagerOperationServiceGrpc.newBlockingStub(channel);
    }
}