package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarUsuarioTest {

    @Test
    public void validarUsuarioNoExistenciaPreviaTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existeUsuario(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarUsuario servicioEliminarUsuario = new ServicioEliminarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarUsuario.ejecutar(usuario.getId()),
                ExcepcionSinDatos.class,"El usuario no existe en el sistema");
    }
}
