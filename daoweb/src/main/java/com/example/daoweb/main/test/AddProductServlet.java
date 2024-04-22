package com.example.daoweb.main.test;

import com.example.daoweb.main.factory.DAOFactory;
import com.example.daoweb.main.pojo.Product;
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
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
                Product student = null;
                try {
                    student = DAOFactory.getIEmpDAOInstance().find(sid, sname);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        if (student != null) {
            // 不论session中是否已有学生信息，都将新的学生信息保存到session中
            request.getSession().setAttribute("student", student);
            Integer visitorCount = (Integer) getServletContext().getAttribute("visitorCount");
            if (visitorCount == null) {
                visitorCount = 0;
            }

            // 增加访问者计数
            visitorCount++;
            this.getServletContext().setAttribute("visitorCount", visitorCount);

            response.sendRedirect(request.getContextPath()+"/loding/welcome.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/loding/error.jsp");
        }
//        if (student != null) {
//            // 不论session中是否已有学生信息，都将新的学生信息保存到session中
//            request.getSession().setAttribute("student", student);
//
//            // 从session中获取标志
//            Boolean hasVisited = (Boolean) request.getSession().getAttribute("hasVisited");
//
//            // 如果标志为null或者false，表示用户还没有访问过
//            if (hasVisited == null || !hasVisited) {
//                // 将标志设置为true，并保存到session中
//                request.getSession().setAttribute("hasVisited", true);
//
//                // 增加访问者计数
//                Integer visitorCount = (Integer) getServletContext().getAttribute("visitorCount");
//                if (visitorCount == null) {
//                    visitorCount = 0;
//                }
//                visitorCount++;
//                getServletContext().setAttribute("visitorCount", visitorCount);
//            }
//
//            response.sendRedirect(request.getContextPath()+"/loding/welcome.jsp");
//        } else {
//            response.sendRedirect(request.getContextPath()+"/loding/error.jsp");
//        }
        }
    }//恶意登陆：可以在session中设立标识，如果是再一次的登录，标识为true

