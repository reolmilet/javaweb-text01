package com.example.javawebtext01.main.dao;

import com.example.javawebtext01.main.pojo.QuestionData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {

    private Connection conn = null; // 数据库连接对象
    private PreparedStatement pstmt = null; // 数据库操作对象


    // 通过构造方法取得数据库连接
    public QuestionDaoImpl(Connection conn) {

        this.conn = conn;
    }


    @Override
    public boolean add(QuestionData questionData) throws Exception {
        boolean flag = false; // 定义标识
        String sql = "insert into question(  title, optionA, optionB, optionC, optionD, answer, admin, `delete`) values(?,?,?,?,?,?,?,0)";

        this.pstmt = this.conn.prepareStatement(sql);// 实例化PrepareStatement对象


        //this.pstmt.setInt(1, userdata.getUserId());
        this.pstmt.setString(1,questionData.getTitle());
        this.pstmt.setString(2,questionData.getOptionA());
        this.pstmt.setString(3,questionData.getOptionB());
        this.pstmt.setString(4,questionData.getOptionC());
        this.pstmt.setString(5,questionData.getOptionD());
        this.pstmt.setString(6,questionData.getAnswer());
        this.pstmt.setString(7,questionData.getAdmin());

        if (this.pstmt.executeUpdate() > 0) { // 更新记录的行数大于0
            flag = true; // 修改标识
        }
        this.pstmt.close(); // 关闭PreparedStatement操作
        return flag;
    }
}
