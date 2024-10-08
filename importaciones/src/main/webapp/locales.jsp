<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div class="container">
    <h1>Locales</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">office_name</th>
            <th scope="col">address</th>
            <th scope="col">city</th>
            <th scope="col">phone</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="office" items="${lista}" varStatus="status">
            <tr>
                <td >${status.index + 1}</td>
                <td >${office.office_name}</td>
                <td >${office.address}</td>
                <td >${office.city}</td>
                <td >${office.phone}</td>
                <td>
                    <a href="locales?action=edit&id=${office.office_id}" class="btn btn-primary">Edit</a>
                    <a href="locales?action=delete&id=${office.office_id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
