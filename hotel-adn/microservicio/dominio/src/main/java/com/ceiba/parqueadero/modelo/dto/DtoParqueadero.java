package com.ceiba.parqueadero.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoParqueadero {

    private Long id;
    private Long idTipoParqueadero;
    private boolean disponible;
}
