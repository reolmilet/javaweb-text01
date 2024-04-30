package com.example.javawebtext01.main.questionText;

import com.example.javawebtext01.main.factory.DAOQuestionFactory;
import com.example.javawebtext01.main.pojo.QuestionData;

import com.example.javawebtext01.main.pojo.Userdata;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddQuestionServlet", value = "/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String OptionA = request.getParameter("optionA");
        String OptionB = request.getParameter("optionB");
        String OptionC = request.getParameter("optionC");
        String OptionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");
        HttpSession session = request.getSession();
        Userdata userdata = (Userdata) session.getAttribute("userdata");
        if(userdata.getManager()==0){
            response.sendRedirect(request.getContextPath()+"/question/notManager.jsp");
            return;
        }
        if(userdata==null){
            response.sendRedirect(request.getContextPath()+"/question/AddQuestionError.jsp");
            return;
        }
        String admin = userdata.getUserName();

        QuestionData questionData = new QuestionData(title,answer,OptionA,OptionB,OptionC,OptionD,admin);


        boolean bo = false;
        try {
            bo = DAOQuestionFactory.getIEmpDAOInstance().add(questionData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute("addQuestion", bo);
        if(bo==true) {
            request.getSession().setAttribute("addQuestionData", questionData);

            response.sendRedirect(request.getContextPath()+"/question/AddQuestionWelcome.jsp");


            System.out.println("添加成功");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/question/AddQuestionError.jsp");

            System.out.println("添加失败");
        }

    }}


