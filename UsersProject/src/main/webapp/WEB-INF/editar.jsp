<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Usuario</title>
  <!-- Cargar Bootstrap 5 desde CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Enlace al archivo de CSS separado -->
  <link href="/css/style.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <div class="card">
      <div class="card-header">
        ¡Bienvenido al Portal de Edicion de Usuarios!
      </div>
      <form:form action="/actualizar/${usuario.id}" method="POST" modelAttribute="usuario">
      	<input type="hidden" name="_method" value="PUT"/>

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
        <div class="mb-3">
          <form:label path="salon" class="form-label">Cursos:</form:label>
          <form:select class="form-select" path="salon">
          	<c:forEach items="${salones}" var="salon">
          		<option value="${salon.id}">${salon.curso}</option>
          	</c:forEach>
          </form:select>
          <form:errors path="salon" class="text-danger"/>
        </div>
        <div class="d-flex justify-content-center">
          <input type="submit" class="btn btn-info mt-3" value="Guardar Cambios">
        </div>
      </form:form>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEWbR9hG3t5yI0Hj0NzP7q5H7p3tpJ9QBG6qaSY5Yo6cGHK5r49P5oBzntVBBmP0" crossorigin="anonymous"></script>
</body>
</html>
