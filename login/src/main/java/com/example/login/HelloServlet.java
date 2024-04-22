package com.example.login;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Jdbetest", value = "/myservlet/jdbetest")
public class HelloServlet extends HttpServlet {
    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("-------------------");
//        Connection con = null;
//        Statement st = null;
//        ResultSet rs = null;
//
//        //1加载驱动
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("数据库加载错误");
//        }
//        //第二步：获取数据库连接
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb01?serverTimezone=UTC","root","wzj040729");
//            //第三步：获取数据库操作对象
//            st=con.createStatement();
//            rs = st.executeQuery("select  * from  student");
//            //第四步：执行SQL语句
//            st.executeQuery("UPDATE students SET gender = '男' from student ");
//
//            //第五步：处理查询结果集
//            while (rs.next()){
//                int sid= rs.getInt(1);
//                String coursename =  rs.getString("sname");
//                String gender = rs.getString(2);
//                System.out.println("id="+sid+"   snmae = "+coursename+"  gender = "+gender);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("数据库链接错误");
//        }finally {
//            //第六步：释放资源
//            try {
//                st.close();
//                rs.close();
//                con.close();
//
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------------");
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        //1加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库加载错误");
        }
        //第二步：获取数据库连接
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb01?serverTimezone=UTC&rewriteBatchedStatements=true", "root", "wzj040729");
            //第三步：获取数据库操作对象
            //st = con.createStatement();
//            // 执行更新操作
//            int updatedRows = st.executeUpdate("UPDATE student SET gender = '女'");
//            System.out.println("更新了 " + updatedRows + " 行。");
//            rs = st.executeQuery("select  * from  student");
//            //第四步：处理查询结果集
//            while (rs.next()){
//                int sid= rs.getInt(1);
//                String coursename =  rs.getString("sname");
//                String gender = rs.getString(2);
//                System.out.println("id="+sid+"   snmae = "+coursename+"  gender = "+gender);
//            }
//            // 关闭结果集
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("数据库链接错误");
//        }finally {
//            //第六步：释放资源
//            try {
//                st.close();
//                con.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            // SQL 查询语句，使用 ? 作为占位符

            String sql = "INSERT INTO student(sid, gender, class_id, sname) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            String sid = request.getParameter("sid");
            String gender = request.getParameter("gender");
            String classid = request.getParameter("classid");
            String sname = request.getParameter("sname");
            // 创建 PreparedStatement 对象
            // 设置第一个参数为字符串类型
            for(int i =1; i <= 3; i++) {
                preparedStatement.setString(1, sid+i);
                preparedStatement.setString(2, gender);
                preparedStatement.setString(3, classid);
                preparedStatement.setString(4, sname);
                //1、暂时缓存sql，缓存一定数量之后再与数据库交互，进行插入
                preparedStatement.addBatch();

                // 执行 SQL 语句
                //if(i % 1000 == 0) {//缓存1000个sql,执行一次数据库插入的交互
                    preparedStatement.executeBatch();     // execute sql
                    //3、清空batch
                    preparedStatement.clearBatch();   // clean batch
                //}


            }
            long last = System.currentTimeMillis();


            //在使用完 PreparedStatement 后，应该及时关闭它以释放资源。
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
