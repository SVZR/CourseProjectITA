<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My collection</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <h3>${requestScope.country.name}</h3>
    <p>
    <c:forEach var="theme" items="${requestScope.themes}">
            <c:if test="${!theme.themeName ne 'No theme'}">
                <h5>${theme.themeName} (${theme.amount})</h5>
            </c:if>
        <c:forEach var="series" items="${requestScope.series}">
            <c:if test="${theme.themeId == series.themeId}">
                <c:if test="${series.seriesName ne 'No theme'}">
                    <h6>${series.seriesName} (${series.amount})</h6>
                </c:if>
                <c:forEach var="coin" items="${requestScope.coins}">
                    <c:if test="${series.seriesId == coin.seriesId}">
                        <a href="${pageContext.request.contextPath}/coin-in-collection?id=${coin.coinId}">${coin.coinName} (${coin.amount})</a>
                    </c:if>
                </c:forEach>
            </c:if>
        </c:forEach>
    </c:forEach>
    </p>
</body>
</html>
