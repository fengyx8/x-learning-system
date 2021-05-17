package com.learning.learning.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jbk-xiao
 * @version 2021-05-17-23:26
 */
@SpringBootTest
@Slf4j
class NoteMapperTest {
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    @Autowired
    private NoteMapper noteMapper;
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
    void getNoteById() {
        Note note = noteMapper.getNoteById("n1");
        log.info(gson.toJson(note));
    }

    @Test
    void getNoteListByUserId() {
        List<Note> notes = noteMapper.getNoteListByUserId("18372052");
        log.info(gson.toJson(notes));
    }
}