<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>LoginPage</title>
</head>
<%
    request.getSession().setAttribute("UserName", null);
    request.getSession().setAttribute("ID", null);
%>
<body>
<h1>LF_login</h1>
<!-- 创建表单,包含ID,Password -->
<form action="${pageContext.request.contextPath}/logcheck" method="post">
    <table>
        <tr>
            <td>Your ID:</td>
            <td><input type="text" name="ID" ></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="Password" ></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>