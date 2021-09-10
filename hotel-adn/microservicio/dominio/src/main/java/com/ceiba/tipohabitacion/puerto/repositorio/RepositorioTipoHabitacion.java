package com.ceiba.tipohabitacion.puerto.repositorio;

import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;

import java.util.List;

public interface RepositorioTipoHabitacion {
    /**
     * Permite crear un tipoHabitacion
     * @param tipoHabitacion
     * @return el id generado
     */
    Long crearTHabitacion(TipoHabitacion tipoHabitacion);

    /**
     * Permite actualizar un tipoHabitacion
     * @param tipoHabitacion
     */
    void actualizarTHabitacion(TipoHabitacion tipoHabitacion);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminarTHabitacion(Long id);

    /**
     * Permite validar si existe un tipoHabitacion con un nombre
     * @param id
     * @return si existe o no
     */
    boolean existeTHabitacion(Long id);

    /**
     * Permite validar si existe un tipoHabitacion con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoIdTHabitacion(Long id, String nombre);

    List<DtoTipoHabitacion> obtenerPorIdTHabitacion(String nombre);

}
