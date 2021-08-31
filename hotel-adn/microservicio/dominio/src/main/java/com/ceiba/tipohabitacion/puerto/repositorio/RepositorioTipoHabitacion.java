package com.ceiba.tipohabitacion.puerto.repositorio;

import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;

public interface RepositorioTipoHabitacion {
    /**
     * Permite crear un tipoHabitacion
     * @param tipoHabitacion
     * @return el id generado
     */
    Long crear(TipoHabitacion tipoHabitacion);

    /**
     * Permite actualizar un tipoHabitacion
     * @param tipoHabitacion
     */
    void actualizar(TipoHabitacion tipoHabitacion);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un tipoHabitacion con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un tipoHabitacion con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);

}
