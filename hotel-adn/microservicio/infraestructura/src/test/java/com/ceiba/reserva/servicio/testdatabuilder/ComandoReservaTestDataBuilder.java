package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private Long idHabitacion;
    private String tipoHabitacion;
    private Long idParqueadero;
    private String tipoParqueadero;
    private long idUsuario;
    private LocalDateTime fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Double precioTotal;
    private boolean checkIn;
    private boolean checkOut;

    public ComandoReservaTestDataBuilder() {
        id = 1L;
        idHabitacion = 1L;
        tipoHabitacion = "individual";
        idParqueadero = 1L;
        tipoParqueadero = "carro";
        idUsuario = 1L;
        fechaIngreso = LocalDate.of(2021, 9, 21);
        fechaSalida = LocalDate.of(2021, 9, 26);
        fechaReserva = LocalDateTime.now();
        precioTotal = 489000.0;
        checkIn = false;
        checkOut = false;
    }

    public ComandoReserva build() {

        return new ComandoReserva(id, idHabitacion, tipoHabitacion, idParqueadero, tipoParqueadero,
                idUsuario, fechaReserva, fechaIngreso,
                fechaSalida, precioTotal, checkIn, checkOut);
    }
}
