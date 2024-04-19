<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contact List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Lista de Contactos</h1>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>NOMBRE</th>
            <th>CORREO</th>
            <th>TELEFONO</th>
            <th>ESTADO</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lista}" var="usuario">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nombre}</td>
                <td>${usuario.correo}</td>
                <td>${usuario.telefono}</td>
                <td>${usuario.estado}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
