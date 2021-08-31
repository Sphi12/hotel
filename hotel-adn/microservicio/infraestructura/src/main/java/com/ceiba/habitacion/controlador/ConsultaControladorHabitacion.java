package com.ceiba.usuario.controlador;

import java.util.List;

import com.ceiba.habitacion.consulta.ManejadorListarHabitaciones;
import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorHabitacion {

    private final ManejadorListarHabitaciones manejadorListarHabitaciones;

    public ConsultaControladorHabitacion(ManejadorListarHabitaciones manejadorListarUsuarios) {
        this.manejadorListarHabitaciones = manejadorListarUsuarios;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoHabitacion> listar() {
        return this.manejadorListarHabitaciones.ejecutar();
    }

}
