package com.learning.learning.mapper;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.entity.AnsRecord;
import com.learning.learning.entity.Question;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jbk-xiao
 * @version 2021-05-30-21:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class QuestionMapperTest {
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnsRecordMapper ansRecordMapper;
    @Test
    public void testOperation() {
        Question question = questionMapper.getById("q1");
        System.out.println(gson.toJson(question));
        AnsRecord ansRecord = ansRecordMapper.getByQueId(question.getQueId());
        System.out.println(gson.toJson(ansRecord));
    }
}