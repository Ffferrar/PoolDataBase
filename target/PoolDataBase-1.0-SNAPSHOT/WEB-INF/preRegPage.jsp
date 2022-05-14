<%--
  Created by IntelliJ IDEA.
  User: Trying Python
  Date: 14.05.2022
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose your status</title>
</head>
<body>

<c:url value="/studentRegistration" var="student"/>
<a href="${student}">Student</a>

<c:url value="/guestRegistration" var="guest"/>
<a href="${guest}">Guest</a>

</body>
</html>
