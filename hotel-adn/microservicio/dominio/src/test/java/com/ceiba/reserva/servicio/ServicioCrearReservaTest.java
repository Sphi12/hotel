package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.TipoHabitacionTestDataBuilder;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
public class ServicioCrearReservaTest {

    @Test
    public void validarExistenciaPreviaTest() {
        // arrange
        Reserva reserva = new TipoHabitacionTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario =  Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"La reserva ya existe en el sistema");
    }

    @Test
    public void validarTiempoMinimoReservaTest(){

        Reserva reserva = new TipoHabitacionTestDataBuilder().conFechaIngreso(LocalDate.of(2021,9,9)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario =  Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class,"La reserva se debe hacer con minimo 3 horas antes de la fecha y hora de ingreso");
    }

    @Test
    public void validarExistenciaUsuarioTest(){

        Reserva reserva = new TipoHabitacionTestDataBuilder().conUsuario(50L).conFechaIngreso(LocalDate.of(2021,9,15)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario =  Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);
        // act - assert

        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionSinDatos.class,"El usuario ingresado no existe, debe registrarse");
    }

    @Test
    public void obtenerHabitacionDisponibleTest(){

        Reserva reserva = new TipoHabitacionTestDataBuilder().conUsuario(1L).conFechaIngreso(LocalDate.of(2021,9,15)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario =  Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioUsuario.existe(Mockito.anyLong())).thenReturn(true);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);

        servicioCrearReserva.ejecutar(reserva);
        Long valorEsperado = 1L;

        assertEquals(valorEsperado, reserva.getIdHabitacion());
    }

    @Test
    public void obtenerPrecioTotalTest(){
        Reserva reserva = new TipoHabitacionTestDataBuilder().conUsuario(1L).conFechaIngreso(LocalDate.of(2021,9,15))
                .conFechaSalida(LocalDate.of(2021,9,20)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        RepositorioUsuario repositorioUsuario =  Mockito.mock(RepositorioUsuario.class);
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioParqueadero,
                repositorioHabitacion, repositorioUsuario,
                repositorioTipoHabitacion, repositorioTipoParqueadero);

        servicioCrearReserva.ejecutar(reserva);
        Double valorEsperado = 100.0;

        assertEquals(valorEsperado, reserva.getPrecioTotal());

    }
}
