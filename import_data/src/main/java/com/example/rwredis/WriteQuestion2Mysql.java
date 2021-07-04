package com.example.rwredis;

import com.example.rwredis.entity.NewsBrief;
import com.example.rwredis.entity.Question;
import com.example.rwredis.service.ReadNewsBrief;
import com.example.rwredis.service.ReadQuestion;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis
 * @Description:
 * @create: 2021-06-16
 */
public class WriteQuestion2Mysql {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/x_learning_system";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "toor";

    ReadQuestion readQuestion = new ReadQuestion();
    public void Store() throws Exception {
        ArrayList<Question> list = ReadQuestion.readDB();
//        BufferedReader bufferedReader = null;
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String encoding = "UTF-8";
            PreparedStatement pstmt = conn.prepareStatement(
                    "insert into question(" +
                            "problem, stdAns, optionA, optionB, optionC, optionD, analysis, points, answererNumber, correctAnsNumber)" +
                            "values(?,?,?,?,?,?,?,?,?,?)");
            for(int i = 0; i<list.size(); i++){
                pstmt.setString(1, list.get(i).getProblem());
                pstmt.setString(2, list.get(i).getStdAns());
                pstmt.setString(3, list.get(i).getOptionA());
                pstmt.setString(4, list.get(i).getOptionB());
                pstmt.setString(5, list.get(i).getOptionC());
                pstmt.setString(6, list.get(i).getOptionD());
                pstmt.setString(7, list.get(i).getAnalysis());
                pstmt.setInt(8, list.get(i).getPoints());
                pstmt.setInt(9, list.get(i).getAnswererNumber());
                pstmt.setInt(10, list.get(i).getCorrectAnsNumber());
                try {
                    pstmt.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
//                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        WriteQuestion2Mysql writeQuestion2Mysql = new WriteQuestion2Mysql();
        writeQuestion2Mysql.Store();
    }
}
