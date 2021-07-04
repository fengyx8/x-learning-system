package com.example.rwredis.service;

import com.example.rwredis.entity.News;

import java.io.*;
import java.util.ArrayList;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis
 * @Description:
 * @create: 2021-05-11
 */
public class ReadNews {
    static ArrayList<News> al = new ArrayList<News>();
    static int k=0;
    static String regex = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$";

    public static ArrayList<News> readDB() throws Exception {
        String filePath = ReadNews.class.getResource("/allDataSet.csv").toString().replaceFirst("file:", "");
        String jsonStr = "";

        File f1 = new File(filePath);
        BufferedReader bf1 = new BufferedReader(new InputStreamReader(new FileInputStream((f1)),"gbk"));
        String record1;
        record1 = bf1.readLine();     //读取csv文件中每行的数据存入record1
        record1 = bf1.readLine().trim();     //读取csv文件中每行的数据存入record1
        while (record1 != null) {
            try {
                if (record1.indexOf(',') >= 0) {
                    if(record1.split(",").length < 16)
                    {
                        record1 = bf1.readLine();
                    }
                    String[] cells = record1.split(",");     //将字符串的数据以","切割，存入cells数组中
                    for (int i=0;i<cells.length;i++){
                        System.out.print(cells[i]+" ");
                    }
                    System.out.println();
                    String arr[] = new String[11];
                    for(int i=0; i<cells.length-5; i++){
                        arr[i] = cells[5+i].trim();
                    }
                    al.add(new News(cells[0].trim(), cells[1].trim(), cells[2].trim(), cells[3].trim(), cells[4].trim(), arr));     //以切割后cells数组中的第四项和第三项以及行数构造Commodity类实例
                    k++;
                }
            }catch (Exception e){
                record1 = bf1.readLine();
                continue;
            }
            //校验record1也就是每行的数据是否满足要求
            record1 = bf1.readLine();
        }
        return al;
    }
}
