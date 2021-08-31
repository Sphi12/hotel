package com.ceiba.habitacion.consulta;

import java.util.List;

import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

@Component
public class ManejadorListarHabitaciones {

    private final DaoHabitacion daoHabitacion;

    public ManejadorListarHabitaciones(DaoHabitacion daoHabitacion){
        this.daoHabitacion = daoHabitacion;
    }

    public List<DtoHabitacion> ejecutar(){ return this.daoHabitacion.listar(); }
}
