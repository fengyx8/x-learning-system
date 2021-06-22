package com.learning.learning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.learning.entity.User;
import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.mapper.CommentMapper;
import com.learning.learning.mapper.NoteMapper;
import com.learning.learning.mapper.UserMapper;
import com.learning.learning.mapper.satoken.XUserMapper;
import com.learning.learning.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jbk-xiao
 * @version 2021-05-17-20:59
 */
@Service
public class GetUserInfoService {
    private final Gson gson = new GsonBuilder().create();
    private final UserMapper userMapper;
    private final NoteMapper noteMapper;
    private final CommentMapper commentMapper;
    private final XUserMapper xUserMapper;
    @Autowired
    public GetUserInfoService(UserMapper userMapper, NoteMapper noteMapper, CommentMapper commentMapper,
                              XUserMapper xUserMapper) {
        this.userMapper = userMapper;
        this.noteMapper = noteMapper;
        this.commentMapper = commentMapper;
        this.xUserMapper = xUserMapper;
    }

    public String getUserInfo(String userId) {
        User user = userMapper.getUserInfoById(userId);
        if (user == null) {
            return "";
        }
        UserInfo userInfo = new UserInfo(user);
        userInfo.setNotes(noteMapper.getNoteListByUserId(userId));
        userInfo.setComments(commentMapper.getCommentListByUserId(userId));
        return gson.toJson(userInfo);
    }

    public String getManagerInfo(String userId) {
        UserInfo userInfo = new UserInfo();
        XUser xUser = this.xUserMapper.getById(userId);
        userInfo.setUserId(userId);
        userInfo.setName(xUser.getName());
        userInfo.setMail(xUser.getMail());
        userInfo.setOrg(xUser.getOrg());
        userInfo.setNotes(noteMapper.getAllList());
        userInfo.setComments(commentMapper.getAllList());
        return gson.toJson(userInfo);
    }
}
