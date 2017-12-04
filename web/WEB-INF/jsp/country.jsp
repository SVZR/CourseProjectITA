<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <h1>${requestScope.country.name}</h1>
    <p>
        <c:forEach var="theme" items="${requestScope.themes}">
        <h3>${theme.name}</h3>
            <c:forEach var="series" items="${requestScope.series}">
                <c:if test="${theme.id==series.themeId}">
                    <h5>${series.name}</h5>
                    <c:forEach var="coin" items="${requestScope.coins}">
                        <c:if test="${series.id==coin.seriesId}">
                            <a href="${pageContext.request.contextPath}/coin?id=${coin.id}">${coin.name}</a>
                        </c:if>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </c:forEach>
    </p>
</body>
</html>
