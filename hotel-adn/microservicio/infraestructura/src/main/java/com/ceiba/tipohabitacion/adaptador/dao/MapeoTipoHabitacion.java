package com.ceiba.tipohabitacion.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoTipoHabitacion implements RowMapper<DtoTipoHabitacion>, MapperResult {

    @Override
    public DtoTipoHabitacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        Double precioSemana = resultSet.getDouble("precioSemana");
        Double precioFinSemana = resultSet.getDouble("precioFinSemana");
        int capacidadPersonas = resultSet.getInt("capacidadPersonas");
        int numeroCamas = resultSet.getInt("numeroCamas");
        String descripcionCamas = resultSet.getString("descripcionCamas");
        return new DtoTipoHabitacion(id,nombre,descripcion,precioSemana,precioFinSemana,capacidadPersonas,numeroCamas,descripcionCamas);
    }

}
