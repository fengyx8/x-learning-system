package com.example.rwredis.service;

import com.example.rwredis.entity.News;
import com.example.rwredis.entity.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis.service
 * @Description:
 * @create: 2021-06-16
 */
public class ReadQuestion {
    static ArrayList<Question> al = new ArrayList<Question>();
    static int k=0;
    static String regex = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$";

    public static ArrayList<Question> readDB() throws Exception {
        String filePath = ReadQuestion.class.getResource("/questions.csv").toString().replaceFirst("file:/", "");
        String jsonStr = "";

        File f1 = new File(filePath);
        BufferedReader bf1 = new BufferedReader(new InputStreamReader(new FileInputStream((f1)), StandardCharsets.UTF_8));
        String record1;
        record1 = bf1.readLine();     //读取csv文件中每行的数据存入record1
        record1 = bf1.readLine().trim();     //读取csv文件中每行的数据存入record1
        while (record1 != null) {
            try {
                if (record1.indexOf(',') >= 0) {
                    if(record1.split(",").length < 7)
                    {
                        record1 = bf1.readLine();
                    }
                    String[] cells = record1.split(",");     //将字符串的数据以","切割，存入cells数组中
                    for (int i=0;i<cells.length;i++){
                        System.out.print(cells[i]+" ");
                    }
                    System.out.println();
                    al.add(new Question(cells[0].trim(), cells[1].trim(), cells[2].trim(), cells[3].trim(), cells[4].trim(), cells[5].trim(), cells[6].trim(), 2, 0, 0));     //以切割后cells数组中的第四项和第三项以及行数构造Commodity类实例
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
