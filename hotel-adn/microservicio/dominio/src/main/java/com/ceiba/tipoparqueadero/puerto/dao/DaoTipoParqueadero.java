package com.ceiba.tipoparqueadero.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoTipoParqueadero {
    /**
     * Permite listar tipo de parqueaderos
     * @return los tiposParqueaderos
     */
    List<DaoTipoParqueadero> listar();

}
