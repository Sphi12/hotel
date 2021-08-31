package com.ceiba.tipohabitacion.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.tipohabitacion.servicio.ServicioEliminarTipoHabitacion;

import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarTipoHabitacion implements ManejadorComando<Long> {

    private final ServicioEliminarTipoHabitacion servicioEliminarTipoHabitacion;

    public ManejadorEliminarTipoHabitacion(ServicioEliminarTipoHabitacion servicioEliminarTipoHabitacion) {
        this.servicioEliminarTipoHabitacion = servicioEliminarTipoHabitacion;
    }

    public void ejecutar(Long idTipoHabitacion) {
        this.servicioEliminarTipoHabitacion.ejecutar(idTipoHabitacion);
    }
}
