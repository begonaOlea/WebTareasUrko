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
        String estado = req.getParameter("nuevo-estado");
        HttpSession session = req.getSession();
        Usuario user = (Usuario) session.getAttribute("usuario");
        String msgErrorParam = null;
        String msgErrorCambio = null;
        boolean correcto = true;

        if (sId == null || sId.trim().length() == 0) {
            msgErrorParam = "El ID de la tarea es incorrecto";
            correcto = false;
        }

        if (correcto) {
            try {
                int id = Integer.parseInt(sId);
                ts.cambiarEstado(id, user, estado);
            } catch (Exception ex) {
                msgErrorCambio = ex.getMessage();
                correcto = false;
            }
        }
        
        String jsp = "";
        if(correcto){
            jsp  = "tareas.jsp";
        }else{
            jsp = "tareas.jsp";
            req.setAttribute("msgErrorParam", msgErrorParam);
            req.setAttribute("msgErrorCambio", msgErrorCambio);
        }

        RequestDispatcher rd = req.getRequestDispatcher(jsp);
        rd.forward(req, resp);
    }

}
