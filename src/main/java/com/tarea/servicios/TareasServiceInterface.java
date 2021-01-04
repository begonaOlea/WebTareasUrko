
package com.tarea.servicios;

import com.tarea.model.Estado;
import com.tarea.model.Tarea;
import com.tarea.model.Usuario;
import java.util.Collection;

public interface TareasServiceInterface {
    
    public Collection<Tarea> getTareasPorEstado (String estado);
    public Collection<Tarea> getTareasPorUsuario (String apodo);
    public void cambiarEstado (int id, Usuario user, String est);
}
