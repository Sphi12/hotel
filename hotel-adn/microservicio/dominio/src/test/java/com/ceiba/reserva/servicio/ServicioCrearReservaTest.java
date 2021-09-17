package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.reserva.modelo.entidad.Reserva;
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
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServicioCrearReservaTest {

    @Test
    public void validarExistenciaPreviaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaIngreso(LocalDate.now().plusDays(1l)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existeReserva(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, "La reserva ya existe en el sistema");
    }

    @Test
    public void validarTiempoMinimoReservaTest() {

        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaIngreso(LocalDate.now().minusDays(1l)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existeReserva(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "La reserva se debe hacer con minimo 3 horas antes de la fecha y hora de ingreso");
    }

    @Test
    public void validarExistenciaUsuarioTest() {

        Reserva reserva = new ReservaTestDataBuilder().conUsuario(50L)
                .conFechaIngreso(LocalDate.now().plusDays(1l)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existeReserva(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);
        // act - assert

        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionSinDatos.class, "El usuario ingresado no existe, debe registrarse");
    }

    @Test
    public void obtenerHabitacionDisponibleTest() {

        Reserva reserva = new ReservaTestDataBuilder().conUsuario(1L)
                .conFechaIngreso(LocalDate.now().plusDays(1l))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existeReserva(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioUsuario.existeUsuario(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHabitacion.obtenerHabitacionDisponibleHabitacion(Mockito.anyString())).thenReturn(1L);
        Mockito.when(repositorioParqueadero.obtenerParqueaderoDisponibleParqueadero(Mockito.anyString())).thenReturn(1L);

        TipoHabitacion tipoHabitacion = new TipoHabitacionTestDataBuilder().build();
        List<DtoTipoHabitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new DtoTipoHabitacion(tipoHabitacion.getId(), tipoHabitacion.getNombre(),
                tipoHabitacion.getDescripcion(), tipoHabitacion.getPrecioSemana(), tipoHabitacion.getPrecioFinSemana(),
                tipoHabitacion.getCapacidadPersonas(), tipoHabitacion.getNumeroCamas(), tipoHabitacion.getDescripcionCamas()));

        TipoParqueadero tipoParqueadero = new TipoParqueaderoTestDataBuilder().build();
        List<DtoTipoParqueadero> parqueaderoList = new ArrayList<>();
        parqueaderoList.add(new DtoTipoParqueadero(tipoParqueadero.getId(), tipoParqueadero.getNombre(),
                tipoParqueadero.getDescripción(), tipoParqueadero.getPrecio()));

        Mockito.when(repositorioTipoHabitacion.obtenerPorIdTHabitacion(Mockito.anyString())).thenReturn(habitaciones);
        Mockito.when(repositorioTipoParqueadero.obtenerIdTParqueadero(Mockito.anyString())).thenReturn(parqueaderoList);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);

        servicioCrearReserva.ejecutar(reserva);
        Long valorEsperado = 1L;

        assertEquals(valorEsperado, reserva.getIdHabitacion());
    }

    @Test
    public void obtenerPrecioTotalTest() {
        Reserva reserva = new ReservaTestDataBuilder().conUsuario(1L)
                .conFechaIngreso(LocalDate.now().plusDays(1l))
                .conFechaSalida(LocalDate.now().plusDays(4l)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existeReserva(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioUsuario.existeUsuario(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHabitacion.obtenerHabitacionDisponibleHabitacion(Mockito.anyString())).thenReturn(1L);
        Mockito.when(repositorioParqueadero.obtenerParqueaderoDisponibleParqueadero(Mockito.anyString())).thenReturn(1L);

        TipoHabitacion tipoHabitacion = new TipoHabitacionTestDataBuilder().build();
        List<DtoTipoHabitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new DtoTipoHabitacion(tipoHabitacion.getId(), tipoHabitacion.getNombre(),
                tipoHabitacion.getDescripcion(), tipoHabitacion.getPrecioSemana(), tipoHabitacion.getPrecioFinSemana(),
                tipoHabitacion.getCapacidadPersonas(), tipoHabitacion.getNumeroCamas(), tipoHabitacion.getDescripcionCamas()));

        TipoParqueadero tipoParqueadero = new TipoParqueaderoTestDataBuilder().build();
        List<DtoTipoParqueadero> parqueaderoList = new ArrayList<>();
        parqueaderoList.add(new DtoTipoParqueadero(tipoParqueadero.getId(), tipoParqueadero.getNombre(),
                tipoParqueadero.getDescripción(), tipoParqueadero.getPrecio()));

        Mockito.when(repositorioTipoHabitacion.obtenerPorIdTHabitacion(Mockito.anyString())).thenReturn(habitaciones);
        Mockito.when(repositorioTipoParqueadero.obtenerIdTParqueadero(Mockito.anyString())).thenReturn(parqueaderoList);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);

        servicioCrearReserva.ejecutar(reserva);
        Double valorEsperado = 287100.0;

        assertEquals(valorEsperado, reserva.getPrecioTotal());

    }

    @Test
    public void obtenerParqueaderoDisponibleTest() {

        Reserva reserva = new ReservaTestDataBuilder().conUsuario(1L)
                .conFechaIngreso(LocalDate.now().plusDays(1l)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existeReserva(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioUsuario.existeUsuario(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioHabitacion.obtenerHabitacionDisponibleHabitacion(Mockito.anyString())).thenReturn(1L);
        Mockito.when(repositorioParqueadero.obtenerParqueaderoDisponibleParqueadero(Mockito.anyString())).thenReturn(1L);

        TipoHabitacion tipoHabitacion = new TipoHabitacionTestDataBuilder().build();
        List<DtoTipoHabitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new DtoTipoHabitacion(tipoHabitacion.getId(), tipoHabitacion.getNombre(),
                tipoHabitacion.getDescripcion(), tipoHabitacion.getPrecioSemana(), tipoHabitacion.getPrecioFinSemana(),
                tipoHabitacion.getCapacidadPersonas(), tipoHabitacion.getNumeroCamas(), tipoHabitacion.getDescripcionCamas()));

        TipoParqueadero tipoParqueadero = new TipoParqueaderoTestDataBuilder().build();
        List<DtoTipoParqueadero> parqueaderoList = new ArrayList<>();
        parqueaderoList.add(new DtoTipoParqueadero(tipoParqueadero.getId(), tipoParqueadero.getNombre(),
                tipoParqueadero.getDescripción(), tipoParqueadero.getPrecio()));

        Mockito.when(repositorioTipoHabitacion.obtenerPorIdTHabitacion(Mockito.anyString())).thenReturn(habitaciones);
        Mockito.when(repositorioTipoParqueadero.obtenerIdTParqueadero(Mockito.anyString())).thenReturn(parqueaderoList);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);

        servicioCrearReserva.ejecutar(reserva);
        Long valorEsperado = 1L;

        assertEquals(valorEsperado, reserva.getIdParqueadero());
    }

}
