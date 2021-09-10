package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.tipoHabitacion.servicio.testdatabuilder.TipoHabitacionTestDataBuilder;
import com.ceiba.tipoParqueadero.servicio.testdatabuilder.TipoParqueaderoTestDataBuilder;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServicioActualizarReservaTest {

    @Test
    public void validarExistenciaPreviaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().conFechaIngreso(LocalDate.of(2021, 9, 9)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, "La reserva ya existe en el sistema");
    }

    @Test
    public void validarCheckInDiaIncorrectoTest() {

        Reserva reserva = new ReservaTestDataBuilder().conId(1L).conFechaIngreso(LocalDate.of(2021, 9, 8))
                .conCheckIn(true).conCheckOut(false).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        DaoReserva daoReserva = Mockito.mock(DaoReserva.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        DtoReserva dtoReserva = new DtoReserva(1L, reserva.getIdHabitacion(), reserva.getTipoHabitacion(),
                reserva.getIdParqueadero(), reserva.getTipoParqueadero(), reserva.getIdUsuario(), reserva.getFechaReserva(),
                reserva.getFechaIngreso(), reserva.getFechaSalida(), reserva.getPrecioTotal(), !reserva.isCheckIn(), reserva.isCheckOut());
        Mockito.when(daoReserva.obtener(Mockito.anyLong())).thenReturn(dtoReserva);
        ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva,daoReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "El check-in debe realizarse el día de ingreso registrado en la reserva");
    }

    @Test
    public void validarCheckInPreTiempoTest() {

        Reserva reserva = new ReservaTestDataBuilder().conId(1L).conFechaIngreso(LocalDate.of(2021, 9, 10))
                .conCheckIn(true).conCheckOut(false).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        DaoReserva daoReserva = Mockito.mock(DaoReserva.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        DtoReserva dtoReserva = new DtoReserva(1L, reserva.getIdHabitacion(), reserva.getTipoHabitacion(),
                reserva.getIdParqueadero(), reserva.getTipoParqueadero(), reserva.getIdUsuario(), reserva.getFechaReserva(),
                reserva.getFechaIngreso(), reserva.getFechaSalida(), reserva.getPrecioTotal(), !reserva.isCheckIn(), reserva.isCheckOut());
        Mockito.when(daoReserva.obtener(Mockito.anyLong())).thenReturn(dtoReserva);
        ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva,daoReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "El check-in se debe realizar despues de las 2:00 P.M");
    }

}
