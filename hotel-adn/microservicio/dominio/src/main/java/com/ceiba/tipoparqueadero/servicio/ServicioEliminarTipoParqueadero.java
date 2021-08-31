package com.ceiba.tipoparqueadero.servicio;

import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;


public class ServicioEliminarTipoParqueadero {
    private final RepositorioTipoParqueadero repositorioTipoParqueadero;

    public ServicioEliminarTipoParqueadero(RepositorioTipoParqueadero repositorioTipoParqueadero) {
        this.repositorioTipoParqueadero = repositorioTipoParqueadero;
    }

    public void ejecutar(Long id) {
        this.repositorioTipoParqueadero.eliminar(id);
    }
}
