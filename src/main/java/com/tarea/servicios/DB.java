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
        tareas.put(1, new Tarea(1, "Tarea A", "To Do", "kuko24"));
        tareas.put(2, new Tarea(2, "Tarea B", "In Progress", "kuko24"));
        tareas.put(3, new Tarea(3, "Tarea C", "To Do", "labil"));
        tareas.put(4, new Tarea(4, "Tarea D", "Done", "kuko24"));
        
        usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario("kuko24","urko@gmail.com", "1234", "Urko", "Uri"));
        usuarios.add(new Usuario("labil","laura@gmail.com", "1234", "Laura", "Bilbao"));
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
