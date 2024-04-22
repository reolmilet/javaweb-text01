package com.example.coures.main.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.coures.main.factory.DAOFactory;
import com.example.coures.main.pojo.Product;

import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();	//实例化Product对象

        product.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
        product.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
        product.setNum(Integer.parseInt(request.getParameter("num")));


        boolean flag = false;
        //执行添加操作
        try {
            //System.out.println("执行添加操作前");
            flag = DAOFactory.getIEmpDAOInstance().addProduct(product);
            //System.out.println("执行添加操作后");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag){

            System.out.println("添加产品信息成功");

        }else {

            System.out.println("添加产品信息失败");
        }
    }
}
