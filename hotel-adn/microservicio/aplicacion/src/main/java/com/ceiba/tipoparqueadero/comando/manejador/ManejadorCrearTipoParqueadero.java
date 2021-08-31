package com.ceiba.tipoparqueadero.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.tipoparqueadero.comando.ComandoTipoParqueadero;
import com.ceiba.tipoparqueadero.comando.fabrica.FabricaTipoParqueadero;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioCrearTipoParqueadero;

import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearTipoParqueadero implements ManejadorComandoRespuesta<ComandoTipoParqueadero, ComandoRespuesta<Long>> {

    private final FabricaTipoParqueadero fabricaTipoParqueadero;
    private final ServicioCrearTipoParqueadero servicioCrearTipoParqueadero;

    public ManejadorCrearTipoParqueadero(FabricaTipoParqueadero fabricaTipoParqueadero, ServicioCrearTipoParqueadero servicioCrearTipoParqueadero) {
        this.fabricaTipoParqueadero = fabricaTipoParqueadero;
        this.servicioCrearTipoParqueadero = servicioCrearTipoParqueadero;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoTipoParqueadero comandoTipoParqueadero) {
        TipoParqueadero tipoParqueadero = this.fabricaTipoParqueadero.crear(comandoTipoParqueadero);
        return new ComandoRespuesta<>(this.servicioCrearTipoParqueadero.ejecutar(tipoParqueadero));
    }
}
