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
    ArrayList<Product> prodList =  new ArrayList();
    prodList.add(new Product("a11","b11",111,"c11"));
    prodList.add(new Product("a22","b22",33,"c22"));
    prodList.add(new Product("a33"));
    prodList.add(new Product("a44","b44",1111,"c22"));
    prodList.add(new Product("a55"));
    prodList.add(new Product("a66","b66",88,"c22"));
    session.setAttribute("pl" ,prodList);

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