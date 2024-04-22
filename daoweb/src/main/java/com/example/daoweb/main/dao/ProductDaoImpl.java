package com.example.daoweb.main.dao;

import com.example.daoweb.main.pojo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {

    private Connection conn = null; // 数据库连接对象
    private PreparedStatement pstmt = null; // 数据库操作对象


    // 通过构造方法取得数据库连接
    public ProductDaoImpl(Connection conn) {

        this.conn = conn;
    }

    @Override
    public Product find(String sid, String sname) throws SQLException {

            Product product = null;
            String sql = "select sid,sname from student where sid=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, sid); // 设置产品编号
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setSid(String.valueOf(rs.getInt(1)));
                product.setSname(rs.getString(2));

            }
        String sql1 = "select student.sid,sname,cname ,num from student,score,course where student.sid=score.student_id and score.course_id=course.cid and student.sid=?";
        this.pstmt = this.conn.prepareStatement(sql1);
        this.pstmt.setString(1, sid); // 设置产品编号
        ResultSet rs1 = this.pstmt.executeQuery();
        while (rs1.next()) {
            product = new Product();
            product.setSid(String.valueOf(rs1.getInt(1)));
            product.setSname(rs1.getString(2));
            product.setCname(rs1.getString(3));
            product.setNum(rs1.getString(4));
            //System.out.println(product.toString());
            System.out.println("班级为"+product.getCname()+"的学生"+product.getSname()+"的成绩为"+product.getNum());

        }

            this.pstmt.close();
            return product; // 如果查询不到结果则返回null,默认值为null

    }




}
