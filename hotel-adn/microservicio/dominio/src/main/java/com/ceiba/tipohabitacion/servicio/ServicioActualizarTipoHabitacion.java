package com.ceiba.tipohabitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;

public class ServicioActualizarTipoHabitacion {

    private static final String EL_TIPO_HAB_YA_EXISTE_EN_EL_SISTEMA = "El tipo de habitacion no existe en el sistema";

    private final RepositorioTipoHabitacion repositorioTipoHabitacion;

    public ServicioActualizarTipoHabitacion(RepositorioTipoHabitacion repositorioUsuario) {
        this.repositorioTipoHabitacion = repositorioUsuario;
    }

    public void ejecutar(TipoHabitacion tipoHabitacion) {
        validarExistenciaPrevia(tipoHabitacion);
        this.repositorioTipoHabitacion.actualizar(tipoHabitacion);
    }

    private void validarExistenciaPrevia(TipoHabitacion tipoHabitacion) {
        boolean existe = this.repositorioTipoHabitacion.existeExcluyendoId(tipoHabitacion.getId(),tipoHabitacion.getNombre());
        if(!existe) {
            throw new ExcepcionSinDatos(EL_TIPO_HAB_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
