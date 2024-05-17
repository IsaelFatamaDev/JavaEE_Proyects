<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
          <html>

          <head>
               <title>Carrito</title>
               <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
               <style>
                    .container {
                         margin-top: 50px;
                    }
               </style>
          </head>

          <body>
               <div class="container">
                    <h1 class="display-4">Carrito Básico</h1>
                    <p class="lead">Hola: ${nombre} <a href="EndSession">Fin de Sesión</a></p>
                    <div class="row">
                         <div class="col-md-6">
                              <form method="post" action="add" class="form-inline">
                                   <div class="form-group mr-2">
                                        <label for="ciudad" class="mr-2">Ciudad:</label>
                                        <input type="text" name="ciudad" id="ciudad" class="form-control" required>
                                   </div>
                                   <button type="submit" class="btn btn-primary">Agregar</button>
                              </form>
                         </div>
                    </div>
                    <div class="row mt-4">
                         <div class="col-md-6">
                              <h2>Ciudades:</h2>
                              <ul class="list-group">
                                   <c:forEach items="${ciudades}" var="ciudad" varStatus="loop">
                                        <li class="list-group-item">${loop.index + 1}. ${ciudad} <a
                                                  href="delete?ciudad=${ciudad}"
                                                  class="btn btn-sm btn-danger ml-2">Eliminar</a></li>
                                   </c:forEach>
                              </ul>
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
               <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
               <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
               <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
          </body>

          </html>