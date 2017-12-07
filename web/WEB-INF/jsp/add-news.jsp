<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add news</title>
</head>
<body>
<%@ include file="header.jsp"%>
    <form name="addNews" action="${pageContext.request.contextPath}/add-news" method="post">
        <textarea name="news" cols="300" rows="10">

        </textarea>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add News</button>
    </form>
</body>
</html>
