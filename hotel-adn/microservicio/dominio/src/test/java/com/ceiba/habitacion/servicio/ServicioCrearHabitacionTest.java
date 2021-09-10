package com.ceiba.habitacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.HabitacionroTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearHabitacionTest {

    @Test
    public void validarExistenciaPreviaTest() {

        Habitacion habitacion = new HabitacionroTestDataBuilder().build();
        // arrange
        RepositorioHabitacion repositorioHabitacion = Mockito.mock(RepositorioHabitacion.class);
        Mockito.when(repositorioHabitacion.existeHabitacion(Mockito.anyLong())).thenReturn(true);
        ServicioCrearHabitacion servicioCrearHabitacion = new ServicioCrearHabitacion(repositorioHabitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHabitacion.ejecutar(habitacion), ExcepcionDuplicidad.class, "La habitacion ya existe en el sistema");
    }
}
