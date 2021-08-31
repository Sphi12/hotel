package com.ceiba.tipoparqueadero.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTipoParqueadero {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
