package com.learning.learning.service;

import com.trace.trace.grpc.NewsRequest;
import com.trace.trace.grpc.NewsResponse;
import com.trace.trace.grpc.SearchServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.service
 * @Description:
 * @create: 2021-04-26
 */
@GRpcService
@Slf4j
@Service
public class SearchServiceImpl extends SearchServiceGrpc.SearchServiceImplBase {
    @Autowired
    SearchNews searchNews;

    /**
     * 新闻查询模块
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void searchNews(NewsRequest request, StreamObserver<NewsResponse> responseObserver) {
        //获取请求标题
        String title = request.getTitle();
        //获取请求内容
        String content = request.getContent();
        //获取请求类型
        String type = request.getType();
        //获取请求年份
        String year = request.getYear();
        //获取请求页码
        String page = request.getPage();
        log.info("Receive request: title= " + title + "content= "+content+"type= "+type+"year= "+year+" page= " + page);
        //返回结果初始化
        String jsonInfo = "";

        //分页检索，每次返回二十条商品
        log.info("SearchServiceImpl start searching!");
        try {
            jsonInfo = searchNews.searchNews(title, content, type, year, page);
        } catch (Exception e) {
            e.printStackTrace();
        }

        NewsResponse newsResponse = NewsResponse.newBuilder().setResponse(jsonInfo).build();
        //放入response，传回客户端
        responseObserver.onNext(newsResponse);
        //表示此次连接结束
        responseObserver.onCompleted();
    }

}
