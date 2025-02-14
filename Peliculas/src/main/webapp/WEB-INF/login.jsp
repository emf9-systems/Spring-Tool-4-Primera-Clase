<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>LogIn</title>
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
						<form:form action="/logIn" method="POST" modelAttribute="userLogin">
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
						<div class="d-grid mt-3">
							<a href="/" class="btn btn-outline-warning">Registrarse</a>
						</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
