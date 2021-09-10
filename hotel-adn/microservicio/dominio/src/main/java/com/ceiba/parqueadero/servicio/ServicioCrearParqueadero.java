package com.ceiba.parqueadero.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;


public class ServicioCrearParqueadero {
    private static final String EL_PARQUEADERO_YA_EXISTE_EN_EL_SISTEMA = "El parqueadero ya existe en el sistema";

    private final RepositorioParqueadero repositorioParqueadero;

    public ServicioCrearParqueadero(RepositorioParqueadero repositorioParqueadero) {
        this.repositorioParqueadero = repositorioParqueadero;
    }

    public Long ejecutar(Parqueadero parqueadero) {
        validarExistenciaPrevia(parqueadero);
        return this.repositorioParqueadero.crearParqueadero(parqueadero);
    }

    private void validarExistenciaPrevia(Parqueadero parqueadero) {
        boolean existe = this.repositorioParqueadero.existeParqueadero(parqueadero.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PARQUEADERO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
