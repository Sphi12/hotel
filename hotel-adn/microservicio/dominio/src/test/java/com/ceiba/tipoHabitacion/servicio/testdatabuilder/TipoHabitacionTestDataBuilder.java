package com.ceiba.tipoHabitacion.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TipoHabitacionTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripción;
    private Double precioSemana;
    private Double precioFinSemana;
    private int capacidadPersonas;
    private int numeroCamas;
    private String descripcionCamas;

    public TipoHabitacionTestDataBuilder() {
        id = 1L;
        nombre = "individual";
        descripción = "Habitacion individual";
        precioSemana = 90000.0;
        precioFinSemana = 110000.0;
        capacidadPersonas = 1;
        numeroCamas = 1;
        descripcionCamas = "cama individual";
    }


    public TipoHabitacion build() {
        return new TipoHabitacion(id, nombre, descripción, precioFinSemana, precioSemana,
                capacidadPersonas, numeroCamas, descripcionCamas);
    }
}
