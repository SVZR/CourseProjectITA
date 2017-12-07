<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My collection</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <c:forEach var="country" items="${requestScope.get('countries')}">
        <a href="country-collection?id=${country.id}">${country.name} (${country.amountCoins})</a>
    </c:forEach>
</body>
</html>
