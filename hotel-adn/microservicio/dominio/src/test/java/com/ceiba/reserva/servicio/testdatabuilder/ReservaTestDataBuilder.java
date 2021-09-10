package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservaTestDataBuilder {

    private Long id;
    private Long idHabitacion;
    private String tipoHabitacion;
    private Long idParqueadero;
    private String tipoParqueadero;
    private Long idUsuario;
    private LocalDateTime fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Double precioTotal;
    private boolean checkIn;
    private boolean checkOut;

    public ReservaTestDataBuilder() {
        tipoHabitacion = "individual";
        tipoParqueadero = "moto";
        fechaReserva = LocalDateTime.now();
        fechaSalida = LocalDate.of(2021,9,20);

    }

    public com.ceiba.reserva.servicio.testdatabuilder.TipoHabitacionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public com.ceiba.reserva.servicio.testdatabuilder.TipoHabitacionTestDataBuilder conUsuario(Long id) {
        this.idUsuario = id;
        return this;
    }

    public com.ceiba.reserva.servicio.testdatabuilder.TipoHabitacionTestDataBuilder conFechaIngreso(LocalDate fecha) {
        this.fechaIngreso = fecha;
        return this;
    }

    public com.ceiba.reserva.servicio.testdatabuilder.TipoHabitacionTestDataBuilder conFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public Reserva build() {
        return new Reserva(null,idHabitacion, tipoHabitacion, idParqueadero, tipoParqueadero,
                idUsuario, fechaReserva, fechaIngreso,
                fechaSalida, precioTotal, checkIn, checkOut) ;
    }
}
