<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     if (session == null || session.getAttribute("nombre") == null) {
          response.sendRedirect(request.getContextPath() + "/index.jsp");
          return;
     }
%>

<html>
<head>
     <title>Carrito</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
           integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
           crossorigin="anonymous">
     <style>
          .container {
               margin-top: 50px;
          }

          .lead {
               margin-bottom: 30px;
          }

          .list-group-item {
               display: flex;
               justify-content: space-between;
               align-items: center;
          }
     </style>
</head>

<body>
<div class="container">
     <h1 class="display-4">Carrito Básico</h1>
     <p class="lead">Hola, ${nombre} <a href="EndSession" class="btn btn-outline-danger btn-sm">Fin de
          Sesión</a></p>
     <div class="row">
          <div class="col-md-6 d-flex">
               <form method="post" action="add" class="form-inline">
                    <div class="form-group mb-3 d-flex ">
                         <label for="ciudad" class="mr-2">Ciudad:</label>
                         <input type="text" name="ciudad" id="ciudad"
                                class="form-control mr-2 me-lg-3 ms-3" required>
                         <button type="submit" class="btn btn-primary ">Agregar</button>
                    </div>
               </form>
          </div>
     </div>
     <div class="row mt-4">
          <div class="col-md-4">
               <h2>Ciudades:</h2>
               <ol class="list-group list-group-numbered d-flex flex-column">
                    <c:forEach items="${ciudades}" var="ciudad" varStatus="loop">
                         <li class="list-group-item d-flex gap-xl-2 flex-row">${ciudad}
                              <a href="delete?index=${loop.index + 1}" class="btn btn-sm btn-danger ml-2">Eliminar</a>
                         </li>
                    </c:forEach>
               </ol>
          </div>
     </div>
     <div class="row mt-4">
          <div class="col-md-6">
               <form method="post" action="clean">
                    <button type="submit" class="btn btn-danger">Limpiar Carrito</button>
               </form>
          </div>
     </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

</html>
