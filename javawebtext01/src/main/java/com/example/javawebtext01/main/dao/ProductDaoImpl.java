package com.example.javawebtext01.main.dao;

import com.example.javawebtext01.main.dao.ProductDao;
import com.example.javawebtext01.main.pojo.Userdata;

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
    public boolean add(Userdata userdata) throws Exception {
        boolean flag = false; // 定义标识
        String sql = "insert into users( userName, password, sex, email,manager,delite) values(?,?,?,?,?,0)";

        this.pstmt = this.conn.prepareStatement(sql);// 实例化PrepareStatement对象


        //this.pstmt.setInt(1, userdata.getUserId());
        this.pstmt.setString(1,userdata.getUserName());
        this.pstmt.setString(2,userdata.getPassword());
        this.pstmt.setString(3,userdata.getSex());
        this.pstmt.setString(4,userdata.getEmail());
        this.pstmt.setInt(5, userdata.getManager());
        //System.out.println("product.getStudent_id()---"+product.getStudent_id());

        if (this.pstmt.executeUpdate() > 0) { // 更新记录的行数大于0
            flag = true; // 修改标识
        }
        this.pstmt.close(); // 关闭PreparedStatement操作
        return flag;
    }

    @Override
    public Userdata find(String username, String password) throws SQLException {



        Userdata userdata = null;
        String sql = "select userId,userName,password,email,sex,manager from users where userName=? and password=? and delite=0";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, username); // 设置产品编号
        this.pstmt.setString(2, password);
        ResultSet rs = this.pstmt.executeQuery();
        if (rs.next()) {
            userdata = new Userdata();
            userdata.setUserId(rs.getInt(1));
            userdata.setUserName(rs.getString(2));
            userdata.setPassword(rs.getString(3));
            userdata.setEmail(rs.getString(4));
            userdata.setSex(rs.getString(5));
            userdata.setManager(rs.getInt(6));
        }


        this.pstmt.close();
        return userdata; // 如果查询不到结果则返回null,默认值为null

    }

    @Override
    public List<Userdata> findall(String username, String password) throws Exception {
        List<Userdata>listuser=new ArrayList<>();
        String sql = "select userId,userName,password,email,sex,manager from users  where delite=0";
        this.pstmt = this.conn.prepareStatement(sql);

        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()) {
            Userdata userdata = new Userdata();

            userdata.setUserId(rs.getInt(1));
            userdata.setUserName(rs.getString(2));
            userdata.setPassword(rs.getString(3));
            userdata.setEmail(rs.getString(4));
            userdata.setSex(rs.getString(5));
            userdata.setManager(rs.getInt(6));
            System.out.println(userdata);
            listuser.add(userdata);
            System.out.println(listuser);
        }


        this.pstmt.close();
        return listuser;
    }

    @Override
    public boolean update(Userdata userdata,int uid) throws Exception {
        boolean flag = false; // 定义标识
        String sql = "UPDATE users SET userName=?,password=?,email=?,sex=?,manager=? WHERE userId = ?";

        this.pstmt = this.conn.prepareStatement(sql);// 实例化PrepareStatement对象


        //this.pstmt.setInt(1, userdata.getUserId());
        this.pstmt.setString(1,userdata.getUserName());
        this.pstmt.setString(2,userdata.getPassword());
        this.pstmt.setString(3,userdata.getEmail());
        this.pstmt.setString(4,userdata.getSex());
        this.pstmt.setInt(5, userdata.getManager());
        this.pstmt.setInt(6, uid);
        //System.out.println("product.getStudent_id()---"+product.getStudent_id());

        if (this.pstmt.executeUpdate() > 0) { // 更新记录的行数大于0
            flag = true; // 修改标识
        }
        this.pstmt.close(); // 关闭PreparedStatement操作
        return flag;
    }

    @Override
    public boolean delete(int uid) throws Exception {
        boolean flag = false; // 定义标识
        String sql = "UPDATE users SET delite=1 WHERE userId = ?";
        this.pstmt = this.conn.prepareStatement(sql);// 实例化PrepareStatement对象
        this.pstmt.setInt(1, uid);

        if (this.pstmt.executeUpdate() > 0) { // 更新记录的行数大于0
            flag = true; // 修改标识
        }
        this.pstmt.close(); // 关闭PreparedStatement操作
        return flag;
    }
}
