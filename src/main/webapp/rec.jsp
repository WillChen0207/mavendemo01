<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/5/24
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Record_Details</title>
    <style>
        #rectable {
            border: 2px solid black;
        }
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h2>Record_Table</h2>
<p>

    List:<br>
<table id="rectable">
    <thead>
            <td><b>Name of the object</b></td>
            <td><b>Description of the object</b></td>
            <td><b>LFType</b></td>
            <td><b>PosUserName</b></td>
            <td><b>PosCampusName</b></td>
            <td><b>Post time</b></td>
            <td><b>Class of the object</b></td>
            <c:if test="${not empty sessionScope.UserName and sessionScope.AuthLv == 1}">
                <td><b>Operation</b></td>
            </c:if>
    </thead>
    <c:forEach var="record" items="${sessionScope.recordList}">
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/objpage.jsp?ObjID=${record.lfObject.objID}&ObjName=${record.lfObject.objName}&ClassName=${record.lfObject.className}" target="_blank"><c:out value="${record.lfObject.objName}"></c:out></a>
        </td>
        <td><c:out value="${record.lfObject.description}"></c:out></td>
        <td>
            <c:if test="${record.LFType == 1}">Lost</c:if>
            <c:if test="${record.LFType == 0}">Found</c:if>
        </td>
        <td><c:out value="${record.posUserName}"></c:out></td>
        <td><c:out value="${record.posCampusName}"></c:out></td>
        <td><c:out value="${record.posTime}"></c:out></td>
        <td><c:out value="${record.lfObject.className}"></c:out></td>
        <c:if test="${not empty sessionScope.UserName and sessionScope.AuthLv == 1}">
            <td>
                <a href="${pageContext.request.contextPath}/delete?ObjID=${record.lfObject.objID}">Delete</a>
                <br>
                <a href="${pageContext.request.contextPath}/editshow?ObjID=${record.lfObject.objID}">Edit</a>
            </td>
        </c:if>
    </tr>
    </c:forEach>
</table>

</p>
<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>
