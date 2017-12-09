<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">UserId</th>
            <th scope="col">Login</th>
            <th scope="col">E-mail</th>
            <th scope="col">User role</th>
            <th scope="col">Changes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.get('users')}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td>${user.userRole}</td>
            <td>
                    <c:if test="${user.id != 1}">
                <form action="${pageContext.request.contextPath}/delete-user" method="post">
                    <button name="userId" value="${user.id}">Delete user</button>
                </form>
                    </c:if>
            </td>
            <td>
                <c:if test="${user.id != 1}">
                <form action="${pageContext.request.contextPath}/change-user-role" method="post">
                    <select name="userRole">
                        <option value="USER">USER</option>
                        <option value="MODERATOR">MODERATOR</option>
                        <option value="ADMINISTRATOR">ADMINISTRATOR</option>
                    </select>
                    <button name="userId" value="${user.id}">Change role</button>
                </form>
                </c:if>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
