<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/5/25
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Object_Details</title>
    <style>
        #objtable {
            border: 2px solid black;
        }
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h2>Details about the object</h2>
<p>
    List:<br>
<table id="objtable">
    <tr>
        <c:if test="${not empty sessionScope.UserName and sessionScope.AuthLv == 1}">
            <td><b>ID of the object</b></td>
        </c:if>
        <td><b>Name of the object</b></td>
        <td><b>Name of class which the object belongs to</b></td>
        <c:if test="${not empty sessionScope.UserName and sessionScope.AuthLv == 1}">
        <td>
            <b>Operation</b>
        </td>
        </c:if>
    </tr>
    <tr>
        <c:if test="${not empty sessionScope.UserName and sessionScope.AuthLv == 1}">
            <td><%=request.getParameter("ObjID")%></td>
        </c:if>
        <td><%=request.getParameter("ObjName")%></td>
        <td><%=request.getParameter("ClassName")%></td>
        <c:if test="${not empty sessionScope.UserName and sessionScope.AuthLv == 1}">
            <td>
                <a href="${pageContext.request.contextPath}/delete?ObjID=<%=request.getParameter("ObjID")%>">Delete</a>
            </td>
        </c:if>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>
