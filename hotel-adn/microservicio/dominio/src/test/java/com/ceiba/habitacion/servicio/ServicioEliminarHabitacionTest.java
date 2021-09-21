package com.ceiba.habitacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.HabitacionroTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarHabitacionTest {
    @Test
    public void validarNoExistenciaPreviaTest() {

        Habitacion habitacion = new HabitacionroTestDataBuilder().build();
        // arrange
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existeHabitacion(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarHabitacion servicioEliminarHabitacion = new ServicioEliminarHabitacion(repositorioHabitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarHabitacion.ejecutar(habitacion.getId()), ExcepcionSinDatos.class, "La habitacion no existe");
    }

    @Test
    public void validarExistenciaPreviaTest() {

        Habitacion habitacion = new HabitacionroTestDataBuilder().build();
        // arrange
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existeHabitacion(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarHabitacion servicioEliminarHabitacion = new ServicioEliminarHabitacion(repositorioHabitacion);
        servicioEliminarHabitacion.ejecutar(habitacion.getId());
    }
}
