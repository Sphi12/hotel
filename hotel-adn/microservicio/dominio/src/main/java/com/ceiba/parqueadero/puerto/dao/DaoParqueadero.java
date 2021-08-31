package com.ceiba.parqueadero.puerto.dao;

import com.ceiba.parqueadero.modelo.dto.DtoParqueadero;

import java.util.List;

public interface DaoParqueadero {
    /**
     * Permite listar parqueaderos
     * @return los parqueaderos
     */
    List<DtoParqueadero> listar();
}
