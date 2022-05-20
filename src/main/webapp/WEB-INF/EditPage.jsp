<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Edit</title>
</head>
<body>
<c:url value="/add" var="var"/>
<form action="${var}" method="POST" enctype="multipart/form-data">
  <input type="hidden" name="id" value="${document.id}">

  <label for="name">Name</label>
  <input type="text" name="name" id="name">

  <label for="userId">User ID</label>
  <input type="text" name="userId" id="userId">

  <label for="image">User ID</label>
  <input type="file" name="file" id="image">

  <input type="submit" value="Upload">

  <input type="submit" value="Edit document">
</form>
</body>
</html>