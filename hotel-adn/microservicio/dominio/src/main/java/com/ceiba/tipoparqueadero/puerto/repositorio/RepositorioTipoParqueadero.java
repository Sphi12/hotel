package com.ceiba.tipoparqueadero.puerto.repositorio;

import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;

import java.util.List;

public interface RepositorioTipoParqueadero {

    /**
     * Permite crear un tipoParqueadero
     * @param tipoParqueadero
     * @return el id generado
     */
    Long crearTParqueadero(TipoParqueadero tipoParqueadero);

    /**
     * Permite actualizar un tipoParqueadero
     * @param tipoParqueadero
     */
    void actualizarTParqueadero(TipoParqueadero tipoParqueadero);

    /**
     * Permite eliminar un tipoParqueadero
     * @param id
     */
    void eliminarTParqueadero(Long id);

    /**
     * Permite validar si existe un tipoParqueadero con un id
     * @param id
     * @return si existe o no
     */
    boolean existeTParqueadero(Long id);

    /**
     * Permite validar si existe un tipoParqueadero con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoIdTParqueadero(Long id, String nombre);

    public List<DtoTipoParqueadero> obtenerIdTParqueadero(String nombre);
}
