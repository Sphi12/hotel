package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDate;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private String clave;
    private LocalDate fechaCreacion;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        clave = "1234";
        fechaCreacion = LocalDate.now();
    }

    public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombreUsuario, clave,fechaCreacion);
    }
}
