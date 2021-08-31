package com.ceiba.parqueadero.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.parqueadero.comando.ComandoParqueadero;
import com.ceiba.parqueadero.comando.manejador.ManejadorActualizarParqueadero;
import com.ceiba.parqueadero.comando.manejador.ManejadorCrearParqueadero;
import com.ceiba.parqueadero.comando.manejador.ManejadorEliminarParqueadero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parqueaderos")
@Api(tags = { "Controlador comando parqueadero"})
public class ComandoControladorParqueadero {

    private final ManejadorCrearParqueadero manejadorCrearParqueadero;
	private final ManejadorEliminarParqueadero manejadorEliminarParqueaderoo;
	private final ManejadorActualizarParqueadero manejadorActualizarParqueadero;

    @Autowired
    public ComandoControladorParqueadero(ManejadorCrearParqueadero manejadorCrearParqueadero,
										 ManejadorEliminarParqueadero manejadorEliminarParqueaderoo,
										 ManejadorActualizarParqueadero manejadorActualizarParqueadero) {
        this.manejadorCrearParqueadero = manejadorCrearParqueadero;
		this.manejadorEliminarParqueaderoo = manejadorEliminarParqueaderoo;
		this.manejadorActualizarParqueadero = manejadorActualizarParqueadero;
    }

    @PostMapping
    @ApiOperation("Crear Parqueadero")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoParqueadero comandoParqueadero) {
        return manejadorCrearParqueadero.ejecutar(comandoParqueadero);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Parqueadero")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarParqueaderoo.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Parqueadero")
	public void actualizar(@RequestBody ComandoParqueadero comandoParqueadero, @PathVariable Long id) {
		comandoParqueadero.setId(id);
		manejadorActualizarParqueadero.ejecutar(comandoParqueadero);
	}
}
