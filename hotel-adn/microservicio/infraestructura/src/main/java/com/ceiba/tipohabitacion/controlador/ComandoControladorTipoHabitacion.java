package com.ceiba.tipohabitacion.controlador;
import com.ceiba.ComandoRespuesta;
import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;
import com.ceiba.tipohabitacion.comando.manejador.ManejadorActualizarTipoHabitacion;
import com.ceiba.tipohabitacion.comando.manejador.ManejadorCrearTipoHabitacion;
import com.ceiba.tipohabitacion.comando.manejador.ManejadorEliminarTipoHabitacion;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tipohabitacion")
@Api(tags = { "Controlador comando tipohabitacion"})
public class ComandoControladorTipoHabitacion {

    private final ManejadorCrearTipoHabitacion manejadorCrearTipoHabitacion;
	private final ManejadorEliminarTipoHabitacion manejadorEliminarTipoHabitacion;
	private final ManejadorActualizarTipoHabitacion manejadorActualizarTipoHabitacion;

    @Autowired
    public ComandoControladorTipoHabitacion(ManejadorCrearTipoHabitacion manejadorCrearTipoHabitacion,
											ManejadorEliminarTipoHabitacion manejadorEliminarTipoHabitacion,
											ManejadorActualizarTipoHabitacion manejadorActualizarTipoHabitacion) {
        this.manejadorCrearTipoHabitacion = manejadorCrearTipoHabitacion;
		this.manejadorEliminarTipoHabitacion = manejadorEliminarTipoHabitacion;
		this.manejadorActualizarTipoHabitacion = manejadorActualizarTipoHabitacion;
    }

    @PostMapping
    @ApiOperation("Crear Tipo habitacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTipoHabitacion comandoTipoHabitacion) {
        return manejadorCrearTipoHabitacion.ejecutar(comandoTipoHabitacion);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Tipo habitacion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarTipoHabitacion.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Tipo habitacion")
	public void actualizar(@RequestBody ComandoTipoHabitacion comandoTipoHabitacion, @PathVariable Long id) {
		comandoTipoHabitacion.setId(id);
		manejadorActualizarTipoHabitacion.ejecutar(comandoTipoHabitacion);
	}
}
