package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import com.ceiba.reserva.comando.fabrica.FabricaReservaInicial;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearReserva implements ManejadorComandoRespuesta<ComandoReservaInicial, ComandoRespuesta<Long>> {

    private final FabricaReservaInicial fabricaReservaInicial;
    private final ServicioCrearReserva servicioCrearReserva;

    public ManejadorCrearReserva(FabricaReservaInicial fabricaReservaInicial, ServicioCrearReserva servicioCrearReserva) {
        this.fabricaReservaInicial = fabricaReservaInicial;
        this.servicioCrearReserva = servicioCrearReserva;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoReservaInicial comandoReservaInicial) {
        System.out.println("COMANDO " + comandoReservaInicial.toString());
        Reserva reserva = this.fabricaReservaInicial.crear(comandoReservaInicial);
        return new ComandoRespuesta<>(this.servicioCrearReserva.ejecutar(reserva));
    }
}
