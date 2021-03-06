package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private LocalDate fechaCreacion;

    public ComandoUsuarioTestDataBuilder() {
        clave = "1234";
        fechaCreacion = LocalDate.now();
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre, clave,fechaCreacion);
    }
}
