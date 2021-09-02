package com.ceiba.tipoparqueadero.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTipoParqueadero implements RowMapper<DtoTipoParqueadero>, MapperResult {

    @Override
    public DtoTipoParqueadero mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripción");
        Double precio = resultSet.getDouble("precio");
        return new DtoTipoParqueadero(id,nombre,descripcion,precio);
    }

}
