<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>LF_Index</title>
</head>
<body>
<h1>LF_Index</h1><br>
<c:if test="${empty sessionScope.UserName}">
    <h2>Please log in or register first.</h2>
</c:if>
<c:if test="${not empty sessionScope.UserName}">
    <h2>
        Welcome back,<c:out value="${sessionScope.UserName}"></c:out>.
        <c:if test="${sessionScope.AuthLv == 1}">
            You are administrator.
        </c:if>
    </h2>
</c:if>

<a href="${pageContext.request.contextPath}/recshow">Click to view records</a><br><br>
<a href="${pageContext.request.contextPath}/reg.jsp">Click to Register</a><br><br>
<a href="${pageContext.request.contextPath}/login.jsp">
    Click to <c:if test="${not empty sessionScope.UserName}">switch account</c:if><c:if test="${empty sessionScope.UserName}">log in</c:if>
</a><br><br>
<a href="${pageContext.request.contextPath}/post.jsp">Click to post record(s)</a><br><br>

<c:if test = "${not empty sessionScope.UserName}">
    <c:if test = "${sessionScope.AuthLv == 1}">
        <a href="${pageContext.request.contextPath}/user?order=1">Click to view UserInfo</a><br><br>
        <a href="${pageContext.request.contextPath}/deluser.jsp">Click to remove user(s)</a><br><br>
    </c:if>
    <a href="${pageContext.request.contextPath}/logout" title="Logout">Log Out</a>
</c:if>

</body>
</html>