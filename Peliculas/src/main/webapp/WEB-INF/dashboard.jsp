<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-5">
    <div class="d-flex justify-content-between align-items-center">
        <h1>Bienvenido, ${currentUser.name}!</h1>    
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Películas</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/favorites">Favoritos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/movies">Pelis</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/add">Agregar</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-danger" href="/logout">Cerrar sesión</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html> 
