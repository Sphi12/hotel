package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="crear")
    private static String sqlCrearUsuario;

    @SqlStatement(namespace="usuario", value="actualizar")
    private static String sqlActualizarUsuario;

    @SqlStatement(namespace="usuario", value="eliminar")
    private static String sqlEliminarUsuario;

    @SqlStatement(namespace="usuario", value="existe")
    private static String sqlExisteUsuario;

    @SqlStatement(namespace="usuario", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoIdUsuario;

    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearUsuario(Usuario usuario) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlCrearUsuario);
        return usuario.getId();
    }

    @Override
    public void eliminarUsuario(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarUsuario, paramSource);
    }

    @Override
    public boolean existeUsuario(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteUsuario,paramSource, Boolean.class);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizarUsuario);
    }

    @Override
    public boolean existeExcluyendoIdUsuario(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdUsuario,paramSource, Boolean.class);
    }
}
