package com.example.javawebtext01.main.test;

import com.example.javawebtext01.main.factory.DAOFactory;
import com.example.javawebtext01.main.pojo.Userdata;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindProductlistServlet", value = "/FindProductlistServlet")
public class FindProductlistService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<Userdata> userdatalist = null;
        Userdata userdata = null;
        try {
            userdata = DAOFactory.getIEmpDAOInstance().find(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (userdata == null) {
            response.sendRedirect(request.getContextPath() + "/loding/findallerror.jsp");
            return;
        }
        if (userdata.getManager()==1) {

            try {

                userdatalist = DAOFactory.getIEmpDAOInstance().findall(username, password);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (userdatalist != null) {



                request.getSession().setAttribute("userdatalist", userdatalist);

                response.sendRedirect(request.getContextPath() + "/loding/findallwelcome.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/loding/findallerror.jsp");
            }
        }
        else {

            response.sendRedirect(request.getContextPath() + "/loding/findallerror.jsp");
        }
    }
}

