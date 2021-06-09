package com.learning.learning.controller;

import com.learning.learning.grpc.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.controller
 * @Description:
 * @create: 2021-04-26
 */
@Slf4j
@CrossOrigin("*")
@RestController
public class InfoController {
    /**
     * 从容器中获取调用GRpc stub
     */
    final SearchServiceGrpc.SearchServiceBlockingStub searchServiceBlockingStub;

    @Autowired
    public InfoController(SearchServiceGrpc.SearchServiceBlockingStub searchServiceBlockingStub) {
        this.searchServiceBlockingStub = searchServiceBlockingStub;
    }

    @ApiOperation(value = "搜索新闻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", required = false),
            @ApiImplicitParam(name = "type", required = false),
            @ApiImplicitParam(name = "year", required = false),
            @ApiImplicitParam(name = "page", required = false)
    })
    @PostMapping("/getNews")
    public String news(@RequestParam("keyword") String keyword, @RequestParam("type") String type,
                       @RequestParam("year") String year, @RequestParam("page") String page) {
        log.info("Receive news request: keyword= " + keyword +"type= "+type+"year= "+year+" page= " + page);
        long start = System.currentTimeMillis();
        NewsResponse response = this.searchServiceBlockingStub
                .searchNews(NewsRequest.newBuilder()
                        .setKeyword(keyword).setType(type).setYear(year).setPage(page).build());
        long end = System.currentTimeMillis();
        log.info("Search result: " + response.getResponse());
        log.info("Retrieval time: " + (end - start));
        return response.getResponse();
    }

    @GetMapping("/getGraph")
    public String graph(){
        log.info("Receive graph request");
        long start = System.currentTimeMillis();
        GraphResponse response = this.searchServiceBlockingStub
                .searchGraph(GraphRequest.newBuilder().build());
        long end = System.currentTimeMillis();
        log.info("Search result: " + response.getResponse());
        log.info("Retrieval time: " + (end - start));
        return response.getResponse();
    }

    @GetMapping("/getWordCloud")
    public String wordCloud(){
        log.info("Receive wordCloud request");
        long start = System.currentTimeMillis();
        WordCloudResponse response = this.searchServiceBlockingStub
                .searchWordCloud(WordCloudRequest.newBuilder().build());
        long end = System.currentTimeMillis();
        log.info("Search result: " + response.getResponse());
        log.info("Retrieval time: " + (end - start));
        return response.getResponse();
    }

    @GetMapping("/getCalender/{date}")
    public String news(@PathVariable("date") String date) {
        log.info("Receive news request: date= " + date);
        long start = System.currentTimeMillis();
        CalenderResponse response = this.searchServiceBlockingStub
                .searchCalender(CalenderRequest.newBuilder()
                        .setDate(date).build());
        long end = System.currentTimeMillis();
        log.info("Search result: " + response.getResponse());
        log.info("Retrieval time: " + (end - start));
        return response.getResponse();
    }
}