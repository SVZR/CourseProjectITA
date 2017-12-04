<%--
  Created by IntelliJ IDEA.
  User: kirylhrybouski
  Date: 25.11.17
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Регистрация</h1>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <p>Login</p>
        <input name="login" type="text">
        <p>Password</p>
        <input name="password" type="password">
        <p>Confirm password</p>
        <input name="confirmPassword" type="password">
        <p>E-mail</p>
        <input name="email" type="text">
        <button type="submit">Register</button>
    </form>
</body>
</html>
