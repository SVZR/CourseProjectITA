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
    <p>Release date:${requestScope.coin.releaseDate}</p>
    <p>Designer: ${requestScope.coin.designer}          Mintage by: ${requestScope.coin.mintageBy}</p>
    <table class="table">
        <tbody>
            <c:forEach var="coinDescription" items="${requestScope.coinDescription}">
                <tr>
                    <td width="250px">
                        <img src="${coinDescription.imageObverse}">
                    </td>
                    <td width="250px">
                        <img src="${coinDescription.imageReverse}">
                    </td>
                    <td>
                        <ul>
                            <li>Metal: ${coinDescription.metal}</li>
                            <li>Denomination: ${coinDescription.denomination} ruble</li>
                            <li>Weight, g: ${coinDescription.weight}</li>
                            <li>Diameter, mm: ${coinDescription.diameter}</li>
                            <li>Mintage, pcs.: ${coinDescription.mintage}</li>
                        </ul>
                    </td>
                    <c:if test="${sessionScope.containsKey('currentUser')}">
                        <c:if test="${requestScope.containsKey('coinsInCollection')}">
                            <c:forEach var="collection" items="${requestScope.get('coinsInCollection')}">
                                <c:if test="${coinDescription.id eq collection.coinDescriptionId}">
                                    <c:if test="${collection.amount == 0}">
                                        <td>
                                            <form action="${pageContext.request.contextPath}/update-coin-in-collection" method="post">
                                                <input type="number" name="coinAmount">
                                                <button name="coinDescriptionId" value="${coinDescription.id}" type="submit">Add to collection</button>
                                            </form>
                                        </td>
                                    </c:if>
                                    <c:if test="${collection.amount != 0}">
                                        <td>
                                            <form action="${pageContext.request.contextPath}/update-coin-in-collection" method="post">
                                                <input type="number" name="coinAmount" value="${collection.amount}">
                                                <button name="coinDescriptionId" value="${coinDescription.id}" type="submit">Update amount</button>
                                            </form>
                                        </td>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <td>${requestScope.get('coinsInCollection')}</td>
                        <c:if test="${requestScope.containsKey('coinsInCollection') == false}">
                            <td>
                                <form action="${pageContext.request.contextPath}/add-coin-to-collection" method="post">
                                    <input type="number" name="coinAmount" value="1" min="0">
                                    <button name="coinDescriptionId" value="${coinDescription.id}" type="submit">Add to collection</button>
                                </form>
                            </td>
                        </c:if>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<br>
<br>
<p>Obverse: ${requestScope.coin.descriptionObverse}</p>
<p>Reverse: ${requestScope.coin.descriptionReverse}</p>
</body>
</html>
