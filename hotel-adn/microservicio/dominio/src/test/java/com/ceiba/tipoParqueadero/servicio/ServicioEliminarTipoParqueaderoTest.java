package com.ceiba.tipoParqueadero.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoParqueadero.servicio.testdatabuilder.TipoParqueaderoTestDataBuilder;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioActualizarTipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioEliminarTipoParqueadero;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarTipoParqueaderoTest {

    @Test
    public void validarNoExistenciaPreviaTest() {
        TipoParqueadero tipoParqueadero = new TipoParqueaderoTestDataBuilder().build();
        // arrange
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);
        Mockito.when(repositorioTipoParqueadero.existeTParqueadero(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarTipoParqueadero servicioEliminarTipoParqueadero = new ServicioEliminarTipoParqueadero(repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarTipoParqueadero.ejecutar(tipoParqueadero.getId()),
                ExcepcionDuplicidad.class, "El tipo parqueadero no existe en el sistema");
    }

    @Test
    public void validarExistenciaPreviaTest() {
        TipoParqueadero tipoParqueadero = new TipoParqueaderoTestDataBuilder().build();
        // arrange
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);
        Mockito.when(repositorioTipoParqueadero.existeTParqueadero(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarTipoParqueadero servicioEliminarTipoParqueadero = new ServicioEliminarTipoParqueadero(repositorioTipoParqueadero);
        servicioEliminarTipoParqueadero.ejecutar(tipoParqueadero.getId());
    }
}
