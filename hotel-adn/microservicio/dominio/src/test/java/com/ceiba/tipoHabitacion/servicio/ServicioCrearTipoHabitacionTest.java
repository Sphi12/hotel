package com.ceiba.tipoHabitacion.servicio;

import com.ceiba.tipoHabitacion.servicio.testdatabuilder.TipoHabitacionTestDataBuilder;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipohabitacion.servicio.ServicioCrearTipoHabitacion;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearTipoHabitacionTest {

    @Test
    public void validarExistenciaPreviaTest() {
        TipoHabitacion tipoHabitacion = new TipoHabitacionTestDataBuilder().build();
        // arrange
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        Mockito.when(repositorioTipoHabitacion.existeTipoHabitacion(Mockito.anyLong())).thenReturn(true);
        ServicioCrearTipoHabitacion servicioCraarTipoHabitacion = new ServicioCrearTipoHabitacion(repositorioTipoHabitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCraarTipoHabitacion.ejecutar(tipoHabitacion), ExcepcionDuplicidad.class, "El tipo de habitacion ya existe en el sistema");
    }
}
