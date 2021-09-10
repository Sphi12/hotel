package com.ceiba.habitacion.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

public class MapeoHabitacion implements RowMapper<DtoHabitacion>, MapperResult {

    @Override
    public DtoHabitacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long tipo = resultSet.getLong("tipo");
        boolean disponible = resultSet.getBoolean("disponible");


        return new DtoHabitacion(id,tipo,disponible);
    }

}
