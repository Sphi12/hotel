package com.ceiba.parqueadero.comando.fabrica;
import com.ceiba.parqueadero.comando.ComandoParqueadero;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import org.springframework.stereotype.Component;


@Component
public class FabricaParqueadero {

    public Parqueadero crear(ComandoParqueadero comandoParqueadero) {
        return new Parqueadero(
                comandoParqueadero.getId(),
                comandoParqueadero.getIdTipoParqueadero(),
                comandoParqueadero.isDisponible()
        );
    }

}
