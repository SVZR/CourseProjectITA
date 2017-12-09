<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <form action="${pageContext.request.contextPath}/add-series" method="post">
        <div class="form-group">
            <label for="exampleFormControlSelect1">Choose theme</label>
            <select class="form-control" id="exampleFormControlSelect1" name="themeId">
                <c:forEach var="theme" items="${requestScope.themes}">
                    <option value="${theme.id}">${theme.name}</option>
                </c:forEach>
            </select>
        </div>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add-theme" role="button">Add new theme</a>
        <br>
        <div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Series name</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="enter series name" name="seriesName">
            </div>
            <button class="btn btn-primary" type="submit">Add series</button>
        </div>
    </form>
</body>
</html>
