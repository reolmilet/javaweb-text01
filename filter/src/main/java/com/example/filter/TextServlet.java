package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TextServlet", value = "/Text.do")
public class TextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>TextServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>TextServlet</h1>");
        out.println("dsads<br>色情<br>情色<br>赌博<br>博彩<br>娱乐<br>游戏<br>游艺<br>赌场<br>赌钱<br>赌球");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
