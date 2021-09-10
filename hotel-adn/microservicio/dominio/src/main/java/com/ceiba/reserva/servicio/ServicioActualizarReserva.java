package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class ServicioActualizarReserva {

    private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "la reserva no existe en el sistema";
    private static final String CHEK_IN_PRE_TIEMPO = "El check-in se debe realizar despues de las 2:00 P.M";
    private static final String CHEK_IN_DIA_INCORRECTO = "El check-in debe realizarse el día de ingreso registrado en la reserva";

    private final RepositorioReserva repositorioReserva;
    private final DaoReserva daoReserva;


    public ServicioActualizarReserva(RepositorioReserva repositorioReserva, DaoReserva daoReserva) {
        this.repositorioReserva = repositorioReserva;
        this.daoReserva = daoReserva;
    }

    public void ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        validarCheckIn(daoReserva.obtener(reserva.getId()), reserva);
        this.repositorioReserva.actualizar(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getId());
        if(!existe) {
            throw new ExcepcionSinDatos(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarCheckIn(DtoReserva daoReserva, Reserva reserva){
            if(reserva.isCheckIn() && !daoReserva.isCheckIn()) {
                if (daoReserva.getFechaIngreso().getDayOfMonth() >= LocalDate.now().getDayOfMonth()) {
                    if (LocalDateTime.now().getHour() < 23) {
                        throw new ExcepcionValorInvalido(CHEK_IN_PRE_TIEMPO);
                    }
                } else {
                    throw new ExcepcionValorInvalido(CHEK_IN_DIA_INCORRECTO);
                }
            }
    }
}
