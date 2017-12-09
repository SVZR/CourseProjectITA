<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add news</title>
</head>
<body>
<%@ include file="header.jsp"%>
    <form name="addNews" action="${pageContext.request.contextPath}/add-news" method="post">
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Headline</label>
            <input type="text" name="headline" class="form-control">
            <label for="exampleFormControlTextarea1">Text of news</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="5" name="text"></textarea>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add News</button>
    </form>
</body>
</html>
