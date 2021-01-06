
<%@page import="com.tarea.model.Usuario"%>
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
                Usuario user = (Usuario) session.getAttribute("usuario");
                TareasService ts = new TareasService();
                Collection<Tarea> listaUser = ts.getTareasPorUsuario(user.getApodo());
            %>
            <div class="row">
                <div class="col-4">
                    <h3>Pendiente</h3>
                </div>
                <div class="col-4">
                    <h3>En Progreso</h3>
                </div>
                <div class="col-4">
                    <h3>Completado</h3>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-4">
                    <table class="table table-striped">
                        <thead>
                            <tr>                            
                                <th scope="col">ID</th>
                                <th scope="col">Tarea</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>                    
                            <%for (Tarea t : listaUser) {%>                        
                            <tr>
                                <%if (t.getEstado().equals("To Do")) {%>
                                <td><%= t.getId()%></td>
                                <td><%= t.getDescripcion()%></td>
                                <td>
                                    <a href="cambio-estado?id=<%=t.getId()%>&nuevo-estado=In Progress">--></a>
                                </td>
                                <%}%>
                            </tr>   
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <div class="col-4">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">ID</th>
                                <th scope="col">Tarea</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Tarea t : listaUser) {%>
                            <tr>
                                <%if (t.getEstado().equals("In Progress")) {%>
                                <td>
                                    <a href="cambio-estado?id=<%=t.getId()%>&nuevo-estado=To Do"><--</a>
                                </td>
                                <td><%= t.getId()%></td>
                                <td><%= t.getDescripcion()%></td>
                                <td>
                                    <a href="cambio-estado?id=<%=t.getId()%>&nuevo-estado=Done">--></a>
                                </td>
                                <%}%>
                            </tr>   
                            <%}%>
                        </tbody>
                    </table>
                </div>   
                <div class="col-4">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">ID</th>
                                <th scope="col">Tarea</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Tarea t : listaUser) {%>
                            <tr>
                                <%if (t.getEstado().equals("Done")) {%>
                                <td><a href="cambio-estado?id=<%=t.getId()%>&nuevo-estado=In Progress"><--</a></td>
                                <td><%= t.getId()%></td>
                                <td><%= t.getDescripcion()%></td>
                                <%}%>
                            </tr>   
                            <%}%>
                        </tbody>
                    </table>
                </div> 
            </div>
        </div>
    </body>
</html>
