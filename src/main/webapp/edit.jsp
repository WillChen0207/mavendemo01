<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/6/1
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Edit_Details</title>
    <style>
        #infoTable {
            border: 2px solid black;
        }
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h2>Edit details about this piece of post</h2>
<p>
<br>
<form action="${pageContext.request.contextPath}/edit" method="post">
    <table id="infoTable">
        <tr>
            <td>ObjectID:</td>
            <td><c:out value="${requestScope.recordToEdit.lfObject.objID}"></c:out></td>
            <%
                request.getSession().setAttribute("ObjID", request.getAttribute("ObjIDEditing"));
            %>
        </tr>
        <tr>
            <td>PosUser:</td>
            <td><c:out value="${requestScope.recordToEdit.posUserName}"></c:out></td>
            <%
                request.getSession().setAttribute("PosUser", request.getAttribute("PosUserID"));
            %>
        </tr>
        <tr>
            <td>Name of the object:</td>
            <td><input type="text" name="ObjName" value="${requestScope.recordToEdit.lfObject.objName}"></td>
        </tr>
        <tr>
            <td>Please describe details about the object:</td>
            <td><input type="text" name="Description" value="${requestScope.recordToEdit.lfObject.description}"></td>
        </tr>
        <tr>
            <td>Select Matched condition(Matched or not matched yet):</td>
            <td>
                <input type="radio" name="Matched" value="1" >Matched
                <br>
                <input type="radio" name="Matched" value="0" checked>Not Matched yet
            </td>
        </tr>
        <tr>
            <td>Please select class the object belongs to:</td>
            <td>
                <input type="radio" name="ClassID" value="1" checked>食物
                <br>
                <input type="radio" name="ClassID" value="2">证件
                <br>
                <input type="radio" name="ClassID" value="3">电子产品
                <br>
                <input type="radio" name="ClassID" value="4">未分类或难以分类
            </td>
        </tr>
        <tr>
            <td>Select LFType(Lost or Found):</td>
            <td>
                <input type="radio" name="LFType" value="1" checked>Lost
                <br>
                <input type="radio" name="LFType" value="0">Found
            </td>
        </tr>
        <tr>
            <td>Select post campus:</td>
            <td>
                <input type="radio" name="PosCampus" value="1" checked>朝晖校区
                <br>
                <input type="radio" name="PosCampus" value="2">屏峰校区
                <br>
                <input type="radio" name="PosCampus" value="3">莫干山校区
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>

<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>
