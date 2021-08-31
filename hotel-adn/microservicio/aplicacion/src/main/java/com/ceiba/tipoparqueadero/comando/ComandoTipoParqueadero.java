package com.ceiba.tipoparqueadero.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTipoParqueadero {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
