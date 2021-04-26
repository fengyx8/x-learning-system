package com.learning.learning.dao;

import com.learning.learning.entity.ListAndPage;
import com.learning.learning.util.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
public class RedisDao {

    static int pagecount = 20;
    //分页的每一页的结果数
    static int pageRecord = 20;

    public int pageNum = 0;
    @Autowired
    JedisUtil jedisUtil;

    /**
     * 根据页码查询id
     * @param query 检索词
     * @param page 页码
     * @return keys
     */
//    public List<String> getIDListOnPage(String query, int page) {
//        int start = (page - 1 ) * pagecount;
//        int end = start + pagecount - 1;
//        log.info("jedisUtil.toString(): "+jedisUtil.toString());
//        List<String> queries = FuzzySearchQueryByKeys(query);
//        Jedis jedis= jedisUtil.getClient();
//        List<String> keys = new ArrayList<String>();
//        try {
//            if (jedis.exists(query)) {
//                log.info("使用redis查询query返回idList");
//                keys.addAll(jedis.zrevrange(query,start,end));
//            } else {
//                log.info("redis没有找到query");
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//        return keys;
//    }
//
//    /**
//     * 返回页码总数
//     * @param query 检索词
//     * @return page
//     */
//    public long getPageNumber(String query)
//    {
//        Jedis jedis= jedisUtil.getClient();
//        long num = jedis.zcard(query);
//        long page = num/pagecount + 1;
//        return page;
//    }

    /**
     * 查询首页的id
     *
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
     *
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
     * 根据query找相应的skuId
     *
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
     * 根据模糊的query找到所有的检索词
     *
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
     *
     * @param title
     * @param content
     * @param type
     * @param year
     * @param page
     * @return List<String>
     */
    public ListAndPage getIDListOnPage(String title, String content, String type, String year, int page){
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        list1 = getIDListByTitle(title);
        list2 = getIDListByTitle(content);
        list3 = getIDListByTitle(type);
        list4 = getIDListByTitle(year);
        list1.retainAll(list2);
        list1.retainAll(list3);
        list1.retainAll(list4);
        long num = list1.size();
        int start = (page-1)*pageRecord;
        int end = start+pageRecord-1;
        List<String> res = new ArrayList<>();
        if(list1.size()>=end) {
            res = list1.subList(start,end+1);
        }
        ListAndPage lp = null;
        lp.setList(res);
        lp.setPageNum((int) (num / pageRecord + 1));
        return lp;
    }

    /**
     * 返回要显示的页码总数
     *
     * @param query
     * @return
     */
    public int getPageNumber(String query) {
        return pageNum;
    }
}