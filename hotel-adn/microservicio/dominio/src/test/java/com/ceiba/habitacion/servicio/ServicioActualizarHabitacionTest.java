package com.ceiba.habitacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.HabitacionroTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarHabitacionTest {
    @Test
    public void validarExistenciaPreviaTest() {

        Habitacion habitacion = new HabitacionroTestDataBuilder().build();
        // arrange
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existeHabitacion(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarHabitacion servicioActualizarHabitacion = new ServicioActualizarHabitacion(repositorioHabitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarHabitacion.ejecutar(habitacion), ExcepcionSinDatos.class, "La habitacion no existe");
    }
}
