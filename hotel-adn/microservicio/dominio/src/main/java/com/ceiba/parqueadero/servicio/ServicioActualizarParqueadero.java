package com.ceiba.parqueadero.servicio;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;



public class ServicioActualizarParqueadero {

    private static final String EL_PARQUEAERO_NO_EXISTE_EN_EL_SISTEMA = "El parqueadero no existe en el sistema";

    private final RepositorioParqueadero repositorioParqueadero;

    public ServicioActualizarParqueadero(RepositorioParqueadero repositorioParqueadero) {
        this.repositorioParqueadero = repositorioParqueadero;
    }

    public void ejecutar(Parqueadero parqueadero) {
        validarExistenciaPrevia(parqueadero);
        this.repositorioParqueadero.actualizarParqueadero(parqueadero);
    }

    private void validarExistenciaPrevia(Parqueadero parqueadero) {
        boolean existe = this.repositorioParqueadero.existeParqueadero(parqueadero.getId());
        if(!existe) {
            throw new ExcepcionSinDatos(EL_PARQUEAERO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
