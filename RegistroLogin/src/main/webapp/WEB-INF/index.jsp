<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro y LogIn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	.was-validated .form-control:valid, 
		.form-control.is-valid {
		    background-image: none !important;
		    padding-right: 0 !important;
		}
    </style>

</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card shadow-lg">
                    <div class="card-body p-4">
                        <h2 class="text-center mb-4">Iniciar Sesión</h2>
						<form:form action="/login" method="POST" modelAttribute="loginUsuario">
						    <div class="mb-3">
						        <form:label path="emailLogin" class="form-label">Email:</form:label>
						        <form:input path="emailLogin" class="form-control is-valid" placeholder="Ingrese su e-mail"/>
						        <form:errors path="emailLogin" class="text-danger"/>
						    </div>
						    <div class="mb-3">
						        <form:label path="passwordLogin" class="form-label">Contraseña:</form:label>
						        <form:password path="passwordLogin" class="form-control is-valid" placeholder="Ingrese su contraseña"/>
						        <form:errors path="passwordLogin" class="text-danger"/>
						    </div>
						    <div class="d-grid">
						        <button type="submit" class="btn btn-outline-success">Ingresar</button>
						    </div>
						</form:form>
                    </div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="card shadow-lg">
                    <div class="card-body p-4">
                        <h2 class="text-center mb-4">Registro</h2>
                        <form:form action="/registro" method="POST" modelAttribute="newUser">
                            <div class="mb-3">
                                <form:label path="name" class="form-label">Nombre:</form:label>
                                <form:input path="name" class="form-control" placeholder="Ingrese su nombre"/>
                                <form:errors path="name" class="text-danger"/>
                            </div>
                            <div class="mb-3">
                                <form:label path="lastName" class="form-label">Apellido:</form:label>
                                <form:input path="lastName" class="form-control" placeholder="Ingrese su apellido"/>
                                <form:errors path="lastName" class="text-danger"/>
                            </div>
                            <div class="mb-3">
                                <form:label path="email" class="form-label">Email:</form:label>
                                <form:input path="email" class="form-control" placeholder="Ingrese su e-mail"/>
                                <form:errors path="email" class="text-danger"/>
                            </div>
                            <div class="mb-3">
                                <form:label path="password" class="form-label">Contraseña:</form:label>
                                <form:password path="password" class="form-control" placeholder="Cree una contraseña"/>
                                <form:errors path="password" class="text-danger"/>
                            </div>
                            <div class="mb-3">
                                <form:label path="passwordConfirmation" class="form-label">Repetir contraseña:</form:label>
                                <form:password path="passwordConfirmation" class="form-control" placeholder="Repita su contraseña"/>
                                <form:errors path="passwordConfirmation" class="text-danger"/>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-outline-primary">Registrarse</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
