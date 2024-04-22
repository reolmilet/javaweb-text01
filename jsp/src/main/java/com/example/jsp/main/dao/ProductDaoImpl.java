package com.example.jsp.main.dao;

import com.example.jsp.main.pojo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private Connection conn = null; // 数据库连接对象
    private PreparedStatement pstmt = null; // 数据库操作对象

    // 通过构造方法取得数据库连接
    public ProductDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Product> find(String class_id) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "select sid,sname,gender,class_id from student where class_id=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, class_id); // 设置产品编号
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setSid(String.valueOf(rs.getInt(1)));
            product.setSname(rs.getString(2));
            product.setGender(rs.getString(3));
            product.setClass_id(String.valueOf(rs.getInt(4)));
            products.add(product);
        }
        this.pstmt.close();
        return products; // 如果查询不到结果则返回空列表
    }
}