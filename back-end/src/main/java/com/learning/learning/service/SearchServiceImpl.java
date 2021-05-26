package com.learning.learning.service;

import com.learning.learning.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

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
    @Autowired
    SearchGraph searchGraph;
    @Autowired
    SearchWordCloud searchWordCloud;
    @Autowired
    SearchCalender searchCalender;

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

        //分页检索，每次返回二十条记录
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

    @Override
    public void searchGraph(GraphRequest request, StreamObserver<GraphResponse> responseObserver){
        log.info("Starting searching graph!");
        String jsonInfo = "";
        try{
            jsonInfo = searchGraph.searchGraph();
        } catch (Exception e){
            e.printStackTrace();
        }
        GraphResponse graphResponse = GraphResponse.newBuilder().setResponse(jsonInfo).build();
        //放入response，传回客户端
        responseObserver.onNext(graphResponse);
        //表示此次连接结束
        responseObserver.onCompleted();
    }

    public void searchWordCloud(WordCloudRequest request, StreamObserver<WordCloudResponse> responseObserver){
        log.info("Starting searching wordCloud!");
        String jsonInfo = "";
        try{
            jsonInfo = searchWordCloud.searchWordCloud();
        } catch (Exception e){
            e.printStackTrace();
        }
        WordCloudResponse wordCloudResponse = WordCloudResponse.newBuilder().setResponse(jsonInfo).build();
        //放入response，传回客户端
        responseObserver.onNext(wordCloudResponse);
        //表示此次连接结束
        responseObserver.onCompleted();
    }

    public void searchCalender(CalenderRequest request, StreamObserver<CalenderResponse> responseObserver){
        log.info("Starting searching calender!");
        String jsonInfo = "";
        String date = request.getDate();
        try{
            jsonInfo = searchCalender.searchCalender(date);
        } catch (Exception e){
            e.printStackTrace();
        }
        CalenderResponse calenderResponse = CalenderResponse.newBuilder().setResponse(jsonInfo).build();
        //放入response，传回客户端
        responseObserver.onNext(calenderResponse);
        //表示此次连接结束
        responseObserver.onCompleted();
    }
}
