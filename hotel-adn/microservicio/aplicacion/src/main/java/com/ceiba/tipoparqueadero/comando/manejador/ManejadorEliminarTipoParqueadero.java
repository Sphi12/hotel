package com.ceiba.tipoparqueadero.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.tipoparqueadero.servicio.ServicioEliminarTipoParqueadero;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarTipoParqueadero implements ManejadorComando<Long> {

    private final ServicioEliminarTipoParqueadero servicioEliminarTipoParqueadero;

    public ManejadorEliminarTipoParqueadero(ServicioEliminarTipoParqueadero servicioEliminarTipoParqueadero) {
        this.servicioEliminarTipoParqueadero = servicioEliminarTipoParqueadero;
    }

    public void ejecutar(Long idTipoParqueadero) {
        this.servicioEliminarTipoParqueadero.ejecutar(idTipoParqueadero);
    }
}
