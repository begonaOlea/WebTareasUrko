package com.tarea.servicios;

import com.tarea.model.Tarea;
import com.tarea.model.Usuario;
import java.util.Collection;
import java.util.HashSet;



public class TareasService implements TareasServiceInterface{

    @Override
    public Collection<Tarea> getTareasPorEstado(String estado) {
        Collection<Tarea> lista = new HashSet<Tarea>();
        
        for(Tarea t:DB.getAllTareas()){
            if(t.getEstado().equals(estado)){
               lista.add(t);
            }
        }
        return lista;
    }

    @Override
    public Collection<Tarea> getTareasPorUsuario(String apodo) {
        Collection<Tarea> lista = new HashSet<Tarea>();
        
        for(Tarea t:DB.getAllTareas()){
            if(t.getUsuario().equals(apodo)){
               lista.add(t);
            }
        }
        return lista;
    }

    @Override
    public void cambiarEstado(int id, Usuario user, String est) {
        Collection<Tarea> lista = getTareasPorUsuario(user.getApodo());
        
        for(Tarea t : lista){
            if(t.getId() == id){
                t.setEstado("In Progress");
            }
        }
    }
    
    

    
}