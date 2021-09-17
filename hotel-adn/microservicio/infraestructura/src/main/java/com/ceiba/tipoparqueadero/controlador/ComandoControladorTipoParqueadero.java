package com.ceiba.tipoparqueadero.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tipoparqueadero.comando.ComandoTipoParqueadero;
import com.ceiba.tipoparqueadero.comando.manejador.ManejadorCrearTipoParqueadero;
import com.ceiba.tipoparqueadero.comando.manejador.ManejadorEliminarTipoParqueadero;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoparqueadero")
@Api(tags = { "Controlador comando tipo parqueadero"})
public class ComandoControladorTipoParqueadero {

    private final ManejadorCrearTipoParqueadero manejadorCrearTipoParqueadero;
	private final ManejadorEliminarTipoParqueadero manejadorEliminarTipoParqueadero;

    @Autowired
    public ComandoControladorTipoParqueadero(ManejadorCrearTipoParqueadero manejadorCrearHabitacion,
											 ManejadorEliminarTipoParqueadero manejadorEliminarHabitacion) {
        this.manejadorCrearTipoParqueadero = manejadorCrearHabitacion;
		this.manejadorEliminarTipoParqueadero = manejadorEliminarHabitacion;
    }

    @PostMapping
    @ApiOperation("Crear habitacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTipoParqueadero comandoTipoParqueadero) {
        return manejadorCrearTipoParqueadero.ejecutar(comandoTipoParqueadero);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar habitacion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarTipoParqueadero.ejecutar(id);
	}

}
