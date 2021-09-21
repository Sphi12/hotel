package com.ceiba.tipoHabitacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tipoHabitacion.servicio.testdatabuilder.TipoHabitacionTestDataBuilder;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioActualizarTipoHabitacion;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarTipoHabitacionTest {

    @Test
    public void validarExistenciaPreviaTest() {

        TipoHabitacion tipoHabitacion = new TipoHabitacionTestDataBuilder().build();
        // arrange
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        Mockito.when(repositorioTipoHabitacion.existeTHabitacion(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarTipoHabitacion servicioActualizarTipoHabitacion = new ServicioActualizarTipoHabitacion(repositorioTipoHabitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTipoHabitacion.ejecutar(tipoHabitacion), ExcepcionSinDatos.class, "El tipo de habitacion no existe en el sistema");
    }

    @Test
    public void actualizarTipoHabPreviaTest() {

        TipoHabitacion tipoHabitacion = new TipoHabitacionTestDataBuilder().build();
        // arrange
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        Mockito.when(repositorioTipoHabitacion.existeTHabitacion(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarTipoHabitacion servicioActualizarTipoHabitacion = new ServicioActualizarTipoHabitacion(repositorioTipoHabitacion);
        servicioActualizarTipoHabitacion.ejecutar(tipoHabitacion);
    }
}
