package com.ceiba.parqueadero.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parqueadero.modelo.dto.DtoParqueadero;
import org.springframework.jdbc.core.RowMapper;

public class MapeoParqueadero implements RowMapper<DtoParqueadero>, MapperResult {

    @Override
    public DtoParqueadero mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long tipoParqueadero = resultSet.getLong("id");
        boolean disponible = resultSet.getBoolean("disponible");


        return new DtoParqueadero(id,tipoParqueadero,disponible);
    }

}
