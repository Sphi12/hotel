package com.ceiba.tipoparqueadero.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tipoparqueadero.comando.ComandoTipoParqueadero;
import com.ceiba.tipoparqueadero.comando.manejador.ManejadorActualizarTipoParqueadero;
import com.ceiba.tipoparqueadero.comando.manejador.ManejadorCrearTipoParqueadero;
import com.ceiba.tipoparqueadero.comando.manejador.ManejadorEliminarTipoParqueadero;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoparqueadero")
@Api(tags = { "Controlador comando tipohabitacion"})
public class ComandoControladorTipoParqueadero {

    private final ManejadorCrearTipoParqueadero manejadorCrearTipoParqueadero;
	private final ManejadorEliminarTipoParqueadero manejadorEliminarTipoParqueadero;
	private final ManejadorActualizarTipoParqueadero manejadorActualizarTipoParqueadero;

    @Autowired
    public ComandoControladorTipoParqueadero(ManejadorCrearTipoParqueadero manejadorCrearTipoParqueadero,
											 ManejadorEliminarTipoParqueadero manejadorEliminarTipoParqueadero,
											 ManejadorActualizarTipoParqueadero manejadorActualizarTipoParqueadero) {
        this.manejadorCrearTipoParqueadero = manejadorCrearTipoParqueadero;
		this.manejadorEliminarTipoParqueadero = manejadorEliminarTipoParqueadero;
		this.manejadorActualizarTipoParqueadero = manejadorActualizarTipoParqueadero;
    }

    @PostMapping
    @ApiOperation("Crear Tipo habitacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTipoParqueadero comandoTipoParqueadero) {
        return manejadorCrearTipoParqueadero.ejecutar(comandoTipoParqueadero);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Tipo habitacion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarTipoParqueadero.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Tipo habitacion")
	public void actualizar(@RequestBody ComandoTipoParqueadero comandoTipoParqueadero, @PathVariable Long id) {
		comandoTipoParqueadero.setId(id);
		manejadorActualizarTipoParqueadero.ejecutar(comandoTipoParqueadero);
	}
}
