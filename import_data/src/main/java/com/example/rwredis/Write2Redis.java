package com.example.rwredis;

import com.example.rwredis.entity.*;
import com.example.rwredis.service.ReadByGson;
import com.example.rwredis.service.ReadFrequency;
import com.example.rwredis.service.ReadNews;
import com.example.rwredis.service.ReadSegmentation;
import com.example.rwredis.util.GsonUtil;
import com.example.rwredis.util.RedisPoolUtil;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis
 * @Description:
 * @create: 2021-05-11
 */
public class Write2Redis {
    private static Jedis jedis;

    public static void main(String[] args) throws Exception {
        //获取jedis连接
        jedis = RedisPoolUtil.getJedis();
        //设置密码
        jedis.auth("nopassword");
        System.out.println(jedis.ping());

        //从csv文件中读取每条数据相应字段的内容作为News类实例存储在数组中
        ArrayList<News> news = ReadNews.readDB();
        // 关键词索引库
        jedis.select(1);
        for(int i=0; i<news.size()&&news.get(i)!=null; i++)
        {
            if(news.get(i).getTitle()!=null) {
                jedis.sadd(news.get(i).getTitle().trim(), news.get(i).getId().trim());
            }
        }
        // 类型索引库
        jedis.select(2);
        for(int i=0; i<news.size()&&news.get(i)!=null; i++) {
            if (news.get(i).getKind() != null) {
                for(int j = 0; j < 11; j++){
                    if(news.get(i).getKind()[j] != null)
                        jedis.sadd(news.get(i).getKind()[j].trim(), news.get(i).getId().trim());
                }
            }
        }
        // 时间索引库
        jedis.select(3);
        for(int i=0; i<news.size()&&news.get(i)!=null; i++)
        {
            if(news.get(i).getDate()!=null) {
                jedis.sadd(news.get(i).getDate().trim(), news.get(i).getId().trim());
            }
        }

        // 读取jieba分词与词频数据
        ArrayList<Word2News> al1 = ReadSegmentation.readDB();
        ArrayList<Word2Frequency> al2 = ReadFrequency.readDB();

        // 读取地图数据
        String file = ReadByGson.readJsonFile("Area.json");
        Gson gson = new Gson();
        List<Area> areas = GsonUtil.parseJsonArrayWithGson(file, Area.class);
        List<Graph> graphs = new ArrayList<Graph>();

        for(int i=0;i<areas.size();i++){
            for(int j=0;j<al2.size();j++){
                if(al2.get(j).getWord().equals(areas.get(i).getName())){
                    Graph graph = new Graph(areas.get(i).getName(), areas.get(i).getLog(), areas.get(i).getLat(), al2.get(j).getFrequency());
                    graphs.add(graph);
                }
            }
        }

        jedis.select(1);
        //建立全文检索
        for(int i=0; i<al1.size()&&al1.get(i)!=null; i++)
        {
            if(al1.get(i).getWord()!=null) {
                jedis.sadd(al1.get(i).getWord().trim(), al1.get(i).getNewsId().trim());
            }
        }
        //存放词云数据
        jedis.select(5);
        for(int i=0; i<al2.size()&&al2.get(i)!=null; i++)
        {
            if(al2.get(i).getWord()!=null && al2.get(i).getWord().length()>1) {
                jedis.zadd("WordCloud", al2.get(i).getFrequency(), al2.get(i).getWord().trim());
                jedis.set(al2.get(i).getWord().trim(), al2.get(i).getFrequency()+"");
            }
        }
        //存放地图数据
        jedis.select(4);
        ArrayList<Integer> freqList = new ArrayList<Integer>();
        for(int i=0; i<graphs.size()&&graphs.get(i)!=null; i++)
        {
            if(graphs.get(i).getName()!=null) {
                freqList.add(graphs.get(i).getFreq());
            }
        }
        Integer[] freq = freqList.toArray(new Integer[0]);
        Arrays.sort(freq);
        int level[] = new int[5];
        level[0] = freq[freq.length - 201];
        level[1] = freq[freq.length - 101];
        level[2] = freq[freq.length - 51];
        level[3] = freq[freq.length - 21];
        level[4] = freq[freq.length - 1];
        for(int i=0; i<graphs.size()&&graphs.get(i)!=null; i++)
        {
            if(graphs.get(i).getName()!=null) {
                for(int j=0; j < level.length; j++){
                    if(graphs.get(i).getFreq() <= level[j]){
                        graphs.get(i).setLevel(j + 1);
                        break;
                    }
                }
            }
        }
        for(int i=0; i<graphs.size()&&graphs.get(i)!=null; i++)
        {
            if(graphs.get(i).getName()!=null) {
                jedis.hset(graphs.get(i).getName(),"log", graphs.get(i).getLog());
                jedis.hset(graphs.get(i).getName(),"lat", graphs.get(i).getLat());
                jedis.hset(graphs.get(i).getName(),"level", graphs.get(i).getLevel()+"");
                jedis.hset(graphs.get(i).getName(),"freq", graphs.get(i).getFreq()+"");
            }
        }
        jedis.close();
        System.exit(0);
    }
}
