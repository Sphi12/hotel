package com.ceiba.parqueadero.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.parqueadero.servicio.testdatabuilder.ParqueaderoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarParqueaderoTest {
    @Test
    public void validarNoExistenciaPreviaTest() {

        Parqueadero parqueadero = new ParqueaderoTestDataBuilder().build();
        // arrange
        RepositorioParqueadero repositorioParqueadero = Mockito.mock(RepositorioParqueadero.class);
        Mockito.when(repositorioParqueadero.existeParqueadero(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarParqueadero servicioEliminarParqueadero = new ServicioEliminarParqueadero(repositorioParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarParqueadero.ejecutar(parqueadero.getId()),
                ExcepcionSinDatos.class, "El parqueadero no existe en el sistema");
    }
}
