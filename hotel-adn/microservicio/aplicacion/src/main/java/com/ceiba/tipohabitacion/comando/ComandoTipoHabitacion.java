package com.ceiba.tipohabitacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTipoHabitacion {

    private Long id;
    private String nombre;
    private String descripción;
    private Double precioSemana;
    private Double precioFinSemana;
    private int capacidadPersonas;
    private int numeroCamas;
    private String descripcionCamas;
}
