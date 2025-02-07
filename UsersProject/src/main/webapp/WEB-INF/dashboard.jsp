<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Dashboard</a>
        </div>
    </nav>

    <div class="container mt-4">
        <h1 class="text-center">Lista de Usuarios</h1>
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Curso</th>
                        <th>Hobbies</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
				<tbody>
				    <c:choose>
				        <c:when test="${not empty usuarios}">
				            <c:forEach var="usuario" items="${usuarios}">
				                <tr>
				                    <td>${usuario.id}</td>
				                    <td>${usuario.nombre}</td>
				                    <td>${usuario.apellido}</td>
				                    <td>${usuario.email}</td>
				                    <td>${usuario.salon.curso}</td>
				                    
				                    <!-- Nueva columna Hobbies -->
				                    <td>
				                        <c:choose>
				                            <c:when test="${not empty usuario.hobbies}">
				                                <ul class="list-unstyled mb-0">
				                                    <c:forEach var="hobby" items="${usuario.hobbies}">
				                                        <li>• ${hobby.pasaTiempo}</li>
				                                    </c:forEach>
				                                </ul>
				                            </c:when>
				                            <c:otherwise>
				                                <span class="text-muted">Sin hobbies</span>
				                            </c:otherwise>
				                        </c:choose>
				                    </td>
				
				                    <!-- Acciones alineadas correctamente -->
				                    <td class="align-middle">
				                        <div class="d-flex flex-wrap gap-2 align-items-center">
				                            <form action="/borrar/${usuario.id}" method="POST">
				                                <input type="hidden" name="_method" value="DELETE"/>
				                                <input type="submit" value="Borrar" class="btn btn-sm btn-outline-danger"/>
				                            </form>
				                            <a href="/editar/${usuario.id}" class="btn btn-sm btn-outline-warning">Editar</a>
				                            <a href="/asignar/${usuario.id}" class="btn btn-sm btn-outline-primary">Asignar Hobbies</a>
				                            <a href="/mostrar/${usuario.id}" class="btn btn-sm btn-outline-info" target="_blank">Mostrar Info</a>
				                        </div>
				                    </td>
				                </tr>
				            </c:forEach>
				        </c:when>
				        <c:otherwise>
				            <tr>
				                <td colspan="7" class="text-center">No hay usuarios registrados</td>
				            </tr>
				        </c:otherwise>
				    </c:choose>
				</tbody>
            </table>
            <a href="/nuevo" class="btn btn-outline-success">Crear Usuario</a>
        </div>
    </div>

    <div class="container mt-4">
        <h1 class="text-center">Lista de Cursos</h1>
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Curso</th>
                        <th>N° de Inscritos</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty salones}">
                            <c:forEach var="salon" items="${salones}">
                                <tr>
                                    <td>${salon.id}</td>
                                    <td>${salon.curso}</td>
                                    <td>${salon.numeroDeInscritos}</td>
                                    <td class="d-flex justify-content-start gap-3">
                                        <form action="/borrarCursos/${salon.id}" method="POST">
                                            <input type="hidden" name="_method" value="DELETE"/>
                                            <input type="submit" value="Borrar" class="btn btn-sm btn-outline-danger"/>
                                        </form>
                                        <a href="/mostrarCurso/${salon.id}" class="btn btn-sm btn-outline-info">Mostrar Info</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="4" class="text-center">No hay cursos registrados</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
            <a href="/nuevoCurso" class="btn btn-outline-success">Crear curso</a>
        </div>
    </div>
</body>
</html>
