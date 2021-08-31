package com.ceiba.parqueadero.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.parqueadero.comando.ComandoParqueadero;
import com.ceiba.parqueadero.comando.fabrica.FabricaParqueadero;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.servicio.ServicioActualizarParqueadero;

import org.springframework.stereotype.Component;


@Component
public class ManejadorActualizarParqueadero implements ManejadorComando<ComandoParqueadero> {

    private final FabricaParqueadero fabricaParqueadero;
    private final ServicioActualizarParqueadero servicioActualizarParqueadero;

    public ManejadorActualizarParqueadero(FabricaParqueadero fabricaParqueadero, ServicioActualizarParqueadero servicioActualizarParqueadero) {
        this.fabricaParqueadero = fabricaParqueadero;
        this.servicioActualizarParqueadero = servicioActualizarParqueadero;
    }

    public void ejecutar(ComandoParqueadero comandoParqueadero) {
        Parqueadero parqueadero = this.fabricaParqueadero.crear(comandoParqueadero);
        this.servicioActualizarParqueadero.ejecutar(parqueadero);
    }
}
