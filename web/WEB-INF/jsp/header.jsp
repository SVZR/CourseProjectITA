<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/sale">Sale</a>
            </li>

            <c:if test="${sessionScope.containsKey('currentUser')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/my-collection">My collection</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/my-profile">My Profile</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.get('currentUser').userRole eq 'ADMINISTRATOR' or 'MODERATOR'}">
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
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
</body>
</html>
