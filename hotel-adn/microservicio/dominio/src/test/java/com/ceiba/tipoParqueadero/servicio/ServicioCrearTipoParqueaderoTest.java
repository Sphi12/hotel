package com.ceiba.tipoParqueadero.servicio;

import com.ceiba.tipoParqueadero.servicio.testdatabuilder.TipoParqueaderoTestDataBuilder;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioCrearTipoParqueadero;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import static org.junit.Assert.assertEquals;
public class ServicioCrearTipoParqueaderoTest {

    @Test
    public void validarExistenciaPreviaTest() {
        TipoParqueadero tipoParqueadero = new TipoParqueaderoTestDataBuilder().build();
        // arrange
        RepositorioTipoParqueadero repositorioTipoParqueadero = Mockito.mock(RepositorioTipoParqueadero.class);
        Mockito.when(repositorioTipoParqueadero.existeTParqueadero(Mockito.anyLong())).thenReturn(true);
        ServicioCrearTipoParqueadero servicioCrearTipoParqueadero = new ServicioCrearTipoParqueadero(repositorioTipoParqueadero);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearTipoParqueadero.ejecutar(tipoParqueadero), ExcepcionDuplicidad.class, "El tipo tipo parqueadero ya existe en el sistema");
    }

}
