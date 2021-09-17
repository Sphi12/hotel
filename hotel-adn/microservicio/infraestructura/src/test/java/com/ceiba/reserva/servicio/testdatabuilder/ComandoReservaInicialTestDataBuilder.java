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
        fechaIngreso = LocalDate.now().plusDays(1l);
        fechaSalida = LocalDate.now().plusDays(5l);
    }

    public ComandoReservaInicial build() {
        return new ComandoReservaInicial(id,tipoHabitacion, tipoParqueadero,idUsuario,fechaIngreso, fechaSalida );
    }
}
