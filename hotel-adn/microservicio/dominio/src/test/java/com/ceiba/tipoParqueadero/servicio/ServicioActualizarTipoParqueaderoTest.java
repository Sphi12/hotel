package com.ceiba.tipoParqueadero.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoParqueadero.servicio.testdatabuilder.TipoParqueaderoTestDataBuilder;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioActualizarTipoParqueadero;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarTipoParqueaderoTest {

    @Test
    public void validarExistenciaPreviaTest() {
        TipoParqueadero tipoParqueadero = new TipoParqueaderoTestDataBuilder().build();
        // arrange
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);
        Mockito.when(repositorioTipoParqueadero.existeTParqueadero(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarTipoParqueadero servicioActualizarTipoParqueadero = new ServicioActualizarTipoParqueadero(repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTipoParqueadero.ejecutar(tipoParqueadero), ExcepcionDuplicidad.class, "El tipo parqueadero no existe en el sistema");
    }

}
