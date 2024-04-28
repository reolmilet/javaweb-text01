<%@ page import="com.example.javawebtext01.main.pojo.QuestionData" %><%--
  Created by IntelliJ IDEA.
  User: wangz
  Date: 2024/3/26
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%
    QuestionData questionData = (QuestionData) session.getAttribute("addQuestionData");

%>
<p>录入成功 您的题目为 <%= questionData.getTitle() %> </p>


<a href="<%=request.getContextPath()%>/QuestionSecond/addQuestionindex.jsp" target="right">继续添加</a>
</body>
</html>
