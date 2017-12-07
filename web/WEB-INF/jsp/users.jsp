<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <form action="${pageContext.request.contextPath}/usersearch" method="post">
        <input type="text" name="username" placeholder="username">
        <button type="submit">Search user</button>
    </form>
    <br>
    <p>
        ${requestScope.get('user').userName}
    </p>

    <c:if test="${requestScope.containsKey('user')}">
        <p>User information:</p>
        <p>User ID: ${requestScope.get('user').id}</p>
        <p>Username: ${requestScope.get('user').userName}</p>
        <p>E-mail: ${requestScope.get('user').userEmail}</p>
        <p>User role: ${requestScope.get('user').userRole}</p>
        <br>
        <form action="${pageContext.request.contextPath}/change-user-role">
            <select name="userRole">
                <c:forEach var="userrole" items="${requestScope.get('userRoles')}">
                    <option value="${userrole}">${userrole}</option>
                </c:forEach>
            </select>
            <button name="changeUserRole" type="submit">Change user role</button>
        </form>
        <form action="${pageContext.request.contextPath}/delete-user" method="post">
            <button name="deleteUser" type="submit">Delete user</button>
        </form>
    </c:if>
</body>
</html>
