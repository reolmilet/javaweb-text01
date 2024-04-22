<%@ page import="com.example.jsp116.pojo.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //本段代码应该在servlet，转发或者重定向到次jsp
    ArrayList  proList = new ArrayList<Product>();
    proList.add(new Product("aa1","bb1",1000,"cc11"));
    proList.add(new Product("aa2"));
    proList.add(new Product("aa3","bb3",1000,"c2333c"));
    proList.add(new Product("aa4"));
    proList.add(new Product("aa5","b5",1000,"c66c"));
    proList.add(new Product("aa6"));
    proList.add(new Product("aa7","bb7",1000,"c77c"));
    session.setAttribute("plist",proList);
%>

<table>
    <tr>
        <th>Index</th>
        <th>Count</th>
        <th>Item</th>
        <th>Product ID</th>
        <th>Product Name</th>
    </tr>
    <c:forEach  items="${sessionScope.plist}"  var="pItem"    varStatus="proStatus"  step="2"  begin="3">
        <tr>
            <td>${proStatus.index}</td>
            <td>${proStatus.count}</td>
            <td>${pItem}</td>
            <td>${pItem.product_id}</td>
            <td><c:out  value="${pItem.product_name}"  default="无名氏"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>