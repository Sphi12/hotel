package com.ceiba.habitacion.servicio.testdatabuilder;

import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoHabitacionTestDataBuilder {

    private Long id;
    private Long tipo;
    private boolean disponible;
    private String nombre;

    public ComandoHabitacionTestDataBuilder() {
        id = 5L;
        tipo = 1L;
        disponible = true;
        nombre = "habitacion";
    }

    public ComandoHabitacion build() {

        return new ComandoHabitacion(id, tipo, disponible, nombre);
    }
}
