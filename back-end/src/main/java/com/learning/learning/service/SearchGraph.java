package com.learning.learning.service;

import com.learning.learning.dao.RedisDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.service
 * @Description:
 * @create: 2021-05-15
 */
@Slf4j
@Component
public class SearchGraph {
    @Autowired
    private RedisDao redisDao;

    public String searchGraph(){
        if(redisDao==null){
            log.info("NULL");
        }
        return redisDao.getGraph();
    }
}
