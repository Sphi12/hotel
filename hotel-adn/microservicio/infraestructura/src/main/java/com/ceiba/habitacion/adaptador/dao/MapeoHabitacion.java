package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
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
