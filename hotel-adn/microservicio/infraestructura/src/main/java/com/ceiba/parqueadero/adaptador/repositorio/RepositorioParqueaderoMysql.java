package com.ceiba.parqueadero.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parqueadero.modelo.entidad.Parqueadero;
import com.ceiba.parqueadero.puerto.repositorio.RepositorioParqueadero;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioParqueaderoMysql implements RepositorioParqueadero {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="parqueadero", value="crear")
    private static String sqlCrearParqueadero;

    @SqlStatement(namespace="parqueadero", value="actualizar")
    private static String sqlActualizarParqueadero;

    @SqlStatement(namespace="parqueadero", value="eliminar")
    private static String sqlEliminarParqueadero;

    @SqlStatement(namespace="parqueadero", value="existe")
    private static String sqlExisteParqueadero;

    @SqlStatement(namespace="parqueadero", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoIdParqueadero;

    @SqlStatement(namespace = "parqueadero", value = "obtenerParqueaderoDisponible")
    private static String sqlObtenerParqueaderoDisponible;

    public RepositorioParqueaderoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearParqueadero(Parqueadero parqueadero) {
        return this.customNamedParameterJdbcTemplate.crear(parqueadero, sqlCrearParqueadero);
    }

    @Override
    public void eliminarParqueadero(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarParqueadero, paramSource);
    }

    @Override
    public boolean existeParqueadero(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteParqueadero,paramSource, Boolean.class);
    }

    @Override
    public void actualizarParqueadero(Parqueadero parqueadero) {
        this.customNamedParameterJdbcTemplate.actualizar(parqueadero, sqlActualizarParqueadero);
    }

    @Override
    public boolean existeExcluyendoIdParqueadero(Long id, Long idTipoParqueadero) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("id_tipo", idTipoParqueadero);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdParqueadero,paramSource, Boolean.class);
    }

    @Override
    public Long obtenerParqueaderoDisponibleParqueadero(String tipo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", tipo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerParqueaderoDisponible, paramSource, Long.class);
    }
}
