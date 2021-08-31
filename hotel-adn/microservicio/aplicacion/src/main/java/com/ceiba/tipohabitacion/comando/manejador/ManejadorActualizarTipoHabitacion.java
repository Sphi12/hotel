package com.ceiba.tipohabitacion.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;
import com.ceiba.tipohabitacion.comando.fabrica.FabricaTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioActualizarTipoHabitacion;

import org.springframework.stereotype.Component;


@Component
public class ManejadorActualizarTipoHabitacion implements ManejadorComando<ComandoTipoHabitacion> {

    private final FabricaTipoHabitacion fabricaTipoHabitacion;
    private final ServicioActualizarTipoHabitacion servicioActualizarTipoHabitacion;

    public ManejadorActualizarTipoHabitacion(FabricaTipoHabitacion fabricaTipoHabitacion, ServicioActualizarTipoHabitacion servicioActualizarTipoHabitacion) {
        this.fabricaTipoHabitacion = fabricaTipoHabitacion;
        this.servicioActualizarTipoHabitacion = servicioActualizarTipoHabitacion;
    }

    public void ejecutar(ComandoTipoHabitacion comandoTipoHabitacion) {
        TipoHabitacion tipoHabitacion = this.fabricaTipoHabitacion.crear(comandoTipoHabitacion);
        this.servicioActualizarTipoHabitacion.ejecutar(tipoHabitacion);
    }
}
