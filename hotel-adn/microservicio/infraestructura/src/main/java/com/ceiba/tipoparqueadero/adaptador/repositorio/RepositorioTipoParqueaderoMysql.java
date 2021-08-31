package com.ceiba.tipoparqueadero.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTipoParqueaderoMysql implements RepositorioTipoParqueadero {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipoparqueadero", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="tipoparqueadero", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="tipoparqueadero", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="tipoparqueadero", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="tipoparqueadero", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioTipoParqueaderoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(TipoParqueadero tipoParqueadero) {
        return this.customNamedParameterJdbcTemplate.crear(tipoParqueadero, sqlCrear);
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
    public void actualizar(TipoParqueadero tipoParqueadero) {
        this.customNamedParameterJdbcTemplate.actualizar(tipoParqueadero, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
