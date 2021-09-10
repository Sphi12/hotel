package com.ceiba.parqueadero.puerto.repositorio;

import com.ceiba.parqueadero.modelo.entidad.Parqueadero;


public interface RepositorioParqueadero {

    /**
     * Permite crear un parqueadero
     *
     * @param parqueadero
     * @return el id generado
     */
    Long crearParqueadero(Parqueadero parqueadero);

    /**
     * Permite actualizar un parqueadero
     *
     * @param parqueadero
     */
    void actualizarParqueadero(Parqueadero parqueadero);

    /**
     * Permite eliminar un parqueadero
     *
     * @param id
     */
    void eliminarParqueadero(Long id);

    /**
     * Permite validar si existe un parqueadero con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existeParqueadero(Long id);

    /**
     * Permite validar si existe un parqueadero con un idTipoParqueadero excluyendo un id
     *
     * @param idTipoParqueadero
     * @return si existe o no
     */
    boolean existeExcluyendoIdParqueadero(Long id, Long idTipoParqueadero);

    /**
     * Permite obtener el id de un parqueadero disponible dado el tipo de parqueadero
     *
     * @param tipo
     * @return
     */
    Long obtenerParqueaderoDisponibleParqueadero(String tipo);
}
