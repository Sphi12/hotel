package com.ceiba.parqueadero.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoParqueadero {

    private Long id;
    private Long idTipoParqueadero;
    private boolean disponible;
}
