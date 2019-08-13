<%-- 
    Document   : editar
    Created on : 12/08/2019, 04:28:32 PM
    Author     : DiamondDust
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Registro</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bg-info">
                    <h4>Actualizar nuevo registro</h4>
                </div>
                <div class="card-body">
                    <form method="POST">
                        <label>Nombre(s)</label>
                        <input type="text" name = "Nombre" class="form-control" value="${Lista[0].Nombre}">
                        <label>Apellido(s)</label>
                        <input type="text" name = "Apellido" class="form-control"value="${Lista[0].Apellido}">
                        <label>Edad</label>
                        <input type="text" name = "Edad" class="form-control" value="${Lista[0].Edad}"><br>
                        <input type="submit" value="Editar" class="btn btn-success">
                        <a  href="index.htm">Regresar</a>
                            
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
