package com.ceiba.tipoparqueadero.comando.fabrica;

import com.ceiba.tipoparqueadero.comando.ComandoTipoParqueadero;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import org.springframework.stereotype.Component;


@Component
public class FabricaTipoParqueadero {

    public TipoParqueadero crear(ComandoTipoParqueadero  comandoTipoParqueadero) {
        return new TipoParqueadero(
                comandoTipoParqueadero.getId(),
                comandoTipoParqueadero.getNombre(),
                comandoTipoParqueadero.getDescripcion(),
                comandoTipoParqueadero.getPrecio()

        );
    }

}
