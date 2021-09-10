package com.ceiba.habitacion.controlador;

import java.util.List;

import com.ceiba.habitacion.consulta.ManejadorListarHabitaciones;
import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/habitaciones")
@Api(tags={"Controlador consulta habitaciones"})
public class ConsultaControladorHabitacion {

    private final ManejadorListarHabitaciones manejadorListarHabitaciones;

    public ConsultaControladorHabitacion(ManejadorListarHabitaciones manejadorListarHabitaciones) {
        this.manejadorListarHabitaciones = manejadorListarHabitaciones;
    }

    @GetMapping
    @ApiOperation("Listar habitaciones")
    public List<DtoHabitacion> listar() {
        return this.manejadorListarHabitaciones.ejecutar();
    }

}
