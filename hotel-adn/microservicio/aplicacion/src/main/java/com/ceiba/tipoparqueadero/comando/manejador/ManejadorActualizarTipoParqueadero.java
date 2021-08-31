package com.ceiba.tipoparqueadero.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.tipoparqueadero.comando.ComandoTipoParqueadero;
import com.ceiba.tipoparqueadero.comando.fabrica.FabricaTipoParqueadero;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.servicio.ServicioActualizarTipoParqueadero;
import org.springframework.stereotype.Component;


@Component
public class ManejadorActualizarTipoParqueadero implements ManejadorComando<ComandoTipoParqueadero> {

    private final FabricaTipoParqueadero fabricaTipoParqueadero ;
    private final ServicioActualizarTipoParqueadero servicioActualizarTipoParqueadero;

    public ManejadorActualizarTipoParqueadero(FabricaTipoParqueadero fabricaTipoParqueadero, ServicioActualizarTipoParqueadero servicioActualizarTipoParqueadero) {
        this.fabricaTipoParqueadero = fabricaTipoParqueadero;
        this.servicioActualizarTipoParqueadero = servicioActualizarTipoParqueadero;
    }

    public void ejecutar(ComandoTipoParqueadero comandoTipoParqueadero) {
        TipoParqueadero tipoParqueadero = this.fabricaTipoParqueadero.crear(comandoTipoParqueadero);
        this.servicioActualizarTipoParqueadero.ejecutar(tipoParqueadero);
    }
}
