package com.ceiba.habitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;


public class ServicioCrearHabitacion {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioHabitacion repositorioUsuario;

    public ServicioCrearHabitacion(RepositorioHabitacion repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Habitacion usuario) {
        validarExistenciaPrevia(usuario);
        return this.repositorioUsuario.crear(usuario);
    }

    private void validarExistenciaPrevia(Habitacion usuario) {
        boolean existe = this.repositorioUsuario.existe(usuario.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
