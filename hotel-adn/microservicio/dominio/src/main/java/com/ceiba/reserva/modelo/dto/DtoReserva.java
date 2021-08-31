package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoReserva {


    private Long id;
    private Long idHabitacion;
    private Long idParqueadero;
    private LocalDate fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Double precioDia;
    private Double precioTotal;
    private boolean checkIn;
    private boolean checkOut;
}
