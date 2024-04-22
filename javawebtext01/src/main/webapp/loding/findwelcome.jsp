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

<style>
    table,table tr th, table tr td { border:4px solid #5694ff; }
    table { width: 500px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;}
</style>
<body>
<%
    Userdata userdata = (Userdata) session.getAttribute("userdata");

%>
<table>
    <tr>
        <td>用户姓名</td>
        <td><%= userdata.getUserName() %></td>
    </tr>
    <tr>
        <td>学号</td>
        <td><%= userdata.getUserId() %></td>
    </tr>
    <tr>
        <td>用户性别</td>
        <td><%= userdata.getSex()%></td>
    </tr>
    <tr>
        <td>用户邮箱</td>
        <td><%= userdata.getEmail() %></td>
    </tr>
    <tr>
        <td>用户密码</td>
        <td><%= userdata.getPassword() %></td>
    </tr>
    <tr>
        <td>是否为管理员</td>
        <td><%= userdata.getManager()==1?"是":"否" %></td>
    </tr>
</table>
<a href="<%=request.getContextPath()%>/secondpage/findindex.jsp" target="right">登录界面</a>
<br>
<a href="<%=request.getContextPath()%>/secondpage/updateindex.jsp" target="right">更新界面</a>

<br>
<a href="<%=request.getContextPath()%>/secondpage/deleteindex.jsp" target="right">删除界面</a>


</body>
</html>
