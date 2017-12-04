<%--
  Created by IntelliJ IDEA.
  User: kirylhrybouski
  Date: 30.11.17
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sale</title>
</head>
<body>
<%@ include file="header.jsp"%>

    <p>страница объявлений</p>
<c:forEach var="user" items="${requestScope.users}">
    <p>${user.name}</p>
</c:forEach>
</body>
</html>
