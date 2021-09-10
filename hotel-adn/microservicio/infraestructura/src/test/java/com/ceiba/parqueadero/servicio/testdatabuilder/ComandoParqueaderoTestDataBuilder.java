package com.ceiba.parqueadero.servicio.testdatabuilder;

import com.ceiba.parqueadero.comando.ComandoParqueadero;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoParqueaderoTestDataBuilder {

    private Long id;
    private Long idTipoParqueadero;
    private boolean disponible;

    public ComandoParqueaderoTestDataBuilder() {
        id = 5L;
        idTipoParqueadero = 1L;
        disponible = true;
    }

    public ComandoParqueadero build() {

        return new ComandoParqueadero(id, idTipoParqueadero, disponible);
    }
}
