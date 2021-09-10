package com.ceiba.parqueadero.servicio;

import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.parqueadero.servicio.testdatabuilder.ParqueaderoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import static org.junit.Assert.assertEquals;

public class ServicioCrearParqueaderoTest {

    @Test
    public void validarExistenciaPreviaTest() {

        Parqueadero parqueadero = new ParqueaderoTestDataBuilder().build();
        // arrange
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        Mockito.when(repositorioParqueadero.existeParqueadero(Mockito.anyLong())).thenReturn(true);
        ServicioCrearParqueadero servicioCrearParqueadero = new ServicioCrearParqueadero(repositorioParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearParqueadero.ejecutar(parqueadero), ExcepcionDuplicidad.class, "El parqueadero ya existe en el sistema");
    }
}
