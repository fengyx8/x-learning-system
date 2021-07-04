package com.example.rwredis.entity;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis
 * @Description:
 * @create: 2021-05-11
 */
public class News {
    private String id;
    private String url;
    private String title;
    private String date;
    private String origin;
    private String[] kind = new String[11];

    public News(String id, String url, String title, String date, String origin, String[] kind) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.date = date;
        this.origin = origin;
        this.kind = kind;
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

    public String[] getKind() {
        return kind;
    }

    public void setKind(String[] kind) {
        this.kind = kind;
    }
}
