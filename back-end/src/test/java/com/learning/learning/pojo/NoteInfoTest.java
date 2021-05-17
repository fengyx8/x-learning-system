package com.learning.learning.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.entity.Comment;
import com.learning.learning.entity.Note;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jbk-xiao
 * @version 2021-05-16-21:09
 */
class NoteInfoTest {
    private final Gson gson = new GsonBuilder()
//            .excludeFieldsWithoutExposeAnnotation()
            .disableHtmlEscaping().create();
    @Test
    void testPrint() {
        NoteInfo noteInfo = new NoteInfo(
                new Note(
                        "n1", "lalala", Timestamp.valueOf("2021-01-03 11:11:11"), "18372052", 1
                ));
        Comment comment = new Comment("c1",
                "hahaha",
                Timestamp.valueOf("2021-02-03 11:14:11"),
                "18372052", "n1", 1);
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        noteInfo.setComments(comments);
        System.out.println(gson.toJson(noteInfo));
    }
}