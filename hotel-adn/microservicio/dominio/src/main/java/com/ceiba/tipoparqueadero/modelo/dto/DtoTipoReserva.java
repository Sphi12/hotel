package com.ceiba.tipoparqueadero.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTipoReserva {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
