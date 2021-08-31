package com.ceiba.habitacion.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarTrue;

@Getter
public class Habitacion {

    private static final String SE_DEBE_INGRESAR_DISPIBILIDAD_TRUE = "Se debe ingresar la disponibilidad de la habitacion en true";
    private static final String SE_DEBE_INGRESAR_LA_DISPONIBILIDAD = "Se debe ingresar la disponibilidad de la habitacion";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_HABITACION = "Se debe ingresar el tipo de habitacion";

    private Long id;
    private Long tipo;
    private boolean disponible;
    private String nombre;

    public Habitacion(Long id, Long tipo, boolean disponible, String nombre) {
        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO_HABITACION);
        validarObligatorio(disponible, SE_DEBE_INGRESAR_LA_DISPONIBILIDAD);
        validarTrue(disponible, SE_DEBE_INGRESAR_DISPIBILIDAD_TRUE);

        this.id = id;
        this.tipo = tipo;
        this.disponible = disponible;
        this.nombre = nombre;
    }

}
