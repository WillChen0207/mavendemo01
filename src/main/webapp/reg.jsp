<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>RegisterPage</title>
</head>
<body>
<h1>LF_Register</h1>
<!-- 创建表单,包含UserName,Name,ID,Password,CampusCode,AuthLv，Signature -->
<form action="${pageContext.request.contextPath}/reg" method="post">
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type="text" name="UserName" ></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="Name" ></td>
        </tr>
        <tr>
            <td>ID:</td>
            <td><input type="text" name="ID" ></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="Password" ></td>
        </tr>
        <tr>
            <td>CampusCode:</td>
            <td><input type="number" name="CampusCode" ></td>
        </tr>
        <tr>
            <td>AuthLv:</td>
            <td><input type="number" name="AuthLv" ></td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><input type="text" name="Signature" ></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>