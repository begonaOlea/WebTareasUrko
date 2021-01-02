package com.tarea.web;

import com.tarea.model.Usuario;
import com.tarea.servicios.TareasService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CambioEstadoServlet extends HttpServlet {

    TareasService ts = new TareasService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sId = req.getParameter("id");
        HttpSession session = req.getSession();
        Usuario user = (Usuario) session.getAttribute("usuario");

        int id = Integer.parseInt(sId,user);

        ts.cambiarEstado(id);

        RequestDispatcher rd = req.getRequestDispatcher("tareas.jsp");
        rd.forward(req, resp);
    }

}
