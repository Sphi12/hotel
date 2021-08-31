package com.ceiba.habitacion.puerto.dao;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;

import java.util.List;

public interface DaoHabitacion {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoHabitacion> listar();
}
