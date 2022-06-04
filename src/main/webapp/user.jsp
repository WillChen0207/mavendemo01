<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/5/2
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>UserInfo_Details</title>
    <style>
        #usertable {
            border: 2px solid black;
        }
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h2>UserInfo_Table</h2>
    <p>
        List:<br>

    <table id="usertable">
        <thead>
            <td><b>
                <a href="${pageContext.request.contextPath}/user?order=1">UserID</a>
            </b></td>
            <td><b>
                <a href="${pageContext.request.contextPath}/user?order=2">UserName</a>
            </b></td>
            <td><b>Signature</b></td>
            <td><b>
                <a href="${pageContext.request.contextPath}/user?order=3">CampusName</a>
            </b></td>
            <td><b>
                <a href="${pageContext.request.contextPath}/user?order=4">CampusName</a>
            </b></td>
            <td><b>Operation</b></td>
        </thead>
        <c:forEach var="user" items="${sessionScope.userinfoList}">
            <tr>
                <td><c:out value="${user.userID}"></c:out></td>
                <td><c:out value="${user.userName}"></c:out></td>
                <td><c:out value="${user.signature}"></c:out></td>
                <td><c:out value="${user.campusName}"></c:out></td>
                <td><c:out value="${user.authLv}"></c:out></td>
                <td>
                    <c:if test="${user.authLv != 1}"><a href="${pageContext.request.contextPath}/deluser?ID=${user.userID}">Delete</a></c:if>
                    <c:if test="${user.authLv == 1}">Cannot delete another administrator</c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>
