<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:if test="${requestScope.get('coinsInCollection').containsKey(coinDescription.id)}">
                <td>
                    <c:if test="${requestScope.get('coinsInCollection').get(coinDescription.id) != 0}">
                    <p>BUTTON UPDATE AMOUNT = ${requestScope.get('coinsInCollection').get(coinDescription.id)}</p>
                    </c:if>
                    <c:if test="${requestScope.get('coinsInCollection').get(coinDescription.id) == 0}">
                        <p>BUTTON ADD AMOUNT = ${requestScope.get('coinsInCollection').get(coinDescription.id)}</p>
                    </c:if>
                </td>
            </c:if>
            <c:if test="${!requestScope.get('coinsInCollection').containsKey(coinDescription.id)}">
                <td>
                    <p>BUTTON ADD ENTER AMOUNT</p>
                </td>
            </c:if>
        </c:if>
    </tr>
</c:forEach>

