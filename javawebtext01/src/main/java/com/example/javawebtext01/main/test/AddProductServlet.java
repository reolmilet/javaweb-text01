package com.example.javawebtext01.main.test;

import com.example.javawebtext01.main.factory.DAOFactory;
import com.example.javawebtext01.main.pojo.Userdata;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int userid = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex" );
        String email = request.getParameter("email");
        int manager = Integer.parseInt(request.getParameter("isAdmin"));
        Userdata userdata = new Userdata(username, password,sex,email,manager);
        boolean bo = false;
        try {
            bo = DAOFactory.getIEmpDAOInstance().add(userdata);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute("add", bo);
        if(bo==true) {
            request.getSession().setAttribute("adduserdata", userdata);
            Integer visitorCount = (Integer) getServletContext().getAttribute("visitorCount");
            if (visitorCount == null) {
                visitorCount = 0;
            }

            // 增加访问者计数
            visitorCount++;
            this.getServletContext().setAttribute("visitorCount", visitorCount);

            response.sendRedirect(request.getContextPath()+"/loding/welcome.jsp");


            System.out.println("添加成功");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/loding/error.jsp");

            System.out.println("添加失败");
        }

    }}


