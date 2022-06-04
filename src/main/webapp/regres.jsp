<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2022/5/1
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>RegisterResultPage</title>
</head>
<body>
<%
    String userName = (String) request.getAttribute("UserName");
    String id = (String) request.getAttribute("ID");
    request.getSession().setAttribute("UserName", userName);
    request.getSession().setAttribute("ID", id);
%>
<tr>
    <td>Hello,<%=userName %>. You've successfully registered.</td>
</tr><br>
<tr>
    <td>Your ID:<%=id %>. Please confirm.</td>
</tr><br>

<a href="${pageContext.request.contextPath}/index.jsp">Click to confirm and return to homepage.</a>
</body>
</html>
