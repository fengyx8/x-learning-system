package com.example.rwredis.service;
import com.csvreader.CsvReader;
import com.example.rwredis.entity.NewsBrief;

import java.nio.charset.Charset;
import java.util.ArrayList;


/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis.service
 * @Description:
 * @create: 2021-05-21
 */
public class ReadNewsBrief {
    NewsBrief newsBrief = null;
    CsvReader r;

    public ArrayList<NewsBrief> readCsv()
    {
        ArrayList<NewsBrief> newsBriefList = new ArrayList<NewsBrief>();
        String csvFilePath = this.getClass().getResource("/allData.csv").toString().replaceFirst("file:/", "");
        try {
            r = new CsvReader(csvFilePath,',', Charset.forName("gbk"));
            //读取表头
            r.readHeaders();
            //逐条读取记录，直至读完
            int i=0;
            while (r.readRecord()) {
                i++;
//                System.out.println("num:"+i);
                newsBrief = new NewsBrief();
                newsBrief.setId(r.get("id"));
                newsBrief.setUrl(r.get("url"));
                newsBrief.setTitle(r.get("title"));
                newsBrief.setDate(r.get("date"));
                newsBrief.setOrigin(r.get("origin"));
                newsBriefList.add(newsBrief);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsBriefList;
    }
}
