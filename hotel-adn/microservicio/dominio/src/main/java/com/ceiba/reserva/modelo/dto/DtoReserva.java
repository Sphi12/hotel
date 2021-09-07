package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoReserva {


    private Long id;
    private Long idHabitacion;
    private String tipoHabitacion;
    private Long idParqueadero;
    private String tipoParqueadero;
    private Long idUsuario;
    private LocalDateTime fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Double precioTotal;
    private boolean checkIn;
    private boolean checkOut;
}
