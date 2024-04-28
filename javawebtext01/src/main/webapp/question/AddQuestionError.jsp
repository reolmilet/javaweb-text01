<%@ page import="com.example.javawebtext01.main.pojo.QuestionData" %><%--
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
<p>出错啦！可能是您不是管理员,或者您还没登录</p>

<a href="<%=request.getContextPath()%>/secondpage/findindex.jsp" target="right">登录界面</a>

</body>
</html>
