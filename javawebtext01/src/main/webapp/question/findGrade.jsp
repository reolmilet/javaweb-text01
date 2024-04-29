<%@ page import="com.example.javawebtext01.main.pojo.Userdata" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.javawebtext01.main.pojo.QuestionData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table,table tr th, table tr td { border:4px solid #5694ff; }
    table { width: 500px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;}
</style>
<body>
<%
    List < QuestionData>questionDataList = (List < QuestionData>) session.getAttribute("errorQuestionDataList");
    int grade = (int) session.getAttribute("grade");
%>
<h2 >您的分数为${grade}</h2>
<h1>所有错题的信息为</h1>
<table>
    <tr>
        <th>题目ID</th>
        <th>题目</th>
        <th>答案</th>
        <th>选项 A</th>
        <th>选项 B</th>
        <th>选项 C</th>
        <th>选项 D</th>

        <th>详细信息</th>
    </tr>
    <c:forEach var="errorquestionData" items="${sessionScope.errorQuestionDataList}">
        <tr>
            <td>${errorquestionData.questionId}</td>
            <td>${errorquestionData.title}</td>
            <td>${errorquestionData.answer}</td>
            <td>${errorquestionData.optionA}</td>
            <td>${errorquestionData.optionB}</td>
            <td>${errorquestionData.optionC}</td>
            <td>${errorquestionData.optionD}</td>

          <td><button onclick="alert('本题的出题者为${errorquestionData.admin}   出题时间为${errorquestionData.date}')">详细信息</button></td>


        </tr>
    </c:forEach>
</table>


</body>
</html>