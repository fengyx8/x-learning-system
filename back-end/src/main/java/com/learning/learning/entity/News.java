package com.learning.learning.entity;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.entity
 * @Description:
 * @create: 2021-04-25
 */
public class News {
    private String newsId;
    private String title;
    private String newsKind;
    private String pubDate;
    private String materialKind;
    private String content;
    private String source;

    public News(String newsId, String title, String newsKind, String pubDate, String materialKind, String content, String source) {
        this.newsId = newsId;
        this.title = title;
        this.newsKind = newsKind;
        this.pubDate = pubDate;
        this.materialKind = materialKind;
        this.content = content;
        this.source = source;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsKind() {
        return newsKind;
    }

    public void setNewsKind(String newsKind) {
        this.newsKind = newsKind;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getMaterialKind() {
        return materialKind;
    }

    public void setMaterialKind(String materialKind) {
        this.materialKind = materialKind;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
