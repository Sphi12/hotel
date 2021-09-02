package com.ceiba.habitacion.puerto.dao;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;

import java.util.List;

public interface DaoHabitacion {

    /**
     * Permite listar habitaciones
     * @return las habitaciones
     */
    List<DtoHabitacion> listar();
}
