package com.learning.learning.dao;

import com.learning.learning.entity.ListAndPage;
import com.learning.learning.util.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.*;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.dao
 * @Description:
 * @create: 2021-04-25
 */
@Slf4j
@Repository
public class RedisDao {
    //分页的每一页的结果数
    static int pageRecord = 20;
    public int pageNum = 0;
    final JedisUtil jedisUtil;

    @Autowired
    public RedisDao(JedisUtil jedisUtil) {
        this.jedisUtil = jedisUtil;
    }

    /**
     * 根据标题查询
     * @param query 检索词
     * @return keys
     */
    public ArrayList<String> getIDListByTitle(String query) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i<query.length(); i++){
            list.add(query.substring(i,i+1));
        }
        log.info("list:"+list.toString());
        ArrayList<String> res = new ArrayList<String>();
        try {
            res.addAll(fuzzySearchList(query, 0));
            for(String key:list){
                res.addAll(fuzzySearchList(key, 0));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 根据内容查询
     * @param query
     * @return
     */
    public ArrayList<String> getIDListByContent(String query) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i<query.length(); i++){
            list.add(query.substring(i,i+1));
        }
        log.info("list:"+list.toString());
        ArrayList<String> res = new ArrayList<String>();
        try {
            res.addAll(fuzzySearchList(query,1));
            for(String key:list){
                res.addAll(fuzzySearchList(key,1));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 根据年份查询
     * @param query
     * @return
     */
    public ArrayList<String> getIDListByYear(String query) {
        ArrayList<String> res = new ArrayList<String>();
        Jedis jedis = jedisUtil.getClient();
        jedis.select(3);
        try {
            res.addAll(jedis.smembers(query));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 根据类别查询
     * @param query
     * @return
     */
    public ArrayList<String> getIDListByType(String query) {
        ArrayList<String> res = new ArrayList<String>();
        Jedis jedis = jedisUtil.getClient();
        jedis.select(2);
        try {
            res.addAll(jedis.smembers(query));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 根据query进行模糊匹配找相应的检索词
     * @param query
     * @return
     */
    public List<String> fuzzySearchQueryByKeys(String query, int db) {
        log.info("{} 模糊匹配", query);
//        Jedis jedis = jedisUtil.getClient();
        String pattern = query.trim().replaceAll("\\s+", "*");
        pattern = "*" + pattern + "*";
        long startTime = System.currentTimeMillis();
        List<String> res = jedisScan(pattern, db);
        long finishTime = System.currentTimeMillis();
        log.info("jediskeys process time:" + (finishTime - startTime));
        log.info("{} 模糊匹配,size:{}", pattern, res.size());
        return res;
    }

    /**
     * 根据query找相应的newsId
     * @param query
     * @return
     */
    public List<String> fuzzySearchList(String query, int db) {
        log.info("使用方法fuzzySearchList");
        long startTime = System.currentTimeMillis();
        List<String> keys = new ArrayList<>(fuzzySearchQueryByKeys(query, db));
        Jedis jedis = jedisUtil.getClient();
        log.info("模糊匹配到keys：" + keys.toString());
        List<String> list = new ArrayList<>();
        if (keys.size() > 0) {
            for (String key : keys) {
                list.addAll(jedis.zrevrange(key, 0, -1));
            }
            jedis.close();
        } else {
            log.info("redis没有查到，返回" + list.toString());
            jedis.close();
            return list;
        }
        //去重（顺序不变）
        List<String> result1 = new ArrayList<>(new LinkedHashSet<>(list));
        List<String> result = new ArrayList<>();
        log.info("redis模糊查找:" + query + ",返回" + result1.toString());
        for (String id : result1) {
            id = id.trim();
            result.add(id);
        }
        long finishQueryTime = System.currentTimeMillis();
        log.info("Jedis process time:" + (finishQueryTime - startTime));
        return result;
    }

    /**
     * 根据模糊的query找到所有的newsId
     * @param pattern
     * @return
     */
    private List<String> jedisScan(String pattern, int database) {
        long startTime = System.currentTimeMillis();
        Jedis jedis = jedisUtil.getClient();
        jedis.select(database);
        String cursor = ScanParams.SCAN_POINTER_START;
        List<String> keys = new ArrayList<>();
        ScanParams scanParams = new ScanParams();
        scanParams.match(pattern);
        scanParams.count(Integer.MAX_VALUE);
        while (true) {
            //使用scan命令获取数据，使用cursor游标记录位置，下次循环使用
            ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
            /* 返回0 说明遍历完成 */
            cursor = scanResult.getCursor();
            keys = scanResult.getResult();
            if ("0".equals(cursor)) {
                break;
            }
        }
        long finishTime = System.currentTimeMillis();
        log.info("jedisScan process time:" + (finishTime - startTime));
        jedis.close();
        return keys;
    }

    /**
     * 求交集，并按分页返回对应的newsId
     * @param title
     * @param content
     * @param type
     * @param year
     * @param page
     * @return List<String>
     */
    public ListAndPage getIDListOnPage(String title, String content, String type, String year, int page){
        Boolean first = true;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        if (!title.equals("")){
            list1 = getIDListByTitle(title);
            if (first){
                list.addAll(list1);
                first = false;
            }
        }
        if (!content.equals("")) {
            list2 = getIDListByContent(content);
            if (first){
                list.addAll(list2);
                first = false;
            } else {
              list.retainAll(list2);
            }
        }
        if (!type.equals("")) {
            list3 = getIDListByType(type);
            if (first){
                list.addAll(list3);
                first = false;
            } else {
                list.retainAll(list3);
            }
        }
        if (!year.equals("")) {
            list4 = getIDListByYear(year);
            if (first){
                list.addAll(list4);
                first = false;
            } else {
                list.retainAll(list4);
            }
        }
        long num = list.size();
        int start = (page-1)*pageRecord;
        int end = start+pageRecord-1;
        List<String> res = new ArrayList<>();
        if(list.size()>=end) {
            res = list.subList(start,end+1);
        }
        ListAndPage lp = null;
        lp.setList(res);
        lp.setPageNum((int) (num / pageRecord + 1));
        return lp;
    }

    public String getWordCloud(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\"wordCloud\": [");
        Jedis jedis = jedisUtil.getClient();
        jedis.select(5);
        List<String> wordAl = new ArrayList<>(jedis.zrange("WordCloud", -50, -1));
        for(int i=0; i<wordAl.size(); i++){
            if(i == wordAl.size()-1){
                sb.append("{\"word\":");
                sb.append("\""+wordAl.get(i)+"\",");
                sb.append("\"count\":");
                sb.append(jedis.get(wordAl.get(i))+"}]}");
            }
            else {
                sb.append("{\"word\":");
                sb.append("\"" + wordAl.get(i) + "\",");
                sb.append("\"count\":");
                sb.append(jedis.get(wordAl.get(i)) + "},");
            }
        }
        jedis.close();
        return sb.toString();
    }

    public String getGraph(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\"geo\": [");
        Jedis jedis = jedisUtil.getClient();
        jedis.select(4);
        List<String> graphList = new ArrayList<>();
        Set<String> s = jedis.keys("*");
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            sb.append("{");
            String key = it.next();
            if(it.hasNext()) {
                sb.append("\"lng\":" + jedis.hget(key, "log") + ",");
                sb.append("\"lat\":" + jedis.hget(key, "lat") + ",");
                sb.append("\"name\":" + key + ",");
                sb.append("\"value\":" + jedis.hget(key, "freq"));
                sb.append("},");
            }
            else{
                sb.append("\"lng\":" + jedis.hget(key, "log") + ",");
                sb.append("\"lat\":" + jedis.hget(key, "lat") + ",");
                sb.append("\"name\":" + key + ",");
                sb.append("\"value\":" + jedis.hget(key, "freq"));
                sb.append("}]}");
            }
        }
        jedis.close();
        return sb.toString();
    }
}