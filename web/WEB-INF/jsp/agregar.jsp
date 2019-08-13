<%-- 
    Document   : agregar
    Created on : 12/08/2019, 11:18:03 AM
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
                    <h4>Agregar nuevo registro</h4>
                </div>
                <div class="card-body">
                    <form method="POST" commandName="persona">
                        
                        <errors path ="*" element="div" cssClass="alert alert-danger"/>
                        
                        <label>Nombres(s)</label>
                        <input type="text" path="Nombre" name = "Nombre" class="form-control"/>
                        <errors path="Nombre"/>
                        
                        <label>Apellido(s)</label>
                        <input type="text" path="Apellido" name = "Apellido" class="form-control"/>
                        <errors path="Apellido"/>
                        
                        <label>Edad</label>
                        <input type="text" path="Edad" name = "Edad" class="form-control"><br>
                        <errors path="Edad"/>
                        
                        <input type="submit" value="Agregar" class="btn btn-success">
                        <a  href="index.htm">Regresar</a>
                            
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
