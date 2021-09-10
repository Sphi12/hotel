package com.ceiba.parqueadero.servicio;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;


public class ServicioEliminarParqueadero {

    private final RepositorioParqueadero repositorioParqueadero;

    public ServicioEliminarParqueadero(RepositorioParqueadero repositorioParqueadero) {
        this.repositorioParqueadero = repositorioParqueadero;
    }

    public void ejecutar(Long id) {
        this.repositorioParqueadero.eliminarParqueadero(id);
    }
}
