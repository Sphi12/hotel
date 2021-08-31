package com.ceiba.tipoparqueadero.puerto.dao;

import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoTipoParqueadero {
    /**
     * Permite listar tipo de parqueaderos
     * @return los tiposParqueaderos
     */
    List<DtoTipoParqueadero> listar();

}
