<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/add-coin-description" method="post">
    <div class="form-group">
        <label>Choose coin</label>
        <select class="form-control" name="coinId">
            <c:forEach var="coin" items="${requestScope.coins}">
                <option value="${coin.id}">${coin.coinName}</option>
            </c:forEach>
        </select>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/add-coin" role="button">Add new coin</a>
    <div class="form-group">
        <label>Choose metal</label>
        <select class="form-control" name="metalId">
            <c:forEach var="metal" items="${requestScope.metals}">
                <option value="${metal.id}">${metal.name}</option>
            </c:forEach>
        </select>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/add-metal" role="button">Add new metal</a>
    <div>
        <div class="form-group">
            <label>Denomination</label>
            <input type="text" class="form-control" placeholder="denomination" name="denomination">
        </div>
        <div class="form-group">
            <label>Weight</label>
            <input type="number" class="form-control" placeholder="weight" name="weight">
        </div>
        <div class="form-group">
            <label>Diameter</label>
            <input type="number" class="form-control" placeholder="diameter" name="diameter">
        </div>
        <div class="form-group">
            <label>Mintage</label>
            <input type="text" class="form-control" placeholder="mintage" name="mintage">
        </div>
        <div class="form-group">
            <label>Image obverse (url)</label>
            <input type="text" class="form-control" placeholder="image obverse (url)" name="imageObverse">
        </div>
        <div class="form-group">
            <label>Image reverse (url)</label>
            <input type="text" class="form-control" placeholder="image reverse (url)" name="imageReverse">
        </div>

        <button class="btn btn-primary" type="submit">Add coin description</button>
    </div>
</form>
</body>
</html>
