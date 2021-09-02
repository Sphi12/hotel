package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private Long idHabitacion;
    private Long idParqueadero;
    private long idUsuario;
    private LocalDateTime fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Double precioTotal;
    private boolean checkIn;
    private boolean checkOut;

    public ComandoReservaTestDataBuilder() {
        id=1L;
        idHabitacion = 1L;
        idParqueadero = 1L;
        idUsuario = 1L;
        fechaIngreso = LocalDate.of(2021,9,9);
        fechaSalida = LocalDate.of(2021,9,14);
        fechaReserva = LocalDateTime.now();
        precioTotal = 489000.0;
        checkIn = true;
        checkOut = false;
    }

    public ComandoReserva build() {

        return new ComandoReserva(id,idHabitacion, idParqueadero, idUsuario, fechaReserva,fechaIngreso,
                fechaSalida, precioTotal ,checkIn, checkOut);
    }
}
