package com.example.rwredis.entity;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis
 * @Description:
 * @create: 2021-05-11
 */
public class Word2News {
    private String word;
    private String newsId;

    public Word2News(String word, String newsId) {
        this.word = word;
        this.newsId = newsId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    @Override
    public String toString() {
        return "Word2News{" +
                "word='" + word + '\'' +
                ", newsId='" + newsId + '\'' +
                '}';
    }
}
