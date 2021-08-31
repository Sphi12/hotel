package com.ceiba.habitacion.comando.manejador;


import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.habitacion.comando.fabrica.FabricaHabitacion;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.servicio.ServicioActualizarHabitacion;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorActualizarHabitacion implements ManejadorComando<ComandoHabitacion> {

    private final FabricaHabitacion fabricaHabitacion;
    private final ServicioActualizarHabitacion servicioActualizarHabitacion;

    public ManejadorActualizarHabitacion(FabricaHabitacion fabricaHabitacion, ServicioActualizarHabitacion servicioActualizarHabitacion) {
        this.fabricaHabitacion = fabricaHabitacion;
        this.servicioActualizarHabitacion = servicioActualizarHabitacion;
    }

    public void ejecutar(ComandoHabitacion comandoHabitacion) {
        Habitacion habitacion = this.fabricaHabitacion.crear(comandoHabitacion);
        this.servicioActualizarHabitacion.ejecutar(habitacion);
    }
}
