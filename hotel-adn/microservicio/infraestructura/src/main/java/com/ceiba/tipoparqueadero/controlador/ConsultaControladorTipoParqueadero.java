package com.ceiba.tipoparqueadero.controlador;


import com.ceiba.tipoparqueadero.consulta.ManejadorListarTipoParqueaderos;
import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoparqueadero")
@Api(tags={"Controlador consulta tipohabitacion"})
public class ConsultaControladorTipoParqueadero {

    private final ManejadorListarTipoParqueaderos manejadorListarTipoParqueaderos;

    public ConsultaControladorTipoParqueadero(ManejadorListarTipoParqueaderos manejadorListarTipoParqueaderos) {
        this.manejadorListarTipoParqueaderos = manejadorListarTipoParqueaderos;
    }

    @GetMapping
    @ApiOperation("Listar tipo habitacion")
    public List<DtoTipoParqueadero> listar() {
        return this.manejadorListarTipoParqueaderos.ejecutar();
    }

}
