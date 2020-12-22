/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.web;

import com.tarea.servicios.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //leer parametros
        String email = req.getParameter("email");
        String clave = req.getParameter("pwd");
        //validar
        String msgError = "";
        boolean valido = true;
        if (email == null || email.trim().length() == 0) {
            msgError = "Debe introducir un email.";
            valido = false;
        }
        if (clave == null || clave.trim().length() == 0) {
            msgError = msgError + " Debe introducir la contraseña";
            valido = false;
        }
        //si todo ok
        if (valido) {
            try {
                HttpSession sesion = req.getSession();
                LoginService servicio = new LoginService();
                servicio.login(email, clave, sesion);
            } catch (LoginException ex) {
                msgError = ex.getMessage();
                valido = false;
            }
        }
        //si error --> login.jsp y mostrar mensajes de error
        //si ok --> index.jsp
        RequestDispatcher rd;
        if (valido) {
            rd = req.getRequestDispatcher("index.jsp");
        } else {
            rd = req.getRequestDispatcher("login.jsp");
            req.setAttribute("mensaje", msgError);
        }   
        rd.forward(req, resp);
    }

    
}
