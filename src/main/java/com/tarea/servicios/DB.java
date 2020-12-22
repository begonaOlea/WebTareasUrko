package com.tarea.servicios;

import com.tarea.model.Tarea;
import com.tarea.model.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DB {

    private static Map<Integer, Tarea> tareas;
    private static Set<Usuario> usuarios;
    
    static{
        tareas = new HashMap<Integer, Tarea>();
        tareas.put(1, new Tarea(1, "A", "To Do", ""));
        tareas.put(2, new Tarea(2, "B", "In Progress", ""));
        tareas.put(3, new Tarea(3, "C", "To Do", ""));
        tareas.put(4, new Tarea(4, "D", "Done", ""));
        
        usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario("","begona@gmail.com", "1234", "Begoña", "Olea"));
        usuarios.add(new Usuario("","laura@gmail.com", "1234", "Laura", "Bilbao"));
    }

    static Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public DB() {
    }
    
    public static Collection<Tarea> getAllTareas(){
        return tareas.values();
    }
}
