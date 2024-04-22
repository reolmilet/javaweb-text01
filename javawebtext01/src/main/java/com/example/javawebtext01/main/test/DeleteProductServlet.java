package com.example.javawebtext01.main.test;

import com.example.javawebtext01.main.factory.DAOFactory;
import com.example.javawebtext01.main.pojo.Userdata;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", value = "/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Userdata userdataid = (Userdata) session.getAttribute("userdata");

        boolean bo = false;
        try {
            bo = DAOFactory.getIEmpDAOInstance().delete(userdataid.getUserId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute("delete", bo);
        if(bo==true) {


            response.sendRedirect(request.getContextPath()+"/loding/deletewelcome.jsp");


            System.out.println("删除成功");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/loding/deleteerror.jsp");

            System.out.println("删除失败");
        }

    }}


