<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/add-country" method="post">
    <div class="form-group">
        <label>Coin name</label>
        <input type="text" class="form-control" placeholder="country name" name="countryName">
    </div>
    <button type="submit" class="btn btn-primary">Add country</button>
</form>
</body>
</html>
