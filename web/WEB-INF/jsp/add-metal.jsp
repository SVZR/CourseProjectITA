<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/add-metal" method="post">
    <div class="form-group">
        <label>Metal</label>
        <input type="text" class="form-control" placeholder="metal" name="metalName">
    </div>
    <button type="submit" class="btn btn-primary">Add metal</button>
</form>
</body>
</html>
