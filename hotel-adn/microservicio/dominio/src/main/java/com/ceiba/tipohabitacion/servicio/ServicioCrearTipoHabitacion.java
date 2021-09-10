package com.ceiba.tipohabitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;


public class ServicioCrearTipoHabitacion {

    private static final String EL_TIPO_HAB_YA_EXISTE_EN_EL_SISTEMA = "El tipo de habitacion ya existe en el sistema";

    private final RepositorioTipoHabitacion repositorioUsuario;

    public ServicioCrearTipoHabitacion(RepositorioTipoHabitacion repositorioTipoHabitacion) {
        this.repositorioUsuario = repositorioTipoHabitacion;
    }

    public Long ejecutar(TipoHabitacion tipoHabitacion) {
        validarExistenciaPrevia(tipoHabitacion);
        return this.repositorioUsuario.crearTipoHabitacion(tipoHabitacion);
    }

    private void validarExistenciaPrevia(TipoHabitacion tipoHabitacion) {
        boolean existe = this.repositorioUsuario.existeTipoHabitacion(tipoHabitacion.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_HAB_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
