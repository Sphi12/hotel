package com.ceiba.tipoParqueadero.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TipoParqueaderoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    public TipoParqueaderoTestDataBuilder() {
        id = 1L;
        nombre = "moto";
        descripcion = "Parqueadero moto";
        precio = 3000.0;

    }


    public TipoParqueadero build() {
        return new TipoParqueadero(id, nombre, descripcion, precio);
    }
}
