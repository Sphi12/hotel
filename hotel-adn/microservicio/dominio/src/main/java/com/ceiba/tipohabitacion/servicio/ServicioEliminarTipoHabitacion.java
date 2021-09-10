package com.ceiba.tipohabitacion.servicio;

import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;

public class ServicioEliminarTipoHabitacion {

    private final RepositorioTipoHabitacion repositorioTipoHabitacion;

    public ServicioEliminarTipoHabitacion(RepositorioTipoHabitacion repositorioTipoHabitacion) {
        this.repositorioTipoHabitacion = repositorioTipoHabitacion;
    }

    public void ejecutar(Long id) {
        this.repositorioTipoHabitacion.eliminarTHabitacion(id);
    }
}
