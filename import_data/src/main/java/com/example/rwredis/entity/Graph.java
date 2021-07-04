package com.example.rwredis.entity;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis.entity
 * @Description:
 * @create: 2021-05-11
 */
public class Graph {
    private String name;
    private String log;
    private String lat;
    private int freq;
    private int level;

    public Graph(String name, String log, String lat, int freq, int level) {
        this.name = name;
        this.log = log;
        this.lat = lat;
        this.freq = freq;
        this.level = level;
    }

    public Graph(String name, String log, String lat, int freq) {
        this.name = name;
        this.log = log;
        this.lat = lat;
        this.freq = freq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
