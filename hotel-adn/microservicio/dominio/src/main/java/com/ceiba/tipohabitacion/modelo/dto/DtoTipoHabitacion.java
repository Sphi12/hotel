package com.ceiba.tipohabitacion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTipoHabitacion {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precioSemana;
    private Double precioFinSemana;
    private int capacidadPersonas;
    private int numeroCamas;
    private String descripcionCamas;

}
