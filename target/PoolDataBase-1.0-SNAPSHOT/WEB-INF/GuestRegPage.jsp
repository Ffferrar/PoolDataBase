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

<h2>CHoose</h2>
<c:url value="/preRegistration" var="pre"/>
<a href="${pre}">return back</a>

<div>
    <c:url value="/guestRegistration" var="guestRegistration"/>
    <form action=""${var} method="POST" modelAttribute="guestUserForm">
    <h2>Регистрация</h2>

        <input type="text" name="name" placeholder="Name"></input>

        <input type="text" name="surname" placeholder="Surname"></input>

        <input type="date" name="birthDate" placeholder="Date of Birth"></input>

        <input type="text" name="email" placeholder="Email"></input>

        <input type="text" name="login" placeholder="Login"></input>
        <form:errors path="login"></form:errors>
            ${usernameError}

        <input type="password" name="password" placeholder="Password"></input>

        <input type="password" name="passwordConfirm"
                    placeholder="Confirm your password"></input>
        <errors path="password"></errors>
            ${passwordError}

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
