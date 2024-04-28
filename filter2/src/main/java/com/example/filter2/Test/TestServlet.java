package com.example.filter2.Test;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/Test.do"},
        loadOnStartup = 0,
        name = "TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<!DOCTYPE HTML>");

        out.println("<HTML>");
        out.println("<HEAD><TITLE>测试内容输出过滤</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("dfdasfdfdasf<br/>色情 <br/>情色 <br/>赌博");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }
}
