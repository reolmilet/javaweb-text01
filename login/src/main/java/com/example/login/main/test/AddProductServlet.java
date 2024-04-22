package com.example.login.main.test;

import com.example.login.main.dao.ProductDao;
import com.example.login.main.dao.ProductDaoImpl;
import com.example.login.main.service.ProductDaoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.login.main.factory.DAOFactory;
import com.example.login.main.pojo.Product;

import java.io.IOException;

//@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
        Product student = null;
        try {
            student = DAOFactory.getIEmpDAOInstance().find(sid, sname);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (student != null) {
            Product product = (Product) request.getSession().getAttribute("student");
            if (product == null) {
                request.getSession().setAttribute("student", student);
                Integer visitorCount = (Integer) getServletContext().getAttribute("visitorCount");
                if (visitorCount == null) {
                    visitorCount = 0;
                }

                // 增加访问者计数
                visitorCount++;
                getServletContext().setAttribute("visitorCount", visitorCount);

                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect(request.getContextPath()+"/loding/welcome.jsp");
            }

            } else {
                response.sendRedirect(request.getContextPath()+"/loding/error.jsp");
            }
        }
    }

