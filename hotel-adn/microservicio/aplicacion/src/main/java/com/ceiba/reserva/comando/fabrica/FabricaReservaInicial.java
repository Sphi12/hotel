package com.ceiba.reserva.comando.fabrica;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;


@Component
public class FabricaReservaInicial {

    public Reserva crear(ComandoReservaInicial comandoReservaInicial) {
        return new Reserva(
                comandoReservaInicial.getId(),
                comandoReservaInicial.getTipoHabitacion(),
                comandoReservaInicial.getTipoParqueadero(),
                comandoReservaInicial.getIdUsuario(),
                comandoReservaInicial.getFechaIngreso(),
                comandoReservaInicial.getFechaSalida()
        );
    }
}
