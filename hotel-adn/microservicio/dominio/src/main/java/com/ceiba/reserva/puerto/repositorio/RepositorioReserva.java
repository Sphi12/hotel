package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;


public interface RepositorioReserva {

    /**
     * Permite crear un reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);

    /**
     * Permite actualizar una reserva
     * @param reserva
     */
    void actualizar(Reserva reserva);

    /**
     * Permite eliminar un reserva
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un reserva con un id
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite validar si existe un reserva con un nombrePersona excluyendo un id
     * @param nombrePersona
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombrePersona);
}
