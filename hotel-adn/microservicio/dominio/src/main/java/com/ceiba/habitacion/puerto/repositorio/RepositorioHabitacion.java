package com.ceiba.habitacion.puerto.repositorio;

import com.ceiba.habitacion.modelo.entidad.Habitacion;

public interface RepositorioHabitacion {
    /**
     * Permite crear un habitacion
     * @param habitacion
     * @return el id generado
     */
    Long crear(Habitacion habitacion);

    /**
     * Permite actualizar un habitacion
     * @param habitacion
     */
    void actualizar(Habitacion habitacion);

    /**
     * Permite eliminar un habitacion
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un habitacion con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un habitacion con un nombre excluyendo un id
     * @param id
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,Long tipo);

}
