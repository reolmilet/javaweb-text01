<%@ page import="com.example.javawebtext01.main.pojo.Userdata" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<style>
    table,table tr th, table tr td { border:4px solid #5694ff; }
    table { width: 500px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;}
</style>
<%
    Userdata userdata = (Userdata) session.getAttribute("userdata");

%>

<h1>删除界面</h1>
<form action="<%=request.getContextPath()%>/DeleteProductServlet" method="post">
    <p>您的信息为</p>
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
    <input type="submit" value="确认删除">
</form>
<a href="<%=request.getContextPath()%>/secondpage/findindex.jsp" target="right">登录界面</a>

</body>
</html>