<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
</head>
<body>
    <%@ include file="header.jsp"%>
    <c:if test="${requestScope.containsKey('problem')}">
        <h1>${requestScope.problem}</h1>
    </c:if>
    <form class="form-signin" action="${pageContext.request.contextPath}/registration" method="post">
        <h2 class="form-signin-heading">Registration</h2>
        <label class="sr-only">Login</label>
        <input name="login" type="text" class="form-control" placeholder="Enter Username" required autofocus>
        <label class="sr-only">E-mail</label>
        <input name="email" type="email" class="form-control" placeholder="Enter E-mail" required autofocus>
        <label class="sr-only">Password</label>
        <input name="password" type="password" class="form-control" placeholder="Enter password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    </form>
</body>
</html>
