package com.ceiba.parqueadero.servicio.testdatabuilder;

import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.reserva.modelo.entidad.Reserva;

public class ParqueaderoTestDataBuilder {

    private Long id;
    private Long idTipoParqueadero;
    private boolean disponible;


    public ParqueaderoTestDataBuilder() {
        id = 1L;
        idTipoParqueadero = 1L;
        disponible = true;
    }

    public ParqueaderoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Parqueadero build() {
        return new Parqueadero(id, idTipoParqueadero, disponible);
    }
}
