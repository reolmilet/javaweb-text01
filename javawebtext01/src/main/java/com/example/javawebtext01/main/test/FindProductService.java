package com.example.javawebtext01.main.test;

import com.example.javawebtext01.main.factory.DAOFactory;
import com.example.javawebtext01.main.pojo.Userdata;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FindProductServlet", value = "/FindProductServlet")
public class FindProductService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Userdata userdata = null;
        try {
            userdata = DAOFactory.getIEmpDAOInstance().find(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (userdata != null) {
            request.getSession().setAttribute("userdata", userdata);
            response.sendRedirect(request.getContextPath()+"/loding/findwelcome.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/loding/finderror.jsp");
        }
    }
}

