<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/add-theme" method="post">
    <div class="form-group">
        <label for="exampleFormControlSelect1">Choose country</label>
        <select class="form-control" id="exampleFormControlSelect1" name="countryId">
            <c:forEach var="country" items="${requestScope.countries}">
                <option value="${country.id}">${country.name}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/add-country" role="button">Add new country</a>
    <div>
        <div class="form-group">
            <label for="exampleFormControlInput1">Theme name</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="enter theme name" name="themeName">
        </div>
        <button class="btn btn-primary" type="submit">Add theme</button>
    </div>
</form>
</body>
</html>
