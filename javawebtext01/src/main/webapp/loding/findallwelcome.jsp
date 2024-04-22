<%@ page import="com.example.javawebtext01.main.pojo.Userdata" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    List <Userdata> userdataList = (List <Userdata>) session.getAttribute("userdatalist");

    //System.out.println(userdataList);


%>



<%--为什么要加sessionScope.userdatalist--%>
<h1>全体学生的信息为</h1>
<table>
    <tr>
        <th>姓名</th>
        <th>学号</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>密码</th>
        <th>是否为管理员</th>
    </tr>
    <c:forEach var="userdata" items="${sessionScope.userdatalist}">
        <tr>
            <td>${userdata.userName}</td>
            <td>${userdata.userId}</td>
            <td>${userdata.sex}</td>
            <td>${userdata.email}</td>
            <td>${userdata.password}</td>
            <td>${userdata.manager==1?"是":"否"}</td>
        </tr>
    </c:forEach>
</table>


<a href="<%=request.getContextPath()%>/secondpage/findindex.jsp" target="right">登录界面</a>
</body>
</html>