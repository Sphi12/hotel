package com.ceiba.tipoParqueadero.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.tipoHabitacion.servicio.testdatabuilder.TipoHabitacionTestDataBuilder;
import com.ceiba.tipoParqueadero.servicio.testdatabuilder.TipoParqueaderoTestDataBuilder;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioCrearTipoHabitacion;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioCrearTipoParqueadero;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
public class ServicioCrearTipoParqueaderoTest {

    @Test
    public void validarExistenciaPreviaTest() {
        TipoParqueadero tipoParqueadero = new TipoParqueaderoTestDataBuilder().build();
        // arrange
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);
        Mockito.when(repositorioTipoParqueadero.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearTipoParqueadero servicioCrearTipoParqueadero = new ServicioCrearTipoParqueadero(repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearTipoParqueadero.ejecutar(tipoParqueadero), ExcepcionDuplicidad.class, "El tipo tipo parqueadero ya existe en el sistema");
    }

}
