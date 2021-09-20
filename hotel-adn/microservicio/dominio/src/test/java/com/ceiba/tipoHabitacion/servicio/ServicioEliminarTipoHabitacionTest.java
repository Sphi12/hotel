package com.ceiba.tipoHabitacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tipoHabitacion.servicio.testdatabuilder.TipoHabitacionTestDataBuilder;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioActualizarTipoHabitacion;
import com.ceiba.tipohabitacion.servicio.ServicioEliminarTipoHabitacion;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarTipoHabitacionTest {

    @Test
    public void validarNoExistenciaPreviaTest() {

        TipoHabitacion tipoHabitacion = new TipoHabitacionTestDataBuilder().build();
        // arrange
        RepositorioTipoHabitacion repositorioTipoHabitacion = Mockito.mock(RepositorioTipoHabitacion.class);
        Mockito.when(repositorioTipoHabitacion.existeTHabitacion(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarTipoHabitacion servicioEliminarTipoHabitacion = new ServicioEliminarTipoHabitacion(repositorioTipoHabitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarTipoHabitacion.ejecutar(tipoHabitacion.getId()),
                ExcepcionSinDatos.class, "El tipo de habitacion no existe en el sistema");
    }
}
