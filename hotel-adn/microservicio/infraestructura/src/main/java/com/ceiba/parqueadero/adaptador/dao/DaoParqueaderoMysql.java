package com.ceiba.parqueadero.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parqueadero.modelo.dto.DtoParqueadero;
import com.ceiba.parqueadero.puerto.dao.DaoParqueadero;
import org.springframework.stereotype.Component;


@Component
public class DaoParqueaderoMysql implements DaoParqueadero {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="parqueadero", value="listar")
    private static String sqlListar;

    public DaoParqueaderoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoParqueadero> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoParqueadero());
    }
}
