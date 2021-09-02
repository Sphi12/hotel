package com.ceiba.habitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;


public class ServicioCrearHabitacion {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioHabitacion repositorioHabitacion;

    public ServicioCrearHabitacion(RepositorioHabitacion repositorioUsuario) {
        this.repositorioHabitacion = repositorioUsuario;
    }

    public Long ejecutar(Habitacion habitacion) {
        validarExistenciaPrevia(habitacion);
        return this.repositorioHabitacion.crear(habitacion);
    }

    private void validarExistenciaPrevia(Habitacion habitacion) {
        boolean existe = this.repositorioHabitacion.existe(habitacion.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
