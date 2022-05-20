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
    <title>Регистрация (для студентов)</title>
</head>
<body>

<h2>CHoose</h2>
<c:url value="/preRegistration" var="preRegistration"/>
<a href="${preRegistration}">return back</a>

<div>
    <c:url value="/studentRegistration" var="studentRegistration"/>
    <form action="${var}" method="POST" modelAttribute="studentUserForm">
        <h2>Регистрация</h2>
            <input type="text" name="name" placeholder="Name">

            <input type="text" name="surname" placeholder="Surname">

            <input type="date" name="birthDate" placeholder="Date of Birth">

            <input type="text" name="email" placeholder="Email">

            <input type="text" name="department" placeholder="Department">

            <input type="text" name="course" placeholder="Course">

            <input type="text" name="login" placeholder="Login">
            <form:errors path="login"></form:errors>
                ${usernameError}

            <input type="password" name="password" placeholder="Password">

            <input type="password" name="passwordConfirm"
                        placeholder="Confirm your password">
            <errors path="password"></errors>
                ${passwordError}

        <input type="submit" value="Submit">

    </form>
</div>
</body>
</html>
