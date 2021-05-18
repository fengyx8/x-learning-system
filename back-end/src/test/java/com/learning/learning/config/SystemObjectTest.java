package com.learning.learning.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jbk-xiao
 * @version 2021-05-18-19:48
 */
@SpringBootTest
@Slf4j
class SystemObjectTest {

    @Test
    void getPasswordMd5() {
        String password = SystemObject.getPasswordMd5("170020", "admin");
        log.info("password: {}",password);
    }
}