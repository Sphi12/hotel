package com.ceiba.tipoparqueadero.puerto.dao;

import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;

import java.util.List;

public interface DaoTipoParqueadero {
    /**
     * Permite listar tipo de parqueaderos
     * @return los tiposParqueaderos
     */
    List<DtoTipoParqueadero> listar();

}
