<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointments</title>
</head>
<body>
<h2>Appointments</h2>

<c:forEach items="${appointments}" var="app">
<c:out value="${app}"/>

</c:forEach>
</body>
</html>