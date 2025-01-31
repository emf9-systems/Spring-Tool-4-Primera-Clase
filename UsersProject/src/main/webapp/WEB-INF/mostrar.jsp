<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${usuario.nombre} ${usuario.apellido}</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        /* Fondo suave y limpio */
        body {
            background-color: #f4f7f6;
            font-family: 'Arial', sans-serif;
        }

        /* Contenedor con sombra y bordes redondeados */
        .container {
            margin-top: 50px;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* Títulos */
        h1, h2 {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-weight: 600;
            color: #333;
        }

        h1 {
            font-size: 2.5rem;
            color: #5b5e5a;
        }

        h2 {
            font-size: 1.5rem;
            color: #7a7c76;
        }

        /* Ajustes para el contenedor de los textos */
        .info-container {
            margin-top: 20px;
        }

        /* Fondo suave en la cabecera */
        header {
            background-color: #2d3748;
            color: white;
            padding: 15px 0;
            text-align: center;
            border-radius: 10px 10px 0 0;
        }
        
        header h1 {
            font-size: 2.5rem;
            color: white;
        }
    </style>
</head>
<body>
    <header>
        <h1>Bienvenido</h1>
    </header>

    <div class="container">
        <h1>${usuario.nombre} ${usuario.apellido}</h1>
        <div class="info-container">
            <h2>${usuario.email}</h2>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
