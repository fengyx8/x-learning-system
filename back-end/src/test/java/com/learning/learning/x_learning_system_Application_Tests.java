package com.learning.learning;

import com.learning.learning.service.SearchCalender;
import com.learning.learning.service.SearchGraph;
import com.learning.learning.service.SearchNews;
import com.learning.learning.service.SearchWordCloud;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning
 * @Description:
 * @create: 2021-05-15
 */
@SpringBootTest
public class x_learning_system_Application_Tests {
    @Resource
    SearchGraph searchGraph = new SearchGraph();
    @Resource
    SearchWordCloud searchWordCloud = new SearchWordCloud();
    @Resource
    SearchNews searchNews = new SearchNews();
    @Resource
    SearchCalender searchCalender = new SearchCalender();
    @Test
    void contextLoads() {
        System.out.println(searchGraph.searchGraph());
        System.out.println(searchWordCloud.searchWordCloud());
        System.out.println(searchNews.searchNews("十九大", "北京", "政治", "2021", "1"));
        System.out.println(searchCalender.searchCalender("2021-1"));
    }
}