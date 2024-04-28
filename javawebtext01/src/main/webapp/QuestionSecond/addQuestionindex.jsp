<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<style>
    table,table tr th, table tr td { border:4px solid #5694ff; }
    table { width: 500px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;}
</style>


<h1>注册界面</h1>
<form action="<%=request.getContextPath()%>/AddQuestionServlet" method="post">
    <table>
        <tr>
            <td>题目</td>
            <td><input type="text" name="title"></td>
        </tr>

        <tr>
            <td>选项A</td>
            <td><input type="text" name="optionA"></td>
        </tr>
        <tr>
            <td>选项B</td>
            <td><input type="text" name="optionB"></td>
        </tr>
        <tr>
            <td>选项C</td>
            <td><input type="text" name="optionC"></td>
        </tr>
        <tr>
            <td>选项D</td>
            <td><input type="text" name="optionD"></td>
        </tr>
        <tr>
            <td>答案</td>
            <td>
                A<input type="radio" name="answer" value="A">
                B<input type="radio" name="answer" value="B">
                C<input type="radio" name="answer" value="C">
                D<input type="radio" name="answer" value="D">
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>

</body>
</html>