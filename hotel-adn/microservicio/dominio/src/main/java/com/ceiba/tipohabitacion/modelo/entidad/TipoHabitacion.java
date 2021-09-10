package com.ceiba.tipohabitacion.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TipoHabitacion {

    private static final String SE_DEBE_INGRESAR_CAPACIDAD_PERSONAS = "Se debe ingresar la capacidad de personas";
    private static final String SE_DEBE_INGRESAR_PRECIO_FIN_SEMANA = "Se debe ingresar el precio por día de fin de semana";
    private static final String SE_DEBE_INGRESAR_PRECIO_SEMANA = "Se debe ingresar el precio por día entre semana";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_TIPO_HABITACION = "Se debe ingresar el tipo de habitacion";
    private static final String SE_DEBE_INGRESAR_CANTIDAD_DE_CAMAS = "Se debe ingresar la cantidad de camas";
    private static final String SE_DEBE_INGRESAR_DESCRIPCION_DE_CAMAS = "Se debe ingresar la descripcion de las camas";


    private Long id;
    private String nombre;
    private String descripcion;
    private Double precioSemana;
    private Double precioFinSemana;
    private int capacidadPersonas;
    private int numeroCamas;
    private String descripcionCamas;

    public TipoHabitacion(Long id, String nombre, String descripción, Double precioFinSemana, Double precioSemana,
                          int capacidadPersonas, int numeroCamas, String descripcionCamas) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_TIPO_HABITACION);
        validarObligatorio(precioSemana, SE_DEBE_INGRESAR_PRECIO_SEMANA);
        validarObligatorio(precioFinSemana, SE_DEBE_INGRESAR_PRECIO_FIN_SEMANA);
        validarObligatorio(capacidadPersonas, SE_DEBE_INGRESAR_CAPACIDAD_PERSONAS);
        validarObligatorio(numeroCamas, SE_DEBE_INGRESAR_CANTIDAD_DE_CAMAS);
        validarObligatorio(descripcionCamas, SE_DEBE_INGRESAR_DESCRIPCION_DE_CAMAS);

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripción;
        this.precioSemana = precioSemana;
        this.precioFinSemana = precioFinSemana;
        this.capacidadPersonas = capacidadPersonas;
        this.numeroCamas = numeroCamas;
        this.descripcionCamas = descripcionCamas;
    }
}
