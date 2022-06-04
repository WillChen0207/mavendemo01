<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/5/17
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>PostSubmitPage</title>
</head>
<body>
<h1>LF_PostSubmit</h1>
<!-- Create a form including all details needed to be submit -->
<form action="${pageContext.request.contextPath}/recsub" method="post">
    <table>
        <tr>
            <td>ObjectID:</td>
            <td><input type="text" name="ObjID" ></td>
        </tr>
        <tr>
            <td>Post User:</td>
            <td><c:out value="${sessionScope.UserName}"></c:out></td>
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
            <td>Name of the object:</td>
            <td><input type="text" name="ObjName" ></td>
        </tr>
        <tr>
            <td>Please describe details about the object:</td>
            <td><input type="text" name="Description" ></td>
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
<%--        <tr>--%>
<%--            <td>Upload photo for better description</td>--%>
<%--            <td>--%>
<%--                <input type="file" name="uploadFile">--%>
<%--                <br>--%>
<%--                <input type="submit" value="upload">--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>