<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contact List</title>

</head>
<body>

<table>
    <thead>
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

</body>
</html>
