package com.learning.learning.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.learning.learning.entity.Comment;
import com.learning.learning.entity.Note;
import com.learning.learning.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author jbk-xiao
 * @version 2021-05-16-17:07
 */
@Data
public class UserInfo {
    @Expose
    @SerializedName("userId")
    private String userId;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("mail")
    private String mail;
    @Expose
    @SerializedName("org")
    private String org;
    @Expose
    @SerializedName("score")
    private Double score;
    @Expose
    @SerializedName("comments")
    private List<Comment> comments;
    @Expose
    @SerializedName("notes")
    private List<Note> notes;
    public UserInfo() {}
    public UserInfo(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.mail = user.getMail();
        this.org = user.getOrg();
        this.score = user.getScore();
    }
}
