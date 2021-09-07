package com.ceiba.reserva.comando.fabrica;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;


@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva) {
        return new Reserva(
                comandoReserva.getId(),
                comandoReserva.getIdHabitacion(),
                comandoReserva.getTipoHabitacion(),
                comandoReserva.getIdParqueadero(),
                comandoReserva.getTipoParqueadero(),
                comandoReserva.getIdUsuario(),
                comandoReserva.getFechaReserva(),
                comandoReserva.getFechaIngreso(),
                comandoReserva.getFechaSalida(),
                comandoReserva.getPrecioTotal(),
                comandoReserva.isCheckIn(),
                comandoReserva.isCheckOut()
        );

    }

}
