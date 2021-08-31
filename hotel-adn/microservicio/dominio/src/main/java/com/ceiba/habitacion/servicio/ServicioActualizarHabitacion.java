package com.ceiba.habitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;

public class ServicioActualizarHabitacion {

    private static final String YA_EXISTE_EN_EL_SISTEMA = "La habitacion ya existe";

    private final RepositorioHabitacion repositorioHabitacion;

    public ServicioActualizarHabitacion(RepositorioHabitacion repositorioHabitacion) {
        this.repositorioHabitacion = repositorioHabitacion;
    }

    public void ejecutar(Habitacion habitacion) {
        validarExistenciaPrevia(habitacion);
        this.repositorioHabitacion.actualizar(habitacion);
    }

    private void validarExistenciaPrevia(Habitacion habitacion) {
        boolean existe = this.repositorioHabitacion.existeExcluyendoId(habitacion.getId(),habitacion.getTipo());
        if(existe) {
            throw new ExcepcionDuplicidad(YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
