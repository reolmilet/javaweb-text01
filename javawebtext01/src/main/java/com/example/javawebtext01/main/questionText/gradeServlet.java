package com.example.javawebtext01.main.questionText;

import com.example.javawebtext01.main.pojo.QuestionData;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "gradeServlet", value = "/gradeServlet")
public class gradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<QuestionData>questionDataList=(List<QuestionData>) request.getSession().getAttribute("setQuestion");
        int grade=0;
        List<QuestionData> errorQuestionDataList = new ArrayList<>();
        for (int i = 0; i < questionDataList.size(); i++) {
            QuestionData questionData = questionDataList.get(i);


            if(questionData.getAnswer().equals(request.getParameter("option"+i))){
                grade+=25;
            }
            else {
                errorQuestionDataList.add(questionData);
            }
        }
        System.out.println(grade);
        request.getSession().setAttribute("grade",grade);
        request.getSession().setAttribute("errorQuestionDataList",errorQuestionDataList);
        if(grade==100){
            response.sendRedirect(request.getContextPath()+"/question/findallwelcome.jsp");
            return;
        }
        response.sendRedirect(request.getContextPath()+"/question/findGrade.jsp");
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
