<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Numismatic portal</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/header.jsp"%>
<table class="table">
    <tbody>
    <c:forEach var="news" items="${requestScope.get('news')}">
    <tr>
        <td>${news.headline}</td>
    </tr>
    <tr>
        <td>${news.text}</td>
    </tr>
    <tr>
        <td>${news.releaseDate}</td>
    </tr>
        <c:if test="${sessionScope.containsKey('currentUser') && (sessionScope.get('currentUserRole') eq 'MODERATOR' || sessionScope.get('currentUserRole') eq 'ADMINISTRATOR')}">
            <tr>
                <td>
                    <form action="${pageContext.request.contextPath}/delete-news" method="post">
                        <button name="deleteNews" value="${news.id}">Delete news</button>
                    </form>
                </td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
</body>
</html>