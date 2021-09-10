package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;


public interface RepositorioReserva {

    /**
     * Permite crear un reserva
     * @param reserva
     * @return el id generado
     */
    Long crearReserva(Reserva reserva);

    /**
     * Permite actualizar una reserva
     * @param reserva
     */
    void actualizarReserva(Reserva reserva);

    /**
     * Permite eliminar un reserva
     * @param id
     */
    void eliminarReserva(Long id);

    /**
     * Permite validar si existe un reserva con un id
     * @param id
     * @return si existe o no
     */
    boolean existeReserva(Long id);

    /**
     * Permite validar si existe un reserva con un nombrePersona excluyendo un id
     * @param nombrePersona
     * @return si existe o no
     */
    boolean existeExcluyendoIdReserva(Long id, String nombrePersona);
}
