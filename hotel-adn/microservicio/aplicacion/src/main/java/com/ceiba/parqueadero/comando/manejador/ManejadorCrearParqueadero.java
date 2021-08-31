package com.ceiba.parqueadero.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.parqueadero.comando.ComandoParqueadero;
import com.ceiba.parqueadero.comando.fabrica.FabricaParqueadero;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.servicio.ServicioCrearParqueadero;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearParqueadero implements ManejadorComandoRespuesta<ComandoParqueadero, ComandoRespuesta<Long>> {

    private final FabricaParqueadero fabricaParqueadero;
    private final ServicioCrearParqueadero servicioCrearParqueadero;

    public ManejadorCrearParqueadero(FabricaParqueadero fabricaParqueadero, ServicioCrearParqueadero servicioCrearParqueadero) {
        this.fabricaParqueadero = fabricaParqueadero;
        this.servicioCrearParqueadero = servicioCrearParqueadero;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoParqueadero comandoParqueadero) {
        Parqueadero parqueadero = this.fabricaParqueadero.crear(comandoParqueadero);
        return new ComandoRespuesta<>(this.servicioCrearParqueadero.ejecutar(parqueadero));
    }
}
