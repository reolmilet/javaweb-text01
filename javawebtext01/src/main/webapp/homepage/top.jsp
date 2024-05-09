<%--
  Created by IntelliJ IDEA.
  User: wangz
  Date: 2024/4/20
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">用户管理系统</h1>
<p style="position: fixed; top: 0; right: 0;">在线人数：<%=request.getServletContext().getAttribute("number")%></p>
</body>
</html>
