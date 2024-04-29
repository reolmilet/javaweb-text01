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

<h1>您的试题的信息为</h1>

<table>
    <tr>
        <th>题目ID</th>
        <th>题目</th>

        <th>选项 A</th>
        <th>选项 B</th>
        <th>选项 C</th>
        <th>选项 D</th>
        <th>答案</th>

    </tr>
    <c:forEach var="questionData" items="${sessionScope.setQuestion}">
        <tr>
            <td>${questionData.questionId}</td>
            <td>${questionData.title}</td>

            <td>${questionData.optionA}</td>
            <td>${questionData.optionB}</td>
            <td>${questionData.optionC}</td>
            <td>${questionData.optionD}</td>
<td> <input type="radio" id="option1" name="option" value="A">
    <label for="option1">A</label><br>
    <input type="radio" id="option2" name="option" value="B">
    <label for="option2">B</label><br>
    <input type="radio" id="option3" name="option" value="C">
    <label for="option3">C</label><br>
    <input type="radio" id="option4" name="option" value="D">
    <label for="option4">D</label><br>
</td>


        </tr>
    </c:forEach>
</table>


</body>
</html>