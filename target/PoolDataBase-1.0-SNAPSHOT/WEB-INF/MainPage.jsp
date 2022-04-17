<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DOCS</title>
</head>
<body>

<h2>Documents</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>startDate</th>
        <th>endDate</th>
        <th>userId</th>
    </tr>
    <c:forEach var="document" items="${documentList}">
        <tr>
            <td>${document.id}</td>
            <td>${document.name}</td>
            <td>${document.startDate}</td>
            <td>${document.endDate}</td>
            <td>${document.userId}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>