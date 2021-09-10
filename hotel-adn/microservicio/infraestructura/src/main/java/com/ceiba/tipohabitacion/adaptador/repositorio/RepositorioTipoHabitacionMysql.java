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
    private static String sqlCrear;

    @SqlStatement(namespace="tipohabitacion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="tipohabitacion", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="tipohabitacion", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="tipohabitacion", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace="tipohabitacion", value="obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioTipoHabitacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(TipoHabitacion tipoHabitacion) {
        return this.customNamedParameterJdbcTemplate.crear(tipoHabitacion, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(TipoHabitacion tipoHabitacion) {
        this.customNamedParameterJdbcTemplate.actualizar(tipoHabitacion, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    @Override
    public List<DtoTipoHabitacion> obtenerPorId(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPorId, paramSource, new MapeoTipoHabitacion());
    }
}
