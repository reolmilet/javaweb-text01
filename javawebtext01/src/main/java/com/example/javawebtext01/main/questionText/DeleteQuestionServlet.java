package com.example.javawebtext01.main.questionText;

import com.example.javawebtext01.main.factory.DAOQuestionFactory;
import com.example.javawebtext01.main.pojo.QuestionData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "deleteQuestion", value = "/deleteQuestion")
public class DeleteQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int questionId = Integer.parseInt(request.getParameter("questionId"));

        boolean bo = false;
        try {
            bo = DAOQuestionFactory.getIEmpDAOInstance().deleteQuestion(questionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(bo==true) {


            response.sendRedirect(request.getContextPath()+"/FindQuestionListServlet");
            System.out.println("删除成功");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/loding/deleteerror.jsp");

            System.out.println("删除失败");
        }

    }}


