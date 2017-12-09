<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coin</title>
</head>
<body>
<%@ include file="header.jsp"%>
    <p>${requestScope.coin.country}</p>
    <p>${requestScope.coin.theme}</p>
        <c:if test="${requestScope.coin.series ne 'No theme'}">
            <p>${requestScope.coin.series}</p>
        </c:if>
    <p>${requestScope.coin.coinName}</p>
    <p>Release date: ${requestScope.coin.releaseDate}</p>
    <p>Designer: ${requestScope.coin.designer}          Mintage by: ${requestScope.coin.mintageBy}</p>
    <table class="table">
        <tbody>
            <%@ include file="coin-description-table-catalog.jsp"%>
        </tbody>
    </table>
<br>
<br>
<p>Obverse: ${requestScope.coin.descriptionObverse}</p>
<p>Reverse: ${requestScope.coin.descriptionReverse}</p>
</body>
</html>
