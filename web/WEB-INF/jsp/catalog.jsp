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
</body>
</html>
