
package com.tarea.servicios;

import com.tarea.model.Estado;
import com.tarea.model.Tarea;
import java.util.Collection;

public interface TareasServiceInterface {
    
    public Collection<Tarea> getTareasPorEstado (String estado);
}
