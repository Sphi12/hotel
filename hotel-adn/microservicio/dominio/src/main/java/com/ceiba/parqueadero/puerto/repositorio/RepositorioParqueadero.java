package com.ceiba.parqueadero.puerto.repositorio;

import com.ceiba.parqueadero.modelo.entidad.Parqueadero;


public interface RepositorioParqueadero {

    /**
     * Permite crear un parqueadero
     * @param parqueadero
     * @return el id generado
     */
    Long crear(Parqueadero parqueadero);

    /**
     * Permite actualizar un parqueadero
     * @param parqueadero
     */
    void actualizar(Parqueadero parqueadero);

    /**
     * Permite eliminar un parqueadero
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un parqueadero con un id
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite validar si existe un parqueadero con un idTipoParqueadero excluyendo un id
     * @param idTipoParqueadero
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,Long idTipoParqueadero);
}
