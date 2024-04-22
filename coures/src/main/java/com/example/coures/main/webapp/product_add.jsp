<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
  <head>
    <title>添加产品信息</title>
  </head>
  
  <body>
      <form action="AddProductServlet" method="post">
      		产品编号：<input name="sid"/><br>
      		产品名称：<input name="student_id"/><br>
      		产品价格：<input name="course_id"/><br>
      		产品信息：<textarea rows="" cols="" name="info"></textarea><br/>
      		<input type="submit" value="添加">&nbsp;&nbsp;
      		<input type="reset" value="重置">
      </form>
  </body>
</html>
