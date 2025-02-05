<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalles del Curso</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center">Detalles del Curso</h1>
        <div class="card">
            <div class="card-header">
                <h3>${salon.curso}</h3>
            </div>
            <div class="card-body">
                <h5>Lista de Inscritos:</h5>
                <table class="table table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${salon.usuarios}">
                            <tr>
                                <td>${usuario.id}</td>
                                <td>${usuario.nombre}</td>
                                <td>${usuario.apellido}</td>
                                <td>${usuario.email}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="/dashboard" class="btn btn-outline-secondary">Volver al Dashboard</a>
            </div>
        </div>
    </div>
</body>
</html>
