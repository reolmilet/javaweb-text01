<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet1111111</a>



<form action="AddProductServlet" method="get">
    <label for="studentName">学生姓名:</label>
    <select id="studentName" name="student_id">
        <option value="1">理解</option>
        <option value="2">钢蛋</option>
        <option value="3">张三</option>
        <option value="4"> 张一</option>
        <option value="7">铁锤</option>
        <option value="5">张二</option>
        <option value="6">张四</option>
        <option value="8">李三</option>
        <option value="9"> 李一</option>
        <option value="10">李二</option>
        <option value="11">李四</option>
        <option value="12"> 如花</option>
        <option value="13">刘三</option>
        <option value="14">刘一</option>
        <option value="15">刘二</option>
        <option value="16">刘四</option>
    </select>
    <br>
    <label for="subject">科目:</label>
    <select id="subject" name="course_id">
        <option value="1">生物</option>
        <option value="2">物理</option>
        <option value="3">体育</option>
        <option value="4">美术</option>
    </select>
    <br>
    <label for="inputBox">输入框:</label>
    <input type="text" id="inputBox" name="num">
    <input type="submit" value="添加">
</form>

</body>
</html>