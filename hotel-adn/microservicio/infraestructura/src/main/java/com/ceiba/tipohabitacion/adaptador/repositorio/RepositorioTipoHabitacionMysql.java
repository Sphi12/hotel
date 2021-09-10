package com.ceiba.tipohabitacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipohabitacion.adaptador.dao.MapeoTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.entidad.TipoHabitacion;
import com.ceiba.tipohabitacion.puerto.repositorio.RepositorioTipoHabitacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoHabitacionMysql implements RepositorioTipoHabitacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipohabitacion", value="crear")
    private static String sqlCrearTHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="actualizar")
    private static String sqlActualizarTHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="eliminar")
    private static String sqlEliminarTHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="existe")
    private static String sqlExisteTHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoIdTHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="obtenerPorId")
    private static String sqlObtenerPorIdTHabitacion;

    public RepositorioTipoHabitacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearTHabitacion(TipoHabitacion tipoHabitacion) {
        return this.customNamedParameterJdbcTemplate.crear(tipoHabitacion, sqlCrearTHabitacion);
    }

    @Override
    public void eliminarTHabitacion(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarTHabitacion, paramSource);
    }

    @Override
    public boolean existeTHabitacion(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTHabitacion,paramSource, Boolean.class);
    }

    @Override
    public void actualizarTHabitacion(TipoHabitacion tipoHabitacion) {
        this.customNamedParameterJdbcTemplate.actualizar(tipoHabitacion, sqlActualizarTHabitacion);
    }

    @Override
    public boolean existeExcluyendoIdTHabitacion(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdTHabitacion,paramSource, Boolean.class);
    }

    @Override
    public List<DtoTipoHabitacion> obtenerPorIdTHabitacion(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPorIdTHabitacion, paramSource, new MapeoTipoHabitacion());
    }
}
