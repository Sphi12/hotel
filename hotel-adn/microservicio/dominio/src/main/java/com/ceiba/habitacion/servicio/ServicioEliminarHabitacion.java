package com.ceiba.habitacion.servicio;

import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;

public class ServicioEliminarHabitacion {

    private final RepositorioHabitacion repositorioUsuario;

    public ServicioEliminarHabitacion(RepositorioHabitacion repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long id) {
        this.repositorioUsuario.eliminar(id);
    }
}
