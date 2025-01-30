<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP practica</title>
<link rel="stylesheet" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<h1>Bienvenido a JSP!</h1>
	<h2>${titulo}</h2>
	<ul>
    <c:forEach items="${users}" var="usuario">
        <li>
        	${usuario}
        	<c:if test="${usuario == 'Pablo Picasso'}">
        		<p>(BKN BKN LAS PINTURA!)</p>
        	</c:if>
        </li>
    </c:forEach>
	</ul>
	<a class = "btn btn-outline-warning" href="/form">Registrate!</a>
</body>
</html>