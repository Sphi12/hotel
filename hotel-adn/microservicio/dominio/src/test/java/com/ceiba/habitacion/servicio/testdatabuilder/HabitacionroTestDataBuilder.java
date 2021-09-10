package com.ceiba.habitacion.servicio.testdatabuilder;

import com.ceiba.habitacion.modelo.entidad.Habitacion;

public class HabitacionroTestDataBuilder {

    private Long id;
    private Long tipo;
    private boolean disponible;
    private String nombre;


    public HabitacionroTestDataBuilder() {
        id = 1L;
        tipo = 1L;
        disponible = true;
        nombre = "prueba";
    }

    public HabitacionroTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Habitacion build() {
        return new Habitacion(id, tipo, disponible, nombre);
    }
}
