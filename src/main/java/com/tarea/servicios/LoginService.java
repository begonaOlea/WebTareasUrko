package com.tarea.servicios;

import com.tarea.model.Usuario;
import java.util.Collection;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

public class LoginService {

    public void login(String email, String clave, HttpSession sesion) throws LoginException {
        //DB ver si existe y coincide email y clave
        Collection<Usuario> usuarios = DB.getUsuarios();
        Usuario usrEncontrado = null;
        for(Usuario u : usuarios){
            if(u.getEmail().equals(email)){
                usrEncontrado = u;
                break;
            }
        }
        //si no existe lanzo excepcion
        if(usrEncontrado==null){
            throw new LoginException("El usuario no existe.");
        }else{
            //validar contraseña
            if(usrEncontrado.getPassword().equals(clave)){
                sesion.setAttribute("usuario", usrEncontrado);
            }else{
                throw new LoginException("Clave incorrecta");
            }
        }
        //si existe añadir a sesion
                
    }

    public void logout(HttpSession sesion) {
        sesion.invalidate();
    }
}
