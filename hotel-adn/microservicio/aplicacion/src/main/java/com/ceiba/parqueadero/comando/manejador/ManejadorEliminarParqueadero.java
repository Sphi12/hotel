package com.ceiba.parqueadero.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.parqueadero.servicio.ServicioEliminarParqueadero;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarParqueadero implements ManejadorComando<Long> {

    private final ServicioEliminarParqueadero servicioEliminarParqueadero;

    public ManejadorEliminarParqueadero(ServicioEliminarParqueadero servicioEliminarParqueadero) {
        this.servicioEliminarParqueadero = servicioEliminarParqueadero;
    }

    public void ejecutar(Long idParqueadero) {
        this.servicioEliminarParqueadero.ejecutar(idParqueadero);
    }
}
