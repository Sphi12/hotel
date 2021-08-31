package com.ceiba.parqueadero.controlador;

import java.util.List;

import com.ceiba.parqueadero.consulta.ManejadorListarParqueaderos;
import com.ceiba.parqueadero.modelo.dto.DtoParqueadero;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parqueaderos")
@Api(tags={"Controlador consulta parqueadero"})
public class ConsultaControladorParqueadero {

    private final ManejadorListarParqueaderos manejadorListarParqueaderos;

    public ConsultaControladorParqueadero(ManejadorListarParqueaderos manejadorListarParqueaderos) {
        this.manejadorListarParqueaderos = manejadorListarParqueaderos;
    }

    @GetMapping
    @ApiOperation("Listar parqueaderos")
    public List<DtoParqueadero> listar() {
        return this.manejadorListarParqueaderos.ejecutar();
    }

}
