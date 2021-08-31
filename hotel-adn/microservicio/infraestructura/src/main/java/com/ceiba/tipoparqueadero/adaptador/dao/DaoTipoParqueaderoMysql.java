package com.ceiba.tipoparqueadero.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.dao.DaoTipoParqueadero;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTipoParqueaderoMysql implements DaoTipoParqueadero {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipoparqueadero", value="listar")
    private static String sqlListar;

    public DaoTipoParqueaderoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTipoParqueadero> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTipoParqueadero());
    }
}
