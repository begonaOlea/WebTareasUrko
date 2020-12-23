
<%@page import="com.tarea.model.Tarea"%>
<%@page import="com.tarea.servicios.TareasService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/vista/bootstrap.jspf" %>
        <title>Tareas</title>
    </head>
    <body>
        <div class="container">
            <%@include file="WEB-INF/vista/cabecera.jspf" %>
            <%@include file="WEB-INF/vista/menu.jspf" %>

            <div class="row">
                <div class="col">                
                    
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Tarea</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                
                            </tr>   

                        </tbody>
                    </table>
                    

                </div>
            </div>
        </div>
    </body>
</html>
