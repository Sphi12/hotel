package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoReservaInicial;
import com.ceiba.reserva.modelo.entidad.ReservaInicial;
import org.springframework.stereotype.Component;

@Component
public class FabricaReservaInicial {

    public ReservaInicial crear(ComandoReservaInicial comandoReservaInicial) {
        return new ReservaInicial(
                comandoReservaInicial.getId(),
                comandoReservaInicial.getTipoHabitacion(),
                comandoReservaInicial.getTipoParqueadero(),
                comandoReservaInicial.getIdUsuario(),
                comandoReservaInicial.getFechaIngreso(),
                comandoReservaInicial.getFechaSalida()
        );
    }
}
