package com.ceiba.tipohabitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;

public class ServicioEliminarTipoHabitacion {

    private final RepositorioTipoHabitacion repositorioTipoHabitacion;
    private static final String EL_TIPO_HAB_YA_EXISTE_EN_EL_SISTEMA = "El tipo de habitacion no existe en el sistema";

    public ServicioEliminarTipoHabitacion(RepositorioTipoHabitacion repositorioTipoHabitacion) {
        this.repositorioTipoHabitacion = repositorioTipoHabitacion;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioTipoHabitacion.eliminarTHabitacion(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioTipoHabitacion.existeTHabitacion(id);
        if(!existe) {
            throw new ExcepcionSinDatos(EL_TIPO_HAB_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
