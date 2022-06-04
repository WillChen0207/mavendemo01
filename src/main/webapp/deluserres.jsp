<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/5/29
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Delete_User_Operation_ResultPage</title>
</head>
<body>

<tr>
    <td>Successfully deleted the user.</td><br>
    <td>Please confirm.</td><br>
</tr>

<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>

