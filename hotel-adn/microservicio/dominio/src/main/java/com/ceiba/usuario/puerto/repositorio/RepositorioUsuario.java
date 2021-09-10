package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {
    /**
     * Permite crear un usuario
     * @param usuario
     * @return el id generado
     */
    Long crearUsuario(Usuario usuario);

    /**
     * Permite actualizar un usuario
     * @param usuario
     */
    void actualizarUsuario(Usuario usuario);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminarUsuario(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existeUsuario(Long id);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoIdUsuario(Long id, String nombre);

}
