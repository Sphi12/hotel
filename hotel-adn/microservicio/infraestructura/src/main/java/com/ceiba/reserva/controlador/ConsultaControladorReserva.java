package com.ceiba.reserva.controlador;

import java.util.List;

import com.ceiba.reserva.consulta.ManejadorListarReserva;
import com.ceiba.reserva.consulta.ManejadorObtenerReserva;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservas")
@Api(tags={"Controlador consulta reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListarReserva manejadorListarReserva;
    private final ManejadorObtenerReserva manejadorObtenerReserva;

    public ConsultaControladorReserva(ManejadorListarReserva manejadorListarReserva, ManejadorObtenerReserva manejadorObtenerReserva) {
        this.manejadorListarReserva = manejadorListarReserva;
        this.manejadorObtenerReserva = manejadorObtenerReserva;
    }

    @GetMapping
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar() {
        return this.manejadorListarReserva.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Listar reservas por id")
    public DtoReserva listarPorId(@PathVariable Long id) {
        return this.manejadorObtenerReserva.ejecutar(id);
    }
}
