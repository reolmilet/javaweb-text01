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
<script>
    function invalidateSessions() {
        fetch('<%=request.getContextPath()%>/InvalidateSessionServlet')
            .then(response => response.text())
            .then(data => alert(data));
        top.location.href = "<%=request.getContextPath()%>/index.jsp";
    }
</script>
<body>
<ul>
    <ul>
        <h2>用户信息管理</h2>
        <li><a href="<%=request.getContextPath()%>/secondpage/addindex.jsp" target="right">注册界面</a></li>
        <li><a href="<%=request.getContextPath()%>/secondpage/findindex.jsp" target="right">查找界面</a></li>

    </ul>
    <ul>
         <h2>试题信息管理</h2>
        <li><a href="<%=request.getContextPath()%>/QuestionSecond/addQuestionindex.jsp" target="right">考试信息管理</a></li>
        <li><a href="<%=request.getContextPath()%>/FindQuestionListServlet" target="right">考试信息查询</a></li>

    </ul>
    <ul>
        <h2>考试管理</h2>
        <li><a href="<%=request.getContextPath()%>/FindQuestionListServlet?flag=setQuestion" target="right">参加考试</a></li>

        <li><a >试题信息查询</a></li>

    </ul>

    <br><br><br><br><br><br><br><br><br><br>
        <li><button onclick="invalidateSessions()">退出登录</button></li>



</ul>
</body>
</html>
