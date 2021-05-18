package com.learning.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.mapper.CommentMapper;
import com.learning.learning.mapper.NoteMapper;
import com.learning.learning.mapper.UserMapper;
import com.learning.learning.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jbk-xiao
 * @version 2021-05-17-20:59
 */
@Service
public class CommunityLoggedUserInfo {
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final UserMapper userMapper;
    private final NoteMapper noteMapper;
    private final CommentMapper commentMapper;
    @Autowired
    public CommunityLoggedUserInfo(UserMapper userMapper, NoteMapper noteMapper, CommentMapper commentMapper) {
        this.userMapper = userMapper;
        this.noteMapper = noteMapper;
        this.commentMapper = commentMapper;
    }

    public String getUserInfo(String userId) {
        UserInfo userInfo = new UserInfo(userMapper.getUserInfoById(userId));
        userInfo.setNotes(noteMapper.getNoteListByUserId(userId));
        userInfo.setComments(commentMapper.getCommentListByUserId(userId));
        return gson.toJson(userInfo);
    }
}
