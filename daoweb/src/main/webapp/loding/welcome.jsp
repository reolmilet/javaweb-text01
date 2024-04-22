<%@ page import="com.example.daoweb.main.pojo.Product" %><%--
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
    Product student = (Product) session.getAttribute("student");
    int visitorCount = (Integer) application.getAttribute("visitorCount");
%>
<p>欢迎 <%= student.getSname() %>，你是第 <%= visitorCount %> 个访问本网站的学生。</p>
<p>你的学号是 <%= student.getSid() %>。</p>
</body>
</html>
