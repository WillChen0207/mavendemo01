<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/5/29
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Delete_User_Operation_Page</title>
</head>
<body>
<h1>DeleteUser</h1>
<!-- 创建表单,包含ID -->
<form action="${pageContext.request.contextPath}/deluser" method="post">
    <table>
        <tr>
            <td>ID of the user you want to remove:</td>
            <td><input type="text" name="ID" ></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>