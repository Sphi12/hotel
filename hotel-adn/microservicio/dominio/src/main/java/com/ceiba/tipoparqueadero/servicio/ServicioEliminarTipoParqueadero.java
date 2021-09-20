package com.ceiba.tipoparqueadero.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;


public class ServicioEliminarTipoParqueadero {
    private final RepositorioTipoParqueadero repositorioTipoParqueadero;
    private static final String EL_TIPO_PARQUEADERO_YA_EXISTE_EN_EL_SISTEMA = "El tipo parqueadero no existe en el sistema";

    public ServicioEliminarTipoParqueadero(RepositorioTipoParqueadero repositorioTipoParqueadero) {
        this.repositorioTipoParqueadero = repositorioTipoParqueadero;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioTipoParqueadero.eliminarTParqueadero(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioTipoParqueadero.existeTParqueadero(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_PARQUEADERO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
