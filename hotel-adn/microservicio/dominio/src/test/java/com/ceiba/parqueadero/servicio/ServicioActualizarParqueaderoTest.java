package com.ceiba.parqueadero.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.parqueadero.servicio.testdatabuilder.ParqueaderoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ServicioActualizarParqueaderoTest {
    @Test
    public void validarExistenciaPreviaTest() {

        Parqueadero parqueadero = new ParqueaderoTestDataBuilder().build();
        // arrange
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        Mockito.when(repositorioParqueadero.existeParqueadero(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarParqueadero servicioActualizarParqueadero = new ServicioActualizarParqueadero(repositorioParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarParqueadero.ejecutar(parqueadero), ExcepcionSinDatos.class, "El parqueadero no existe en el sistema");
    }
}
