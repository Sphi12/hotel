package com.ceiba.tipoparqueadero.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;


public class ServicioCrearTipoParqueadero {

    private static final String EL_TIPO_PARQUEADERO_YA_EXISTE_EN_EL_SISTEMA = "El tipo tipo parqueadero ya existe en el sistema";

    private final RepositorioTipoParqueadero repositorioTipoParqueadero;

    public ServicioCrearTipoParqueadero(RepositorioTipoParqueadero repositorioTipoParqueadero) {
        this.repositorioTipoParqueadero = repositorioTipoParqueadero;
    }

    public Long ejecutar(TipoParqueadero tipoParqueadero) {
        validarExistenciaPrevia(tipoParqueadero);
        return this.repositorioTipoParqueadero.crear(tipoParqueadero);
    }

    private void validarExistenciaPrevia(TipoParqueadero tipoParqueadero) {
        boolean existe = this.repositorioTipoParqueadero.existe(tipoParqueadero.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_PARQUEADERO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
