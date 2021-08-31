package com.ceiba.habitacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.habitacion.comando.manejador.ManejadorActualizarHabitacion;
import com.ceiba.habitacion.comando.manejador.ManejadorCrearHabitacion;
import com.ceiba.habitacion.comando.manejador.ManejadorEliminarHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/habitaciones")
@Api(tags = { "Controlador comando habitacion"})
public class ComandoControladorHabitacion {

    private final ManejadorCrearHabitacion manejadorCrearHabitacion;
	private final ManejadorEliminarHabitacion manejadorEliminarHabitacion;
	private final ManejadorActualizarHabitacion manejadorActualizarHabitacion;

    @Autowired
    public ComandoControladorHabitacion(ManejadorCrearHabitacion manejadorCrearHabitacion,
										ManejadorEliminarHabitacion manejadorEliminarHabitacion,
										ManejadorActualizarHabitacion manejadorActualizarHabitacion) {
        this.manejadorCrearHabitacion = manejadorCrearHabitacion;
		this.manejadorEliminarHabitacion = manejadorEliminarHabitacion;
		this.manejadorActualizarHabitacion = manejadorActualizarHabitacion;
    }

    @PostMapping
    @ApiOperation("Crear habitacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoHabitacion comandoHabitacion) {
        return manejadorCrearHabitacion.ejecutar(comandoHabitacion);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar habitacion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarHabitacion.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar habitacion")
	public void actualizar(@RequestBody ComandoHabitacion comandoHabitacion, @PathVariable Long id) {
		comandoHabitacion.setId(id);
		manejadorActualizarHabitacion.ejecutar(comandoHabitacion);
	}
}
