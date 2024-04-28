<%@ page import="com.example.javawebtext01.main.pojo.Userdata" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
<script>

</script>

<h1>所有试题的信息为</h1>
<table>
    <tr>
        <th>题目ID</th>
        <th>题目</th>
        <th>答案</th>
        <th>选项 A</th>
        <th>选项 B</th>
        <th>选项 C</th>
        <th>选项 D</th>
        <th>删除</th>
        <th>详细信息</th>
    </tr>
    <c:forEach var="questionData" items="${sessionScope.questionDataList}">
        <tr>
            <td>${questionData.questionId}</td>
            <td>${questionData.title}</td>
            <td>${questionData.answer}</td>
            <td>${questionData.optionA}</td>
            <td>${questionData.optionB}</td>
            <td>${questionData.optionC}</td>
            <td>${questionData.optionD}</td>
            <td><a href="<%=request.getContextPath()%>/deleteQuestion?questionId=${questionData.questionId}">删除</a></td>
          <td><button onclick="alert('本题的出题者为${questionData.admin}   出题时间为${questionData.date}')">详细信息</button></td>


        </tr>
    </c:forEach>
</table>


</body>
</html>