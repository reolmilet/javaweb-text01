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

<h1>注册界面</h1>
<form action="<%=request.getContextPath()%>/UpdateProductServlet" method="post">
    <table >
    <tr>
        <td>用户姓名</td>
        <td><input type="text" name="username" value="<%= userdata.getUserName() %>"></td>
    </tr>
    <tr>
        <td>用户密码</td>
        <td><input type="text" name="password" value="<%= userdata.getPassword() %>"></td>
    </tr>
    <tr>
        <td>用户性别</td>
        <td><input type="text" name="sex" value="<%= userdata.getSex() %>"></td>
    </tr>
    <tr>
        <td>用户邮箱</td>
        <td><input type="text" name="email" value="<%= userdata.getEmail() %>"></td>
    </tr>
        <tr>
            <td>是否为管理员</td>
            <td>是<input type="radio" name="isAdmin" value="1">
                不是<input type="radio" name="isAdmin" value="0"></td>
        </tr>
    <tr>
        <td ><input type="submit" value="更新"></td>
        <td ><input type="reset" value="重置"></td>
    </tr>
</table>
</form>

<a href="<%=request.getContextPath()%>/secondpage/findindex.jsp" target="right">登录界面</a>


</body>
</html>