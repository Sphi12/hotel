package com.ceiba.reserva.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@Setter
@ToString
public class Reserva {

    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION = "Se debe ingresar el id de la habitacion";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PARQUEADERO = "Se debe ingresar el id del parqueadero";

     private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO = "Se debe ingresar la fecha de ingreso";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_SALIDA = "Se debe ingresar la fecha de salida";

    private static final String TIPO_HABITACION_INDIVIDUAL = "individual";
    private static final String TIPO_HABITACION_DOBLE = "Doble";
    private static final String TIPO_HABITACION_CUADRUPLES = "Cuadruples";
    private static final String TIPO_PARQUEADERO_MOTO = "Moto";
    private static final String TIPO_PARQUEADERO_CARRO = "Carro";
    private static final String TIPO_PARQUEADERO_BICICLETA = "Bicicleta";
    private static final String TIPO_HABITACION_INVALIDO = "Tipo de habitacion invalido, debe ingresar: individual o doble o cuadruples";
    private static final String TIPO_PARQUEADERO_INVALIDO = "Tipo de parqueadero invalido, debe ingresar: moto o carro o bicicleta";
    private static final String FECHA_INGRESO_INCORRECTA = "La fecha de ingreso debe ser menor o igual a la fecha salida" ;

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

    public Reserva(Long id,Long idHabitacion,String tipoHabitacion, Long idParqueadero, String tipoParqueadero,
                   Long idUsuario, LocalDateTime fechaReserva,LocalDate fechaIngreso,
                   LocalDate fechaSalida, Double precioTotal, boolean checkIn, boolean checkOut) {

        validarObligatorio(tipoHabitacion, SE_DEBE_INGRESAR_EL_ID_DE_LA_HABITACION);
        validarObligatorio(tipoParqueadero, SE_DEBE_INGRESAR_EL_ID_DEL_PARQUEADERO);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO);
        validarObligatorio(fechaSalida, SE_DEBE_INGRESAR_LA_FECHA_DE_SALIDA);
        validarTipoHabitacion(tipoHabitacion);
        validarTipoParqueadero(tipoParqueadero);
        validarMenorDate(fechaIngreso, fechaSalida, FECHA_INGRESO_INCORRECTA);

        this.id = id;
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.idParqueadero = idParqueadero;
        this.tipoParqueadero = tipoParqueadero;
        this.idUsuario = idUsuario;
        this.fechaReserva = fechaReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.precioTotal= precioTotal;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    private void validarTipoHabitacion(String tipoHabitacionValor) {
        if (!tipoHabitacionValor.equalsIgnoreCase(TIPO_HABITACION_INDIVIDUAL) &&
                !tipoHabitacionValor.equalsIgnoreCase(TIPO_HABITACION_DOBLE) &&
                !tipoHabitacionValor.equalsIgnoreCase(TIPO_HABITACION_CUADRUPLES)) {
            throw new ExcepcionValorInvalido(TIPO_HABITACION_INVALIDO);
        }
    }

    private void validarTipoParqueadero(String tipoParqueaderoValor) {
        if (tipoParqueaderoValor != null && !tipoParqueaderoValor.equalsIgnoreCase(TIPO_PARQUEADERO_BICICLETA) &&
                !tipoParqueaderoValor.equalsIgnoreCase(TIPO_PARQUEADERO_CARRO) &&
                !tipoParqueaderoValor.equalsIgnoreCase(TIPO_PARQUEADERO_MOTO)) {
            throw new ExcepcionValorInvalido(TIPO_PARQUEADERO_INVALIDO);
        }
    }
}
