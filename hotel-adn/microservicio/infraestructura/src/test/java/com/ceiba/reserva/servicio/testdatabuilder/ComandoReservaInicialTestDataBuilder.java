package com.ceiba.resrva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReservaInicial;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoReservaInicialTestDataBuilder {

    private Long id;
    private String tipoHabitacion;
    private String tipoParqueadero;
    private Long idUsuario;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;

    public ComandoReservaInicialTestDataBuilder() {
        id=2L;
        tipoHabitacion = "individual";
        tipoParqueadero = "carro";
        idUsuario = 1L;
        fechaIngreso = LocalDate.of(2021,9,20);
        fechaSalida = LocalDate.of(2021,9,25);
    }

    public ComandoReservaInicial build() {
        return new ComandoReservaInicial(id,tipoHabitacion, tipoParqueadero,idUsuario,fechaIngreso, fechaSalida );
    }
}
