<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asignar Hobbies</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Dashboard</a>
        </div>
    </nav>
    <div class="container mt-4">
        <h1 class="text-center">Asignar Hobbies a ${usuario.nombre} ${usuario.apellido}</h1>       
		<div class="d-flex justify-content-center">
		    <div class="col-md-6">
		        <div class="card shadow-sm">
		            <div class="card-header bg-dark text-white text-center">
		                <h4>Hobbies Disponibles</h4>
		            </div>
		            <div class="card-body">
		                <table class="table table-striped table-bordered table-hover">
		                    <thead class="table-dark">
		                        <tr>
		                            <th>Hobby</th>
		                            <th>Acción</th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                        <c:forEach items="${hobbies}" var="hobby">
		                            <tr>
		                                <td>${hobby.pasaTiempo}</td>
		                                <td>
		                                    <c:if test="${not usuario.hobbies.contains(hobby)}">
		                                        <a href="/asignarHobby/${usuario.id}/${hobby.id}" class="btn btn-sm btn-outline-success">Asignar</a>
		                                    </c:if>
		                                    <c:if test="${usuario.hobbies.contains(hobby)}">
		                                        <a href="/quitarHobby/${usuario.id}/${hobby.id}" class="btn btn-sm btn-outline-danger">Quitar</a>
		                                    </c:if>
		                                </td>
		                            </tr>
		                        </c:forEach>
		                    </tbody>
		                </table>
		            </div>
		        </div>
		    </div>
		</div>
        <div class="text-center mt-4">
            <a href="/dashboard" class="btn btn-outline-secondary">Volver</a>
        </div>
    </div>
</body>
</html>
