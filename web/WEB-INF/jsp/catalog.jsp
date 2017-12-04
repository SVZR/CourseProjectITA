<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
</head>
<%@include file="header.jsp"%>
<body>
<c:forEach var="country" items="${requestScope.countries}">
    <p><a href="${pageContext.request.contextPath}/country?id=${country.id}">${country.name}</a></p>
</c:forEach>
<p>тут будет каталог</p>
<img src="${pageContext.request.contextPath}/resources/Bel.jpg" alt="Республика Беларусь" height="200" width="400">
</body>
</html>
