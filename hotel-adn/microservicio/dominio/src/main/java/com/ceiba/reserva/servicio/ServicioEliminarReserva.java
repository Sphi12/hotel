package com.ceiba.reserva.servicio;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioEliminarReserva {

    private final RepositorioReserva repositorioReserva;
    private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "la reserva no existe en el sistema";

    public ServicioEliminarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioReserva.eliminarReserva(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioReserva.existeReserva(id);
        if(!existe) {
            throw new ExcepcionSinDatos(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
