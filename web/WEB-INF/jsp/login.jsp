<%--
  Created by IntelliJ IDEA.
  User: kirylhrybouski
  Date: 29.11.17
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="translation" var="currentBundle"/>
<form action="${pageContext.request.contextPath}/lang" method="post">
    <select name="lang" id="lang">
        <option value="rus">РУС</option>
        <option value="eng">ENG</option>
    </select>
    <button type="submit" name="langSubmit">Change</button>
</form>
<%@ include file="header.jsp"%>
<br>
<br>

<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only"><fmt:message key="login.email"
                                                             bundle="${currentBundle}"/></label>
        <input name="useremail" type="email" id="inputEmail" class="form-control" placeholder="<fmt:message key="login.email"
                                                             bundle="${currentBundle}"/>" required autofocus>
        <label for="inputPassword" class="sr-only"><fmt:message key="login.password"
                                                                bundle="${currentBundle}"/></label>
        <input name="userpassword" type="password" id="inputPassword" class="form-control" placeholder="<fmt:message key="login.password"
                                                                                                 bundle="${currentBundle}"/>" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="login.button"
                                                                                    bundle="${currentBundle}"/></button>
    </form>

</div>

    <p>
        <a href="${pageContext.request.contextPath}/registration">Registration</a>
    </p>
</body>
</html>
