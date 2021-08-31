package com.ceiba.tipohabitacion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;
import com.ceiba.tipohabitacion.comando.fabrica.FabricaTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioCrearTipoHabitacion;

import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearTipoHabitacion implements ManejadorComandoRespuesta<ComandoTipoHabitacion, ComandoRespuesta<Long>> {

    private final FabricaTipoHabitacion fabricaTipoHabitacion;
    private final ServicioCrearTipoHabitacion servicioCrearTipoHabitacion ;

    public ManejadorCrearTipoHabitacion(FabricaTipoHabitacion fabricaTipoHabitacion, ServicioCrearTipoHabitacion servicioCrearTipoHabitacion) {
        this.fabricaTipoHabitacion = fabricaTipoHabitacion;
        this.servicioCrearTipoHabitacion = servicioCrearTipoHabitacion;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoTipoHabitacion comandoTipoHabitacion) {
        TipoHabitacion tipoHabitacion = this.fabricaTipoHabitacion.crear(comandoTipoHabitacion);
        return new ComandoRespuesta<>(this.servicioCrearTipoHabitacion.ejecutar(tipoHabitacion));
    }
}
