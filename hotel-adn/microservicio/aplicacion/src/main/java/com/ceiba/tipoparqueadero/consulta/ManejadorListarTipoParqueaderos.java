package com.ceiba.tipoparqueadero.consulta;

import java.util.List;

import com.ceiba.tipoparqueadero.puerto.dao.DaoTipoParqueadero;

import org.springframework.stereotype.Component;


@Component
public class ManejadorListarTipoParqueaderos {

    private final DaoTipoParqueadero daoTipoParqueadero;

    public ManejadorListarTipoParqueaderos(DaoTipoParqueadero daoTipoParqueadero){
        this.daoTipoParqueadero = daoTipoParqueadero;
    }

    public List<DaoTipoParqueadero> ejecutar(){ return this.daoTipoParqueadero.listar(); }
}
