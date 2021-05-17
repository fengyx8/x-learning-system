package com.learning.learning.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author jbk-xiao
 * @version 2021-05-17-17:41
 */
@SpringBootTest
//@RunWith(SpringRunner.class)
@Slf4j
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();

//    @Test
//    void add() {
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void update() {
//    }

    @Test
    void getById() {
//        String xmlPath = "src/main/resources/mapper/UserMapper.xml";
//        ApplicationContext context = new FileSystemXmlApplicationContext(xmlPath);
//        userMapper = context.getBean(UserMapper.class);
        User user = userMapper.getUserInfoById("18372052");
        log.info("18372052 user: {}", gson.toJson(user));
    }
}