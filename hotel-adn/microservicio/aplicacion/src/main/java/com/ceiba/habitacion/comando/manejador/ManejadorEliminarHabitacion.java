package com.ceiba.habitacion.comando.manejador;

import com.ceiba.habitacion.servicio.ServicioEliminarHabitacion;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarHabitacion implements ManejadorComando<Long> {

    private final ServicioEliminarHabitacion servicioEliminarHabitacion;

    public ManejadorEliminarHabitacion(ServicioEliminarHabitacion servicioEliminarHabitacion) {
        this.servicioEliminarHabitacion = servicioEliminarHabitacion;
    }

    public void ejecutar(Long idHabitacion) {
        this.servicioEliminarHabitacion.ejecutar(idHabitacion);
    }
}
