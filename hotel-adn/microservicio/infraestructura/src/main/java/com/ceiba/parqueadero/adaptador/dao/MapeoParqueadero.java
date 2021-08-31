package com.ceiba.parqueadero.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parqueadero.modelo.dto.DtoParqueadero;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoParqueadero implements RowMapper<DtoParqueadero>, MapperResult {

    @Override
    public DtoParqueadero mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long TipoParqueadero = resultSet.getLong("id");
        boolean disponible = resultSet.getBoolean("disponible");


        return new DtoParqueadero(id,TipoParqueadero,disponible);
    }

}
