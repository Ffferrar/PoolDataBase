<%--
  Created by IntelliJ IDEA.
  User: Trying Python
  Date: 14.05.2022
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Регистрация</title>
</head>

<body>
<div>
<c:url value="/preRegistration" var="pre"/>
<a href="${pre}">return back</a>

<form:form method="POST" modelAttribute="guestUserForm">
    <h2>Регистрация</h2>
    <div>
        <input type="text" path="name" placeholder="Name"></input>
    </div>
    <div>
        <input type="text" path="surname" placeholder="Surname"></input>
    </div>
    <div>
        <input type="date" path="birthDate" placeholder="Date of Birth"></input>
    </div>
    <div>
        <input type="text" path="email" placeholder="Email"></input>
    </div>
    <div>
        <input type="text" path="login" placeholder="Login"></input>
        <errors path="login"></errors>
            ${usernameError}
    </div>
    <div>
        <input type="password" path="password" placeholder="Password"></input>
    </div>
    <div>
        <input type="password" path="passwordConfirm"
                    placeholder="Confirm your password"></input>
        <errors path="password"></errors>
            ${passwordError}
    </div>
    <button type="submit">Зарегистрироваться</button>
</form:form>
</div>
</body>
</html>
