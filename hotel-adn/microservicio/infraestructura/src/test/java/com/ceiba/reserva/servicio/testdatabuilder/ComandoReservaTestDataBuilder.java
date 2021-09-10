package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import org.apache.tomcat.jni.Local;
import org.apache.tomcat.jni.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
        id = 2L;
        idHabitacion = 1L;
        tipoHabitacion = "individual";
        idParqueadero = 1L;
        tipoParqueadero = "carro";
        idUsuario = 1L;
        fechaIngreso = LocalDate.of(2021, 9, 3);
        fechaSalida = LocalDate.of(2021, 9, 6);
        fechaReserva = LocalDateTime.now();
        precioTotal = 451800.0;
        checkIn = false;
        checkOut = false;
    }

    public ComandoReserva build() {

        return new ComandoReserva(id, idHabitacion, tipoHabitacion, idParqueadero, tipoParqueadero,
                idUsuario, fechaReserva, fechaIngreso,
                fechaSalida, precioTotal, checkIn, checkOut);
    }
}
