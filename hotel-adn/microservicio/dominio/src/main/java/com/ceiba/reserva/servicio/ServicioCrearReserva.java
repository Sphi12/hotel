package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
    private static final String TIEMPO_SUPERADO_PARA_RESERVA = "La reserva se debe hacer con minimo 3 horas antes de la fecha y hora de ingreso";
    private static final String NO_EXISTE_USUARIO = "El usuario ingresado no existe, debe registrarse";
    private static final String HABITACION_NO_DISPONIBLE = "No hay habitaciones disponibles";
    private static final String PARQUEADERO_NO_DISPONIBLE = "No hay parqueaderos disponibles";

    private static final int CANTIDAD_DIAS_MIN_BENEFICIO = 3;
    private final RepositorioReserva repositorioReserva;
    private final RepositorioParqueadero repositorioParqueadero;
    private final RepositorioHabitacion repositorioHabitacion;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioTipoHabitacion repositorioTipoHabitacion;
    private final RepositorioTipoParqueadero repositorioTipoParqueadero;
    private static final double PORCENTAJE_DESCUENTO = 0.10;
    private static final int HORAS_PERMITIDAS_ANTES_RESERVA = 3;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioParqueadero repositorioParqueadero,
                                RepositorioHabitacion repositorioHabitacion, RepositorioUsuario repositorioUsuario,
                                RepositorioTipoHabitacion repositorioTipoHabitacion, RepositorioTipoParqueadero repositorioTipoParqueadero) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioHabitacion = repositorioHabitacion;
        this.repositorioParqueadero = repositorioParqueadero;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioTipoHabitacion = repositorioTipoHabitacion;
        this.repositorioTipoParqueadero = repositorioTipoParqueadero;
    }

    public Long ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        validarTiempoMinimoReserva(reserva.getFechaIngreso());
        validarExistenciaUsuario(reserva.getIdUsuario());

        boolean parqueadero = reserva.getTipoParqueadero().isEmpty();
        Long idHabitacion = obtenerHabitacionDisponible(reserva.getTipoHabitacion());
        Long idParqueadero = obtenerParqueaderoDisponible(reserva.getTipoParqueadero());

        reserva.setIdHabitacion(idHabitacion);
        reserva.setIdParqueadero(idParqueadero);
        reserva.setFechaReserva(LocalDateTime.now());
        reserva.setPrecioTotal(obtenerPrecioTotal(reserva, !parqueadero));

        Long idReserva = this.repositorioReserva.crearReserva(reserva);
        //anotacion
        actualizarDisponibilidadHabitacion(idHabitacion);

        return idReserva;
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existeReserva(reserva.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void actualizarDisponibilidadHabitacion(Long id) {
        this.repositorioHabitacion.actualizarDisponibilidadHabitacion(id, "0");
    }

    private void validarTiempoMinimoReserva(LocalDate fechaIngreso) {
        if ((int) ChronoUnit.HOURS.between(LocalDateTime.now(), LocalDateTime.of
                (fechaIngreso, LocalTime.of(13, 59, 59))) <= HORAS_PERMITIDAS_ANTES_RESERVA) {
            throw new ExcepcionValorInvalido(TIEMPO_SUPERADO_PARA_RESERVA);
        }
    }

    private Long obtenerHabitacionDisponible(String tipoHabitacion) {
        Long idHabitacion = this.repositorioHabitacion.obtenerHabitacionDisponibleHabitacion(tipoHabitacion);

        if (idHabitacion != null) {
            return idHabitacion;
        }
        throw new ExcepcionSinDatos(HABITACION_NO_DISPONIBLE);
    }

    private Long obtenerParqueaderoDisponible(String tipoParqueadero) {
        if (tipoParqueadero != null) {
            Long idParqueadero = this.repositorioParqueadero.obtenerParqueaderoDisponibleParqueadero(tipoParqueadero);
            if (idParqueadero != null) {
                return idParqueadero;
            }
            throw new ExcepcionSinDatos(PARQUEADERO_NO_DISPONIBLE);
        }
        return null;
    }

    private void validarExistenciaUsuario(Long idUsuario) {
        if (!this.repositorioUsuario.existeUsuario(idUsuario)) {
            throw new ExcepcionSinDatos(NO_EXISTE_USUARIO);
        }
    }


    private Double obtenerPrecioTotal(Reserva reserva, boolean parqueadero) {

        int diasEstadia = (int) (DAYS.between(reserva.getFechaIngreso(), reserva.getFechaSalida()));

        Double precioTotal;
        if (!parqueadero) {
            precioTotal = obtenerPrecioTotalHabitacion(reserva);
        } else {
            precioTotal = obtenerPrecioTotalHabitacion(reserva) + obtenerPrecioTotalParqueadero(reserva, diasEstadia);
        }

        return aplicarBeneficios(diasEstadia, precioTotal);
    }

    private Double obtenerPrecioTotalHabitacion(Reserva reserva) {
        Double precioTotalHabitacion = 1.0;
        DtoTipoHabitacion tipoHabitacion = obtenertipoHabitacion(reserva.getTipoHabitacion());
        LocalDate fechaAuxiliar = reserva.getFechaIngreso();
        if (tipoHabitacion != null && tipoHabitacion.getPrecioFinSemana() != null
                && tipoHabitacion.getPrecioSemana() != null) {
            while (fechaAuxiliar.isBefore(reserva.getFechaSalida())) {
                if (fechaAuxiliar.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                        fechaAuxiliar.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                    precioTotalHabitacion = precioTotalHabitacion + tipoHabitacion.getPrecioFinSemana();
                } else {
                    precioTotalHabitacion = precioTotalHabitacion + tipoHabitacion.getPrecioSemana();
                }
                fechaAuxiliar = fechaAuxiliar.plusDays(1);
            }
        }
        return precioTotalHabitacion - 1;
    }

    private Double obtenerPrecioTotalParqueadero(Reserva reserva, int cantidadDias) {
        DtoTipoParqueadero parqueadero = obtenertipoParqueadero(reserva.getTipoParqueadero());
        if (parqueadero != null) {
            return parqueadero.getPrecio() * cantidadDias;
        }
        return 0.0;
    }

    private DtoTipoHabitacion obtenertipoHabitacion(String tipoHabitacion) {
        List<DtoTipoHabitacion> tipoHabitacionList = this.repositorioTipoHabitacion.obtenerPorIdTHabitacion(tipoHabitacion);
        if (!tipoHabitacionList.isEmpty()) {
            return tipoHabitacionList.get(0);
        }
        return null;
    }

    private DtoTipoParqueadero obtenertipoParqueadero(String tipoParqueadero) {
        List<DtoTipoParqueadero> tipoParqueaderoList = this.repositorioTipoParqueadero.obtenerIdTParqueadero(tipoParqueadero);
        if (!tipoParqueaderoList.isEmpty()) {
            return tipoParqueaderoList.get(0);
        }
        return null;
    }

    private Double aplicarBeneficios(int cantidadDias, Double precioTotal) {
        if (cantidadDias >= CANTIDAD_DIAS_MIN_BENEFICIO) {
            precioTotal = precioTotal - (precioTotal * PORCENTAJE_DESCUENTO);
        }
        return precioTotal;
    }
}
