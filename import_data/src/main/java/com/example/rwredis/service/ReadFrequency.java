package com.example.rwredis.service;

import com.example.rwredis.entity.Word2Frequency;
import com.example.rwredis.entity.Word2News;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis
 * @Description:
 * @create: 2021-05-11
 */
public class ReadFrequency {
    static ArrayList<Word2Frequency> al = new ArrayList<Word2Frequency>();
    static String regex = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$";
    static Map<String, Integer> map = new HashMap<String, Integer>();
    public static ArrayList<Word2Frequency> readDB() throws Exception {
        String filePath = ReadFrequency.class.getResource("/cipin.json").toString().replaceFirst("file:/", "");
        String jsonStr = "";
        try {
            File jsonFile = new File(filePath);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuffer sb = new StringBuffer(102400);
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        jsonStr = jsonStr.replace("[","");
        jsonStr = jsonStr.replace("]","");
        jsonStr = jsonStr.replace("{","");
        jsonStr = jsonStr.replace("}","");
        jsonStr = jsonStr.replace("\"","");
        String[] stringArr = jsonStr.split(",");
        for(int i=0; i<stringArr.length; i++){
            String temp[] = stringArr[i].split(":");
            if(temp.length != 2){
                continue;
            }
            if(temp[0].length() == 0 || temp[1].length() == 0){
                continue;
            }
            if(!temp[0].trim().matches(regex)){
                continue;
            }
            String key = temp[0].trim();
            int value = Integer.parseInt(temp[1].replace(" ",""));
            if(map.containsKey(temp[0].trim())){
                map.put(key, map.get(key) + value);
            }else{
                map.put(key, value);
            }
//            al.add(new Word2Frequency(key, value));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            al.add(new Word2Frequency(entry.getKey(), entry.getValue()));
        }
        return al;
    }
}
