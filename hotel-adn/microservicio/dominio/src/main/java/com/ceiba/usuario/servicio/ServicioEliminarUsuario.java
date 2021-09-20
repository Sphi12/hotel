package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";
    private final RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioUsuario.eliminarUsuario(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioUsuario.existeUsuario(id);
        if(!existe) {
            throw new ExcepcionSinDatos(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
