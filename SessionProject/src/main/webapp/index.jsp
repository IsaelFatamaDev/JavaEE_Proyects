<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Iniciar Sesión</title>
     <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
     <style>
          body {
               background-color: #f8f9fa;
          }

          .container {
               margin-top: 100px;
          }

          .form-container {
               background-color: #fff;
               padding: 20px;
               border-radius: 10px;
               box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
          }

          .form-container label {
               font-weight: bold;
          }
     </style>
</head>

<body>
<div class="container">
     <div class="row justify-content-center">
          <div class="col-md-6">
               <div class="form-container">
                    <h2 class="mb-4 text-center">Iniciar Sesión</h2>
                    <form method="post" action="StartSession">
                         <div class="form-group">
                              <label for="nombre">Nombre:</label>
                              <input type="text" class="form-control" id="nombre" name="nombre" required>
                         </div>
                         <div class="text-center">
                              <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                         </div>
                    </form>
               </div>
          </div>
     </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
