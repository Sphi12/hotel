package com.ceiba.reserva.comando.fabrica;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;


@Component
public class FabricaReservaInicial {

    public Reserva crear(ComandoReservaInicial comandoReservaInicial) {
        return new Reserva(

                comandoReservaInicial.getId(),
                null,
                comandoReservaInicial.getTipoHabitacion(),
                null,
                comandoReservaInicial.getTipoParqueadero(),
                comandoReservaInicial.getIdUsuario(),
                null,
                comandoReservaInicial.getFechaIngreso(),
                comandoReservaInicial.getFechaSalida(),
                0.0,
                false,
                false
        );

    }

}
