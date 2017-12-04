<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add coin</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/add-coin" method="post">
        <p>Country</p>
        <select name="country">
            <c:forEach var="country" items="${requestScope.countries}">
                <option value="${country.id}">${country.name}</option>
            </c:forEach>
        </select>
        <p>Theme</p>
        <select name="theme">
            <c:forEach var="theme" items="${requestScope.themes}">
                <option value="${theme.id}">${theme.name}</option>
            </c:forEach>
        </select>
        <p>Series</p>
        <select name="series">
            <c:forEach var="series" items="${requestScope.series}">
                <option value="${series.id}">${series.name}</option>
            </c:forEach>
        </select>
        <p>Coin name</p>
        <input type="text" name="coinName">
        <p>Metal</p>
        <select name="metal">
            <c:forEach var="metal" items="${requestScope.metals}">
                <option value="${metal.id}">${metal.name}</option>
            </c:forEach>
        </select>
        <p>Denomination</p>
        <input type="number" name="denomination">
        <p>Weight</p>
        <input type="number" name="weight">
        <p>Diameter</p>
        <input type="number" name="diameter">
        <p>Mintage</p>
        <input type="number" name="mintage">
        <p>Date</p>
        <div name="date">
            <input type="number" placeholder="Day" name="inputDay" style="display:inline">
            <input type="number" placeholder="Month" name="inputMonth" style="display:inline">
            <input type="number" placeholder="Year" name="inputYear" style="display:inline">
        </div>
        <p>Minted by</p>
        <input type="text" name="mintedBy">
        <p>Obverse</p>
        <input type="text" name="descriptionObverse">
        <p>Reverse</p>
        <input type="text" name="descriptionReverse">
    </form>
</body>
</html>
