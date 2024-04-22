<%--
  Created by IntelliJ IDEA.
  User: wangz
  Date: 2024/4/20
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <ul>
        <h2>用户信息管理</h2>
        <li><a href="<%=request.getContextPath()%>/secondpage/addindex.jsp" target="right">注册界面</a></li>
        <li><a href="<%=request.getContextPath()%>/secondpage/findindex.jsp" target="right">登录界面</a></li>

    </ul>
    <ul>
        <h2>考试信息管理</h2>
        <li>试题信息注册</li>
        <li>试题信息查询</li>
    </ul>
    <ul>
        <h2>考试管理</h2>
        <li>参加考试</li>
        <li>试题信息查询</li>
    </ul>

</ul>
</body>
</html>
