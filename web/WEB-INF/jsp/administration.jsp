<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Administration</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <c:if test="${(sessionScope.get('currentUser').userRole eq 'ADMINISTRATOR') or (sessionScope.get('currentUser').userRole eq 'MODERATOR')}">
        <div>
        <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/add-country">Add country</a>
        <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/add-theme">Add theme</a>
        <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/add-news">Add news</a>
        <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/add-coin">Add coin</a>
        <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/add-coin-description">Add coin description</a>
        </div>
    </c:if>
    <c:if test="${sessionScope.get('currentUser').userRole eq 'ADMINISTRATOR'}">
        <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/all-users">Users</a>
    </c:if>
</body>
</html>
