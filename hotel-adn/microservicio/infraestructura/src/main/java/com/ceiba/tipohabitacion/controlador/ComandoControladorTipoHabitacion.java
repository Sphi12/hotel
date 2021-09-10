package com.ceiba.tipohabitacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;
import com.ceiba.tipohabitacion.comando.manejador.ManejadorActualizarTipoHabitacion;
import com.ceiba.tipohabitacion.comando.manejador.ManejadorCrearTipoHabitacion;
import com.ceiba.tipohabitacion.comando.manejador.ManejadorEliminarTipoHabitacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipohabitacion")
@Api(tags = { "Controlador comando habitacion"})
public class ComandoControladorTipoHabitacion {

    private final ManejadorCrearTipoHabitacion manejadorCrearTipoHabitacion;
	private final ManejadorEliminarTipoHabitacion manejadorEliminarTipoHabitacion;
	private final ManejadorActualizarTipoHabitacion manejadorActualizarTipoHabitacion;

    @Autowired
    public ComandoControladorTipoHabitacion(ManejadorCrearTipoHabitacion manejadorCrearHabitacion,
											ManejadorEliminarTipoHabitacion manejadorEliminarHabitacion,
											ManejadorActualizarTipoHabitacion manejadorActualizarHabitacion) {
        this.manejadorCrearTipoHabitacion = manejadorCrearHabitacion;
		this.manejadorEliminarTipoHabitacion = manejadorEliminarHabitacion;
		this.manejadorActualizarTipoHabitacion = manejadorActualizarHabitacion;
    }

    @PostMapping
    @ApiOperation("Crear habitacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTipoHabitacion comandoTipoHabitacion) {
        return manejadorCrearTipoHabitacion.ejecutar(comandoTipoHabitacion);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar habitacion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarTipoHabitacion.ejecutar(id);
	}


}
