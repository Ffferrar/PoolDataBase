<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Welcome to the MIPT Pool website!
</h1>
    <h3>
        Here will be presented news about competitions and timetables.
    </h3>
    <h3>
        Also you can storage here your medical documents for pool administration.
    </h3>

    <c:url value="/login" var="login"/>
    <a href="${login}">Login</a>

    <c:url value="/preRegistration" var="preReg"/>
    <a href="${preReg}">Registration</a>

</body>
</html>
