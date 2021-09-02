package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReservaInicial {

    private Long id;
    private String tipoHabitacion;
    private String tipoParqueadero;
    private Long idUsuario;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
}
