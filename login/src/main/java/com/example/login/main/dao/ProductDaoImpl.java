package com.example.login.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.login.main.pojo.Product;

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
            this.pstmt.close();
            return product; // 如果查询不到结果则返回null,默认值为null

    }




}
