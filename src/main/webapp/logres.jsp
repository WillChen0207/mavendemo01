<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/5/16
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>LoginResultPage</title>
</head>
<body>

<tr>
    <td>Welcome back,<c:out value="${sessionScope.UserName}"></c:out>. You've logged in successfully.</td>
</tr><br>

<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>

</html>