<%@ page import="com.example.javawebtext01.main.pojo.Userdata" %><%--
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
    Userdata userdata = (Userdata) session.getAttribute("adduserdata");
    int visitorCount = (Integer) application.getAttribute("visitorCount");
%>
<p>欢迎 <%= userdata.getUserName() %>，你是第 <%= visitorCount %> 个成功注册本网站的学生。</p>



</body>
</html>
