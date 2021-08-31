package com.ceiba.parqueadero.consulta;

import java.util.List;

import com.ceiba.parqueadero.modelo.dto.DtoParqueadero;
import com.ceiba.parqueadero.puerto.dao.DaoParqueadero;

import org.springframework.stereotype.Component;

@Component
public class ManejadorListarParqueaderos {

    private final DaoParqueadero daoParqueadero;

    public ManejadorListarParqueaderos(DaoParqueadero daoParqueadero){
        this.daoParqueadero = daoParqueadero;
    }

    public List<DtoParqueadero> ejecutar(){ return this.daoParqueadero.listar(); }
}
