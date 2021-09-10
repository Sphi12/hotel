package com.ceiba.tipoHabitacion.servicio.testdatabuilder;
import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;

public class ComandoTipoHabitacionTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precioSemana;
    private Double precioFinSemana;
    private int capacidadPersonas;
    private int numeroCamas;
    private String descripcionCamas;

    public ComandoTipoHabitacionTestDataBuilder() {
        id = 2L;
        nombre = "Doble cama";
        descripcion = "Habitacion individual";
        precioSemana = 90000.0;
        precioFinSemana = 110000.0;
        capacidadPersonas = 1;
        numeroCamas = 1;
        descripcionCamas = "2 camas individuales";
    }

    public ComandoTipoHabitacion build() {
        return new ComandoTipoHabitacion(id, nombre, descripcion, precioFinSemana, precioSemana,
                capacidadPersonas, numeroCamas, descripcionCamas);
    }
}
