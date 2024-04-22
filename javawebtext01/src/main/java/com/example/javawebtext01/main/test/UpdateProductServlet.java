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

@WebServlet(name = "UpdateProductServlet", value = "/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        Userdata userdataid = (Userdata) session.getAttribute("userdata");
        Userdata userdata = new Userdata(username, password,sex,email,manager);

        boolean bo = false;
        try {
            bo = DAOFactory.getIEmpDAOInstance().update(userdata,userdataid.getUserId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Userdata userdata2 =null;
        try {
            userdata2 = DAOFactory.getIEmpDAOInstance().find(userdata.getUserName(),userdata.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("update", bo);
        if(bo==true) {
            request.getSession().setAttribute("updateuserdata", userdata2);


            response.sendRedirect(request.getContextPath()+"/loding/updatewelcome.jsp");


            System.out.println("更新成功");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/loding/updateerror.jsp");

            System.out.println("更新失败");
        }

    }}


