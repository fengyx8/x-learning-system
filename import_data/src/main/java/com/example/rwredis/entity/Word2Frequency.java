package com.example.rwredis.entity;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis.entity
 * @Description:
 * @create: 2021-05-11
 */
public class Word2Frequency {
    private String word;
    private int frequency;

    public Word2Frequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Word2Frequency{" +
                "word='" + word + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
