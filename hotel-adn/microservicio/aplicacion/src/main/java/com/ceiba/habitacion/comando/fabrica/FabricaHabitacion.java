package com.ceiba.habitacion.comando.fabrica;
import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaHabitacion {

    public Habitacion crear(ComandoHabitacion comandoHabitacion) {
        return new Habitacion(
                comandoHabitacion.getId(),
                comandoHabitacion.getTipo(),
                comandoHabitacion.isDisponible()
        );
    }

}
