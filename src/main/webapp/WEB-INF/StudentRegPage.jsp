<%--
  Created by IntelliJ IDEA.
  User: Trying Python
  Date: 14.05.2022
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация (для студентов) </title>
</head>
<body>

<c:url value="/preRegistration" var="pre"/>
<a href="${pre}">return back</a>

<form:form method="POST" modelAttribute="studentUserForm">
    <h2>Регистрация</h2>
    <div>
        <form:input type="text" path="name" placeholder="Name"></form:input>
    </div>
    <div>
        <form:input type="text" path="surname" placeholder="Surname"></form:input>
    </div>
    <div>
        <form:input type="text" path="login" placeholder="Login"></form:input>
        <form:errors path="login"></form:errors>
            ${usernameError}
    </div>
    <div>
        <form:input type="date" path="birthDate" placeholder="Date of Birth"></form:input>
    </div>
    <div>
        <form:input type="text" path="email" placeholder="Email"></form:input>
    </div>
    <div>
        <form:input type="text" path="department" placeholder="Department"></form:input>
    </div>
    <div>
        <form:input type="text" path="course" placeholder="Course"></form:input>
    </div>
    <div>
        <form:input type="password" path="passwordConfirm"
                    placeholder="Confirm your password"></form:input>
        <form:errors path="password"></form:errors>
            ${passwordError}
    </div>
    <button type="submit">Зарегистрироваться</button>
</form:form>

</body>
</html>
