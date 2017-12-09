<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>header</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/css/bootstrap-grid.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/css/bootstrap-reboot.css" rel="stylesheet" media="all">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">CoinsCatalog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/index">Home <span class="sr-only">Home</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/catalog">Catalog</a>
            </li>

            <c:if test="${sessionScope.containsKey('currentUser')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/my-collection">My collection</a>
                </li>
            </c:if>
            <c:if test="${(sessionScope.get('currentUserRole') eq 'ADMINISTRATOR') or (sessionScope.get('currentUserRole') eq 'MODERATOR')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/administration">Administration</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.containsKey('currentUser')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                </li>
            </c:if>
            <c:if test="${!sessionScope.containsKey('currentUser')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
</body>
</html>
