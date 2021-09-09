package com.ceiba.tipohabitacion.controlador;

import java.util.List;

import com.ceiba.tipohabitacion.consulta.ManejadorListarTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tipohabitacion")
@Api(tags={"Controlador consulta tipohabitacion"})
public class ConsultaControladorTipoHabitacion {

    private final ManejadorListarTipoHabitacion manejadorListarTipoHabitacion;

    public ConsultaControladorTipoHabitacion(ManejadorListarTipoHabitacion manejadorListarTipoHabitacion) {
        this.manejadorListarTipoHabitacion = manejadorListarTipoHabitacion;
    }

    @GetMapping
    @ApiOperation("Listar tipo habitacion")
    public List<DtoTipoHabitacion> listar() {
        return this.manejadorListarTipoHabitacion.ejecutar();
    }

}
