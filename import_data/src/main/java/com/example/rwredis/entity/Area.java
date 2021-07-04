package com.example.rwredis.entity;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis.entity
 * @Description:
 * @create: 2021-05-11
 */
public class Area {
    private String name;
    private String log;
    private String lat;

    public Area(String name, String log, String lat) {
        this.name = name;
        this.log = log;
        this.lat = lat;
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
}
