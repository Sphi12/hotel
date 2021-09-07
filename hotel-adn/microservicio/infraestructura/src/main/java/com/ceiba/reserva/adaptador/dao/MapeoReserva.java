package com.ceiba.reserva.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;

import org.springframework.jdbc.core.RowMapper;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("ID_RESERVA");
        Long idHabitacion = resultSet.getLong("ID_HABITACION");
        String tipoHabitacion = resultSet.getString("TIPO_ID_HABITACION");
        Long idParqueadero = resultSet.getLong("ID_PARQUEADERO");
        String tipoParqueadero = resultSet.getString("TIPO_PARQUEADERO");
        Long idUsuario = resultSet.getLong("ID_USUARIO");
        LocalDateTime fechaReserva = extraerLocalDateTime(resultSet, "FECHA_RESERVA");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "FECHA_INGRESO");
        LocalDate fechaSalida = extraerLocalDate(resultSet, "FECHA_SALIDA");
        Double precioTotal = resultSet.getDouble("PRECIO_TOTAL");
        boolean checkIn = resultSet.getBoolean("CHECK_IN");
        boolean checkOut = resultSet.getBoolean("CHECK_OUT");


        return new DtoReserva(id,idHabitacion,tipoHabitacion,idParqueadero,tipoParqueadero,
                idUsuario,fechaReserva,fechaIngreso,fechaSalida,precioTotal,checkIn,checkOut);
    }

}
