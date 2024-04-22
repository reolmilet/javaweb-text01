package com.example.jsp.main.test;

import com.example.jsp.main.factory.DAOFactory;
import com.example.jsp.main.pojo.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String class_id = request.getParameter("class_id");

        List<Product> products = null;
                try {
                    products = DAOFactory.getIEmpDAOInstance().find(class_id);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        if (products != null) {
            // 不论session中是否已有学生信息，都将新的学生信息保存到session中
            request.getSession().setAttribute("products", products);


            response.sendRedirect(request.getContextPath()+"/loding/welcome.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/loding/error.jsp");
        }

        }
    }//恶意登陆：可以在session中设立标识，如果是再一次的登录，标识为true

