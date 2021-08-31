package com.ceiba.habitacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHabitacion {

    private Long id;
    private Long tipo;
    private boolean disponible;
    private String nombre;
}
