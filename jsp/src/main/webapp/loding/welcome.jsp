<%@ page import="com.example.jsp.main.pojo.Product" %>
<%@ page import="com.example.jsp.main.pojo.Product" %>
<%@ page import="java.util.List" %><%--
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
<table border="1">
    <tr>
        <th>Class</th>
        <th>Name</th>
        <th>sex</th>
        <th>student_id</th>
    </tr>
    <%
        List<Product> products = ( List<Product> ) session.getAttribute("products");
        for(Product product : products) {
    %>
    <tr>
        <td><%= product.getClass_id() %></td>
        <td><%= product.getSname() %></td>
        <td><%= product.getGender() %></td>
        <td><%= product.getSid() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
