package com.ceiba.tipoParqueadero.servicio.testdatabuilder;
import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;
import com.ceiba.tipoparqueadero.comando.ComandoTipoParqueadero;

public class ComandoTipoParqueaderoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    public ComandoTipoParqueaderoTestDataBuilder() {
        id = 2L;
        nombre = "moto";
        descripcion = "Parqueadero moto";
        precio = 3000.0;
    }

    public ComandoTipoParqueadero build() {
        return new ComandoTipoParqueadero(id, nombre, descripcion, precio);
    }
}
