package com.learning.learning.entity;

import java.util.List;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.entity
 * @Description:
 * @create: 2021-04-25
 */
public class User {
    private String name;
    private String userId;
    private String password;
    private String secureQue;
    private String secureAns;
    private String mail;
    private String org;
    private String score;
    private List<String> comment;
    private List<String> notes;
    private List<String> ansRecord;

    public User(String name, String userId, String password, String secureQue, String secureAns, String mail, String org, String score, List<String> comment, List<String> notes, List<String> ansRecord) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.secureQue = secureQue;
        this.secureAns = secureAns;
        this.mail = mail;
        this.org = org;
        this.score = score;
        this.comment = comment;
        this.notes = notes;
        this.ansRecord = ansRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecureQue() {
        return secureQue;
    }

    public void setSecureQue(String secureQue) {
        this.secureQue = secureQue;
    }

    public String getSecureAns() {
        return secureAns;
    }

    public void setSecureAns(String secureAns) {
        this.secureAns = secureAns;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public List<String> getAnsRecord() {
        return ansRecord;
    }

    public void setAnsRecord(List<String> ansRecord) {
        this.ansRecord = ansRecord;
    }

}
