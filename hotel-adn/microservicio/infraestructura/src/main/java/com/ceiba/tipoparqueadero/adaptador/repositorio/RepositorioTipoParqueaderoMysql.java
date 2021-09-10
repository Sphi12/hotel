package com.ceiba.tipoparqueadero.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipoparqueadero.adaptador.dao.MapeoTipoParqueadero;
import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import com.ceiba.tipoparqueadero.modelo.entidad.TipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.repositorio.RepositorioTipoParqueadero;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoParqueaderoMysql implements RepositorioTipoParqueadero {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipoparqueadero", value="crear")
    private static String sqlCrearTParqueadero;

    @SqlStatement(namespace="tipoparqueadero", value="actualizar")
    private static String sqlActualizarTParqueadero;

    @SqlStatement(namespace="tipoparqueadero", value="eliminar")
    private static String sqlEliminarTParqueadero;

    @SqlStatement(namespace="tipoparqueadero", value="existe")
    private static String sqlExisteTParqueadero;

    @SqlStatement(namespace="tipoparqueadero", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoIdTParqueadero;

    @SqlStatement(namespace = "tipoparqueadero", value = "obtenerParqueaderoId")
    private static String sqlObtenerParqueaderoIdTParqueadero;

    public RepositorioTipoParqueaderoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearTParqueadero(TipoParqueadero tipoParqueadero) {
        return this.customNamedParameterJdbcTemplate.crear(tipoParqueadero, sqlCrearTParqueadero);
    }

    @Override
    public void eliminarTParqueadero(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarTParqueadero, paramSource);
    }

    @Override
    public boolean existeTParqueadero(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTParqueadero,paramSource, Boolean.class);
    }

    @Override
    public void actualizarTParqueadero(TipoParqueadero tipoParqueadero) {
        this.customNamedParameterJdbcTemplate.actualizar(tipoParqueadero, sqlActualizarTParqueadero);
    }

    @Override
    public boolean existeExcluyendoIdTParqueadero(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdTParqueadero,paramSource, Boolean.class);
    }

    @Override
    public List<DtoTipoParqueadero> obtenerIdTParqueadero(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerParqueaderoIdTParqueadero, paramSource,new MapeoTipoParqueadero());
    }
}
