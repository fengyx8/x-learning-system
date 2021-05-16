package com.learning.learning;

import com.learning.learning.service.SearchGraph;
import com.learning.learning.service.SearchNews;
import com.learning.learning.service.SearchWordCloud;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning
 * @Description:
 * @create: 2021-05-15
 */
@SpringBootTest
public class x_learning_system_Application_Tests {

    @Test
    void contextLoads() {
        SearchGraph searchGraph = new SearchGraph();
        System.out.println(searchGraph.searchGraph().toString());

        SearchWordCloud searchWordCloud = new SearchWordCloud();
        System.out.println(searchWordCloud.searchWordCloud().toString());

        SearchNews searchNews = new SearchNews();
        System.out.println(searchNews.searchNews("十九大", "北京", "政治", "", "1"));
    }
}
