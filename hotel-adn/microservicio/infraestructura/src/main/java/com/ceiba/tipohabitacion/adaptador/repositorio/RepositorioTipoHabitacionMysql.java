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
    private static String sqlCrearTipoHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="actualizar")
    private static String sqlActualizarTipoHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="eliminar")
    private static String sqlEliminarTipoHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="existe")
    private static String sqlExisteTipoHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoIdTipoHabitacion;

    @SqlStatement(namespace="tipohabitacion", value="obtenerPorId")
    private static String sqlObtenerPorIdTipoHabitacion;

    public RepositorioTipoHabitacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return this.customNamedParameterJdbcTemplate.crear(tipoHabitacion, sqlCrearTipoHabitacion);
    }

    @Override
    public void eliminarTipoHabitacion(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarTipoHabitacion, paramSource);
    }

    @Override
    public boolean existeTipoHabitacion(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTipoHabitacion,paramSource, Boolean.class);
    }

    @Override
    public void actualizarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.customNamedParameterJdbcTemplate.actualizar(tipoHabitacion, sqlActualizarTipoHabitacion);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdTipoHabitacion,paramSource, Boolean.class);
    }

    @Override
    public List<DtoTipoHabitacion> obtenerPorId(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPorIdTipoHabitacion, paramSource, new MapeoTipoHabitacion());
    }
}
