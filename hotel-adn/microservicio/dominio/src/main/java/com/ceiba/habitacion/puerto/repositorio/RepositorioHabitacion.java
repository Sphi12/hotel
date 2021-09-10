package com.ceiba.habitacion.puerto.repositorio;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.modelo.entidad.Habitacion;

import java.util.List;

public interface RepositorioHabitacion {
    /**
     * Permite crear un habitacion
     * @param habitacion
     * @return el id generado
     */
    Long crearHabitacion(Habitacion habitacion);

    /**
     * Permite actualizar un habitacion
     * @param habitacion
     */
    void actualizarHabitacion(Habitacion habitacion);

    /**
     * Permite eliminar un habitacion
     * @param id
     */
    void eliminarHabitacion(Long id);

    /**
     * Permite validar si existe un habitacion con un nombre
     * @param id
     * @return si existe o no
     */
    boolean existeHabitacion(Long id);

    /**
     * Permite validar si existe un habitacion con un nombre excluyendo un id
     * @param id
     * @return si existe o no
     */
    boolean existeExcluyendoIdHabitacion(Long id, Long tipo);

    List<DtoHabitacion> listarPorTipoHabitacion();

    Long obtenerHabitacionDisponibleHabitacion(String tipo);

    void actualizarDisponibilidadHabitacion(Long id, String disponible);
}
