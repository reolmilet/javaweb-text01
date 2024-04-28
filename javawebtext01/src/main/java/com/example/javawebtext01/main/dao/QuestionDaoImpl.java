package com.example.javawebtext01.main.dao;

import com.example.javawebtext01.main.pojo.QuestionData;
import com.example.javawebtext01.main.pojo.Userdata;

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

    @Override
    public List<QuestionData> findQuestionAll() throws Exception {
        List<QuestionData>listQuestionUser=new ArrayList<>();
        String sql = "select  questionId,title, optionA, optionB, optionC, optionD, answer, admin, `delete`,date from question  where `delete`=0";
        this.pstmt = this.conn.prepareStatement(sql);

        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()) {
            QuestionData questionData = new QuestionData();

            questionData.setQuestionId(rs.getInt(1));
            questionData.setTitle(rs.getString(2));
            questionData.setOptionA(rs.getString(3));
            questionData.setOptionB(rs.getString(4));
            questionData.setOptionC(rs.getString(5));
            questionData.setOptionD(rs.getString(6));
            questionData.setAnswer(rs.getString(7));
            questionData.setAdmin(rs.getString(8));
            questionData.setDelete(rs.getInt(9));
            questionData.setDate(rs.getString(10));
            listQuestionUser.add(questionData);


        }


        this.pstmt.close();
        return listQuestionUser;
    }

    @Override
    public boolean deleteQuestion(int questionId) throws Exception {
        boolean flag = false; // 定义标识
        String sql = "UPDATE question SET `delete`=1 WHERE questionId = ?";
        this.pstmt = this.conn.prepareStatement(sql);// 实例化PrepareStatement对象
        this.pstmt.setInt(1, questionId);

        if (this.pstmt.executeUpdate() > 0) { // 更新记录的行数大于0
            flag = true; // 修改标识
        }
        this.pstmt.close(); // 关闭PreparedStatement操作
        return flag;
    }
}
