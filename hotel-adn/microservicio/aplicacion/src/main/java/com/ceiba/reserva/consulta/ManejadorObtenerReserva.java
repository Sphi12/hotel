package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerReserva {

    private final DaoReserva daoReserva;
    private static final String HABITACION_NO_DISPONIBLE = "No hay habitaciones disponibles";

    public ManejadorObtenerReserva(DaoReserva daoReserva){
        this.daoReserva = daoReserva;
    }

    public DtoReserva ejecutar(Long id){
            return this.daoReserva.obtener(id);
    }



}
