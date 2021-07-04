package com.example.rwredis;

import com.example.rwredis.entity.NewsBrief;
import com.example.rwredis.service.ReadNewsBrief;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.Write2Mysql
 * @Description:
 * @create: 2021-05-21
 */
public class WriteNews2Mysql {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/x_learning_system";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "toor";

    ReadNewsBrief readNewsBrief = new ReadNewsBrief();
    public void Store(){
        ArrayList<NewsBrief> list = readNewsBrief.readCsv();
        BufferedReader bufferedReader = null;
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String encoding = "UTF-8";
            PreparedStatement pstmt = conn.prepareStatement(
                    "insert into news(" +
                            "id,url,title,`date`,origin)" +
                            "values(?,?,?,?,?)");
            for(int i = 0; i<list.size(); i++){
                pstmt.setString(1, list.get(i).getId());
                pstmt.setString(2, list.get(i).getUrl());
                pstmt.setString(3, list.get(i).getTitle());
                pstmt.setString(4, list.get(i).getDate());
                pstmt.setString(5, list.get(i).getOrigin());
                try {
                    pstmt.executeUpdate();
                }catch (MySQLIntegrityConstraintViolationException e){
                    System.out.println(e.getMessage());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WriteNews2Mysql writeNews2Mysql = new WriteNews2Mysql();
        writeNews2Mysql.Store();
    }
}
