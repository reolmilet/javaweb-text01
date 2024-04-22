<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  //此部分内容应该在servlet中放入session或request属性中
  ArrayList<Product> prodList =  new ArrayList();
    prodList.add(new Product("a11","b11",111,"c11"));
    prodList.add(new Product("a22","b22",33,"c22"));
    prodList.add(new Product("a33"));
    prodList.add(new Product("a44","b44",1111,"c22"));
    prodList.add(new Product("a55"));
    prodList.add(new Product("a66","b66",88,"c22"));
     session.setAttribute("pl" ,prodList);

%>


<c:forEach items="${sessionScope.pl}" var="product" varStatus="vs" step="2">
    ${vs.count}： <c:out value="product"/> -------
    <c:out value="${product}"/>----
    <c:out value="${product.price}" />*****
    <c:out value="${product.product_name}"  default="无名氏"  /> <br>


</c:forEach>
</body>
</html>
