package com.ceiba.tipohabitacion.comando.fabrica;

import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import org.springframework.stereotype.Component;


@Component
public class FabricaTipoHabitacion {

    public TipoHabitacion crear(ComandoTipoHabitacion comandoTipoHabitacion) {
        return new TipoHabitacion(
                comandoTipoHabitacion.getId(),
                comandoTipoHabitacion.getNombre(),
                comandoTipoHabitacion.getDescripcion(),
                comandoTipoHabitacion.getPrecioFinSemana(),
                comandoTipoHabitacion.getPrecioSemana(),
                comandoTipoHabitacion.getCapacidadPersonas(),
                comandoTipoHabitacion.getNumeroCamas(),
                comandoTipoHabitacion.getDescripcionCamas()
        );
    }

}
