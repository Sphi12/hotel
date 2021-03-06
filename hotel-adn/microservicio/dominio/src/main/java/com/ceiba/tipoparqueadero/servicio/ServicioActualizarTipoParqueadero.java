package com.ceiba.tipoparqueadero.servicio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;


public class ServicioActualizarTipoParqueadero {

    private static final String EL_TIPO_PARQUEADERO_YA_EXISTE_EN_EL_SISTEMA = "El tipo parqueadero no existe en el sistema";

    private final RepositorioTipoParqueadero repositorioTipoParqueadero;

    public ServicioActualizarTipoParqueadero(RepositorioTipoParqueadero repositorioTipoParqueadero) {
        this.repositorioTipoParqueadero = repositorioTipoParqueadero;
    }

    public void ejecutar(TipoParqueadero tipoParqueadero) {
        validarExistenciaPrevia(tipoParqueadero);
        this.repositorioTipoParqueadero.actualizarTParqueadero(tipoParqueadero);
    }

    private void validarExistenciaPrevia(TipoParqueadero tipoParqueadero) {
        boolean existe = this.repositorioTipoParqueadero.existeTParqueadero(tipoParqueadero.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_TIPO_PARQUEADERO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
