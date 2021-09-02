package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION = "Se debe ingresar el id de la habitacion";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PARQUEADERO = "Se debe ingresar el id del parqueadero";

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA = "Se debe ingresar la fecha de reserva";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO = "Se debe ingresar la fecha de ingreso";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_SALIDA = "Se debe ingresar la fecha de salida";

    private static final String EL_PRECIO_DIA_DEBE_SER_UN_NUMERO = "el precio dia debe ser un numero";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private Long id;
    private Long idHabitacion;
    private Long idParqueadero;
    private Long idUsuario;
    private LocalDateTime fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Double precioTotal;
    private boolean checkIn;
    private boolean checkOut;

    public Reserva(Long id,Long idHabitacion,Long idParqueadero, Long idUsuario, LocalDateTime fechaReserva,LocalDate fechaIngreso,
                   LocalDate fechaSalida, Double precioTotal, boolean checkIn, boolean checkOut) {
        validarObligatorio(idHabitacion, SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION);
        validarObligatorio(idParqueadero, SE_DEBE_INGRESAR_EL_ID_DEL_PARQUEADERO);
        validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO);
        validarObligatorio(fechaSalida, SE_DEBE_INGRESAR_LA_FECHA_DE_SALIDA);


        this.id = id;
        this.idHabitacion = idHabitacion;
        this.idParqueadero = idParqueadero;
        this.fechaReserva = fechaReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.precioTotal= precioTotal;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

}
