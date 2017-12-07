<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Administration</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <c:if test="${sessionScope.get('currentUser').userRole eq 'ADMINISTRATOR' or 'MODERATOR'}">
        <p><a class="nav-link" href="${pageContext.request.contextPath}/add-coin">Add coin</a></p>
        <p><a class="nav-link" href="${pageContext.request.contextPath}/add-news">Add news</a></p>
    </c:if>
    <c:if test="${sessionScope.get('currentUser').userRole eq 'ADMINISTRATOR'}">
        <a class="nav-link" href="${pageContext.request.contextPath}/users">Users</a>
    </c:if>
</body>
</html>
