package com.ceiba.reserva.comando;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComandoReservaInicial {

    private Long id;
    private String tipoHabitacion;
    private String tipoParqueadero;
    private Long idUsuario;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
}
