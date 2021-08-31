package com.ceiba.tipohabitacion.puerto.dao;

import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;

import java.util.List;

public interface DaoTipoHabitacion {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoTipoHabitacion> listar();
}
