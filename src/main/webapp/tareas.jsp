
<%@page import="java.util.Collection"%>
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

            <%
                TareasService ts = new TareasService();
                Collection<Tarea> lista = ts.getTareasPorEstado("To Do");
            %>
            <div class="row">
                <div class="col-3">
                    <h3>Pendiente</h3>
                </div>
                <div class="col-1"></div>
                <div class="col-3">
                    <h3>En Progreso</h3>
                </div>
                <div class="col-1"></div>
                <div class="col-3">
                    <h3>Completado</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-3">

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Tarea</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Tarea t : lista) {%>
                            <tr>
                                <td><%= t.getId()%></td>
                                <td><%= t.getDescripcion()%></td>  
                            </tr>   
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <div class="col-1">
                    boton
                </div>  
                <div class="col-3">

                </div>   
                <div class="col-1">
                    boton
                </div>
                <div class="col-3">

                </div> 
            </div>
        </div>
    </body>
</html>
