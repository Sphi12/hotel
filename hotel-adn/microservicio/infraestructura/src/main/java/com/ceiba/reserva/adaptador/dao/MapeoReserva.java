package com.ceiba.reserva.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;

import org.springframework.jdbc.core.RowMapper;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idHabitacion = resultSet.getLong("id_habitacion");
        Long idParqueadero = resultSet.getLong("id_parqueadero");
        LocalDate fechaReserva = extraerLocalDate(resultSet, "fecha_reserva");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "fech_ingreso");
        LocalDate fechaSalida = extraerLocalDate(resultSet, "fecha_salida");
        Double precioDia = resultSet.getDouble("precio_dia");
        Double precioTotal = resultSet.getDouble("precio_total");
        boolean checkIn = resultSet.getBoolean("checkin");
        boolean checkOut = resultSet.getBoolean("checkout");


        return new DtoReserva(id,idHabitacion,idParqueadero,fechaReserva,fechaIngreso,fechaSalida,precioDia,precioTotal,checkIn,checkOut);
    }

}
