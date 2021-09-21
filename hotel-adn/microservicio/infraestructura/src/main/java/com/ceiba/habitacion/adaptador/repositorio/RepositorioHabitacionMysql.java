package com.ceiba.habitacion.adaptador.repositorio;
import com.ceiba.habitacion.adaptador.dao.MapeoHabitacion;
import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioHabitacionMysql implements RepositorioHabitacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="habitacion", value="crear")
    private static String sqlCrearHabitacion;

    @SqlStatement(namespace="habitacion", value="actualizar")
    private static String sqlActualizarHabitacion;

    @SqlStatement(namespace="habitacion", value="eliminar")
    private static String sqlEliminarHabitacion;

    @SqlStatement(namespace="habitacion", value="existe")
    private static String sqlExisteHabitacion;

    @SqlStatement(namespace="habitacion", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoIdHabitacion;

    @SqlStatement(namespace = "habitacion", value = "listarPorTipo")
    private static String sqlListarTipoHabitacion;

    @SqlStatement(namespace = "habitacion", value = "obtenerHabitacionDisponible")
    private static String sqlObtenerHabitacionDisponibleHabitacion;

    @SqlStatement(namespace = "habitacion", value = "actualizarDisponibilidad")
    private static String sqlactualizarDisponibilidadHabitacion;

    public RepositorioHabitacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearHabitacion(Habitacion habitacion) {
        return this.customNamedParameterJdbcTemplate.crear(habitacion, sqlCrearHabitacion);
    }

    @Override
    public void eliminarHabitacion(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarHabitacion, paramSource);
    }

    @Override
    public boolean existeHabitacion(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteHabitacion,paramSource, Boolean.class);
    }

    @Override
    public void actualizarHabitacion(Habitacion habitacion) {
        this.customNamedParameterJdbcTemplate.actualizar(habitacion, sqlActualizarHabitacion);
    }

    @Override
    public boolean existeExcluyendoIdHabitacion(Long id, Long tipo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("tipo", tipo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdHabitacion,paramSource, Boolean.class);
    }

    @Override
    public List<DtoHabitacion> listarPorTipoHabitacion() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarTipoHabitacion, new MapeoHabitacion());
    }

    @Override
    public Long obtenerHabitacionDisponibleHabitacion(String tipo) {
            MapSqlParameterSource paramSource = new MapSqlParameterSource();
            paramSource.addValue("nombre", tipo);
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerHabitacionDisponibleHabitacion, paramSource, Long.class);
    }

    @Override
    public void actualizarDisponibilidadHabitacion(Long id, String disponible) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("disponible", disponible);
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlactualizarDisponibilidadHabitacion, paramSource);
    }
}
