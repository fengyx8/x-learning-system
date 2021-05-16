package com.learning.learning.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.learning.learning.entity.Comment;
import com.learning.learning.entity.Note;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author jbk-xiao
 * @version 2021-05-16-20:08
 */
@Data
public class NoteInfo {
    @Expose
    @SerializedName("noteId")
    private String noteId;
    @Expose
    @SerializedName("content")
    private String content;
    @Expose
    @SerializedName("time")
    private Timestamp time;
    @Expose
    @SerializedName("userId")
    private String userId;
    @Expose
    @SerializedName("comments")
    private List<Comment> comments;
    public NoteInfo(Note note) {
        this.noteId = note.getNoteId();
        this.content = note.getContent();
        this.time = note.getTime();
        this.userId = note.getUserId();
    }
}
