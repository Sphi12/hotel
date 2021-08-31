package com.ceiba.reserva.controlador;

import java.util.List;

import com.ceiba.reserva.consulta.ManejadorListarReserva;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservas")
@Api(tags={"Controlador consulta reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListarReserva manejadorListarReserva;

    public ConsultaControladorReserva(ManejadorListarReserva manejadorListarReserva) {
        this.manejadorListarReserva = manejadorListarReserva;
    }

    @GetMapping
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar() {
        return this.manejadorListarReserva.ejecutar();
    }

}
