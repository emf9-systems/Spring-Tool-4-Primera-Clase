<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Nuevo Usuario</title>
  <!-- Cargar Bootstrap 5 desde CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Enlace al archivo de CSS separado -->
  <link href="/css/style.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <div class="card">
      <div class="card-header">
        ¡Bienvenido al Portal de Usuarios!
      </div>
      <form:form action="/crear" method="POST" modelAttribute="usuario">
        <div class="mb-3">
          <form:label path="nombre" class="form-label">Nombre:</form:label>
          <form:input class="form-control" path="nombre" placeholder="Ingrese su nombre..." />
          <form:errors path="nombre" class="text-danger"/>
        </div>
        <div class="mb-3">
          <form:label path="apellido" class="form-label">Apellido:</form:label>
          <form:input class="form-control" path="apellido" placeholder="Ingrese su apellido..." />
          <form:errors path="apellido" class="text-danger"/>
        </div>
        <div class="mb-3">
          <form:label path="email" class="form-label">E-mail:</form:label>
          <form:input class="form-control" path="email" placeholder="Ingrese su correo electrónico..." />
          <form:errors path="email" class="text-danger"/>
        </div>
        <div class="d-flex justify-content-center">
          <input type="submit" class="btn btn-info mt-3" value="Guardar Usuario">
        </div>
      </form:form>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEWbR9hG3t5yI0Hj0NzP7q5H7p3tpJ9QBG6qaSY5Yo6cGHK5r49P5oBzntVBBmP0" crossorigin="anonymous"></script>
</body>
</html>
