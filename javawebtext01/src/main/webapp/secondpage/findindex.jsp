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

<h1>登录界面</h1>

<form action="<%=request.getContextPath()%>/FindProductServlet" method="post">
    <table >
    <tr>
        <td>用户姓名</td>
        <td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>用户密码</td>
        <td><input type="text" name="password"></td>
    </tr>

    <tr>
        <td ><input type="submit" value="查找"></td>
        <td ><input type="reset" value="重置"></td>
    </tr>
</table>
</form>
<a href="<%=request.getContextPath()%>/secondpage/findindex.jsp" target="right">登录界面</a>
</body>
</html>