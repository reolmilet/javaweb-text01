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
import java.util.Collections;
import java.util.List;

@WebServlet(name = "FindQuestionListServlet", value = "/FindQuestionListServlet")
public class FindQuestionListService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        String setQuestion = "setQuestion";

        List<QuestionData> questionDataList = null;
        QuestionData questionData = null;
        HttpSession session = request.getSession();
        Userdata userdata = (Userdata) session.getAttribute("userdata");
        if (userdata == null) {
            response.sendRedirect(request.getContextPath() + "/question/findallerror.jsp");
            return;
        }

        if (userdata.getManager() == 1) {

            try {

                questionDataList = DAOQuestionFactory.getIEmpDAOInstance().findQuestionAll();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (questionDataList != null) {
                if (flag == null) {
                    request.getSession().setAttribute("questionDataList", questionDataList);

                    response.sendRedirect(request.getContextPath() + "/question/findallwelcome.jsp");
                    return;
                }
                else {
                    List<QuestionData> questionDataList1 = questionDataList;
                    Collections.shuffle(questionDataList1);
                    List<QuestionData> questionDataList2 = questionDataList1.subList(0, 4);
                    request.getSession().setAttribute("setQuestion", questionDataList2);
                    response.sendRedirect(request.getContextPath() + "/QuestionSecond/setQuestion.jsp");
                    return;
                }


            } else {
                response.sendRedirect(request.getContextPath() + "/loding/findallerror.jsp");
            }
        } else {

            response.sendRedirect(request.getContextPath() + "/loding/findallerror.jsp");
        }
    }
}

