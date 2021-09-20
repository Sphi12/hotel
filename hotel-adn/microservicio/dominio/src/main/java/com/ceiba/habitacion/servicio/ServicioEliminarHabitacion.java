package com.ceiba.habitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;

public class ServicioEliminarHabitacion {

    private final RepositorioHabitacion repositorioHabitacion;
    private static final String YA_EXISTE_EN_EL_SISTEMA = "La habitacion no existe";

    public ServicioEliminarHabitacion(RepositorioHabitacion repositorioHabitacion) {
        this.repositorioHabitacion = repositorioHabitacion;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia( id);
        this.repositorioHabitacion.eliminarHabitacion(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioHabitacion.existeHabitacion(id);
        if(!existe) {
            throw new ExcepcionSinDatos(YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
