package com.ceiba.parqueadero.servicio;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;


public class ServicioEliminarParqueadero {

    private final RepositorioParqueadero repositorioParqueadero;
    private static final String EL_PARQUEAERO_NO_EXISTE_EN_EL_SISTEMA = "El parqueadero no existe en el sistema";

    public ServicioEliminarParqueadero(RepositorioParqueadero repositorioParqueadero) {
        this.repositorioParqueadero = repositorioParqueadero;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioParqueadero.eliminarParqueadero(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioParqueadero.existeParqueadero(id);
        if(!existe) {
            throw new ExcepcionSinDatos(EL_PARQUEAERO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
