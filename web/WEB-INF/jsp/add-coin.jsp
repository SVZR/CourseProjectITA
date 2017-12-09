<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add coin</title>
</head>
<body>
<%@ include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/add-coin" method="post">
    <div class="form-group">
        <label for="exampleFormControlSelect1">Choose series</label>
        <select class="form-control" id="exampleFormControlSelect1" name="seriesId">
            <c:forEach var="series" items="${requestScope.series}">
                <option value="${series.id}">${series.name}</option>
            </c:forEach>
        </select>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/add-series" role="button">Add new series</a>
    <div>
        <div class="form-group">
            <label>Coin name</label>
            <input type="text" class="form-control" placeholder="coin name" name="coinName">
        </div>
        <div class="form-group">
            <label>Release date</label>
            <input type="datetime-local" class="form-control" placeholder="release date format (YYYY-MM-DD)" name="releaseDate">
        </div>
        <div class="form-group">
            <label>Design</label>
            <input type="text" class="form-control" placeholder="designer" name="designer">
        </div>
        <div class="form-group">
            <label>Minted By</label>
            <input type="text" class="form-control" placeholder="minted by" name="mintedBy">
        </div>
        <div class="form-group">
            <label>Description obverse</label>
            <textarea class="form-control" rows="5" name="descriptionObverse"></textarea>
        </div>
        <div class="form-group">
            <label>Description reverse</label>
            <textarea class="form-control" rows="5" name="descriptionReverse"></textarea>
        </div>

        <button class="btn btn-primary" type="submit">Add coin</button>
    </div>
</form>
</body>
</html>
