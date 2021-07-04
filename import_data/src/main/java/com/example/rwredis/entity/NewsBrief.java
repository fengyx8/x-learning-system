package com.example.rwredis.entity;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis.entity
 * @Description:
 * @create: 2021-05-21
 */
public class NewsBrief {
    private String id;
    private String url;
    private String title;
    private String date;
    private String origin;

    public NewsBrief(){

    }

    public NewsBrief(String id, String url, String title, String date, String origin) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.date = date;
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
