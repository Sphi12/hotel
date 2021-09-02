package com.ceiba.parqueadero.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;
import com.ceiba.usuario.modelo.entidad.Usuario;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioParqueaderoMysql implements RepositorioParqueadero {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="parqueadero", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="parqueadero", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="parqueadero", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="parqueadero", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="parqueadero", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "parqueadero", value = "obtenerParqueaderoDisponible")
    private static String sqlObtenerParqueaderoDisponible;

    public RepositorioParqueaderoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Parqueadero parqueadero) {
        return this.customNamedParameterJdbcTemplate.crear(parqueadero, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Parqueadero parqueadero) {
        this.customNamedParameterJdbcTemplate.actualizar(parqueadero, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long idTipoParqueadero) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("id_tipo", idTipoParqueadero);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    @Override
    public Long obtenerParqueaderoDisponible(String tipo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", tipo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerParqueaderoDisponible, paramSource, Long.class);
    }
}
