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
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="input-group">
                                    <form class="row" action="${pageContext.request.contextPath}/update-coin-in-collection" method="post">
                                        <input type="number" class="form-control" placeholder="${requestScope.get('coinsInCollection').get(coinDescription.id)}" name="coinAmount">
                                        <span class="input-group-btn">
                                            <button class="btn btn-secondary" type="submit" value="${coinDescription.id}" name="coinDescriptionId">Update amount</button>
                                        </span>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.get('coinsInCollection').get(coinDescription.id) == 0}">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="input-group">
                                    <form class="row" action="${pageContext.request.contextPath}/update-coin-in-collection" method="post">
                                        <input type="number" class="form-control" placeholder="0" name="coinAmount">
                                        <span class="input-group-btn">
                                            <button class="btn btn-secondary" type="submit" value="${coinDescription.id}" name="coinDescriptionId">Update amount</button>
                                        </span>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </td>
            </c:if>
            <c:if test="${!requestScope.get('coinsInCollection').containsKey(coinDescription.id)}">
                <td>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <form class="row" action="${pageContext.request.contextPath}/add-coin-to-collection" method="post">
                                    <input type="number" class="form-control" placeholder="0" name="coinAmount">
                                    <span class="input-group-btn">
                                            <button class="btn btn-secondary" type="submit" value="${coinDescription.id}" name="coinDescriptionId">Add coin</button>
                                        </span>
                                </form>
                            </div>
                        </div>
                    </div>
                </td>
            </c:if>
        </c:if>
    </tr>
</c:forEach>

