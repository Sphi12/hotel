package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.modelo.entidad.ReservaInicial;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

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

    public Long ejecutar(ReservaInicial reservaInicial) {
        validarExistenciaPrevia(reservaInicial);
        validarTiempoMinimoReserva(reservaInicial.getFechaIngreso());
        validarExistenciaUsuario(reservaInicial.getIdUsuario());

        boolean parqueadero = reservaInicial.getTipoParqueadero().isEmpty();
        Long idHabitacion = obtenerHabitacionDisponible(reservaInicial.getTipoHabitacion());
        Long idParqueadero = obtenerParqueaderoDisponible(reservaInicial.getTipoParqueadero());
        Reserva reserva = new Reserva(reservaInicial.getId(), idHabitacion, idParqueadero
                , reservaInicial.getIdUsuario(),
                LocalDateTime.now(), reservaInicial.getFechaIngreso(), reservaInicial.getFechaSalida(),
                obtenerPrecioTotal(reservaInicial, !parqueadero), false, false);

        Long idReserva = this.repositorioReserva.crear(reserva);
        actualizarDisponibilidadHabitacion(idHabitacion);

        return idReserva;
    }

    private void validarExistenciaPrevia(ReservaInicial reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void actualizarDisponibilidadHabitacion(Long id) {
        this.repositorioHabitacion.actualizarDisponibilidad(id, "0");
    }

    private void validarTiempoMinimoReserva(LocalDate fechaIngreso) {
        if ((int) ChronoUnit.HOURS.between(LocalDateTime.now(), LocalDateTime.of
                (fechaIngreso, LocalTime.of(14, 00, 00))) > 3) {
            throw new ExcepcionValorInvalido(TIEMPO_SUPERADO_PARA_RESERVA);
        }
    }

    private Long obtenerHabitacionDisponible(String tipoHabitacion) {
        Long idHabitacion = this.repositorioHabitacion.obtenerHabitacionDisponible(tipoHabitacion);

        if (idHabitacion != null) {
            return idHabitacion;
        }
        throw new ExcepcionSinDatos(HABITACION_NO_DISPONIBLE);
    }

    private Long obtenerParqueaderoDisponible(String tipoParqueadero) {
        if (tipoParqueadero != null) {
            Long idParqueadero = this.repositorioParqueadero.obtenerParqueaderoDisponible(tipoParqueadero);
            if (idParqueadero != null) {
                return idParqueadero;
            }
            throw new ExcepcionSinDatos(PARQUEADERO_NO_DISPONIBLE);
        }
        return null;
    }

    private void validarExistenciaUsuario(Long idUsuario) {
        if (!this.repositorioUsuario.existe(idUsuario)) {
            throw new ExcepcionSinDatos(NO_EXISTE_USUARIO);
        }
    }

    private Double obtenerPrecioTotal(ReservaInicial reservaInicial, boolean parqueadero) {

        int diasEstadia = (int) ChronoUnit.HOURS.between(LocalDateTime.of
                (reservaInicial.getFechaIngreso(), LocalTime.of(00, 00, 00)), LocalDateTime.of
                (reservaInicial.getFechaSalida(), LocalTime.of(00, 00, 00)));
        Double precioTotal = 0.0;
        if (!parqueadero) {
            precioTotal = obtenerPrecioTotalHabitacion(reservaInicial);
        } else {
            precioTotal = obtenerPrecioTotalHabitacion(reservaInicial) + obtenerPrecioTotalParqueadero(reservaInicial, diasEstadia);
        }

        return aplicarBeneficios(diasEstadia, precioTotal);
    }

    private Double obtenerPrecioTotalHabitacion(ReservaInicial reservaInicial) {
        Double precioTotalHabitacion = 0.0;
        DtoTipoHabitacion tipoHabitacion = obtenertipoHabitacion(reservaInicial.getTipoHabitacion());
        LocalDate fechaAuxiliar = reservaInicial.getFechaIngreso();
        while (!fechaAuxiliar.isAfter(reservaInicial.getFechaSalida())) {
            if (fechaAuxiliar.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                    fechaAuxiliar.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                precioTotalHabitacion = precioTotalHabitacion + tipoHabitacion.getPrecioFinSemana();
            } else {
                precioTotalHabitacion = precioTotalHabitacion + tipoHabitacion.getPrecioSemana();
            }
            fechaAuxiliar = fechaAuxiliar.plusDays(1);
        }

        return precioTotalHabitacion;
    }

    private Double obtenerPrecioTotalParqueadero(ReservaInicial reservaInicial, int cantidadDias) {
        return obtenertipoParqueadero(reservaInicial.getTipoParqueadero()).getPrecio() * cantidadDias;
    }

    private DtoTipoHabitacion obtenertipoHabitacion(String tipoHabitacion) {
        List<DtoTipoHabitacion> tipoHabitacionList = this.repositorioTipoHabitacion.obtenerPorId(tipoHabitacion);
        for (DtoTipoHabitacion tipoHab : tipoHabitacionList) {
            return tipoHab;
        }
        return null;
    }

    private DtoTipoParqueadero obtenertipoParqueadero(String tipoParqueadero) {
        List<DtoTipoParqueadero> tipoParqueaderoList = this.repositorioTipoParqueadero.obtenerId(tipoParqueadero);
        for (DtoTipoParqueadero tipoPar : tipoParqueaderoList) {
            return tipoPar;
        }
        return null;
    }

    private Double aplicarBeneficios(int cantidadDias, Double precioTotal) {

        if (cantidadDias >= CANTIDAD_DIAS_MIN_BENEFICIO) {
            precioTotal = precioTotal - (precioTotal * 0.10);
        }
        return precioTotal;
    }
}
