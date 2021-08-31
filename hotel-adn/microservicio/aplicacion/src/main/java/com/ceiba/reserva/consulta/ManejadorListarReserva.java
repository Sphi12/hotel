package com.ceiba.reserva.consulta;

import java.util.List;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;


@Component
public class ManejadorListarReserva {

    private final DaoReserva daoReserva;

    public ManejadorListarReserva(DaoReserva daoReserva){
        this.daoReserva = daoReserva;
    }

    public List<DtoReserva> ejecutar(){ return this.daoReserva.listar(); }
}
