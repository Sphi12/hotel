package com.ceiba.habitacion.adaptador.repositorio;
import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.modelo.entidad.Habitacion;
import com.ceiba.habitacion.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoHabitacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioHabitacionMysql implements RepositorioHabitacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="habitacion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="habitacion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="habitacion", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="habitacion", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="habitacion", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "habitacion", value = "listarPorTipo")
    private static String sqlListarTipo;

    @SqlStatement(namespace = "habitacion", value = "obtenerHabitacionDisponible")
    private static String sqlObtenerHabitacionDisponible;

    @SqlStatement(namespace = "habitacion", value = "actualizarDisponibilidad")
    private static String sqlactualizarDisponibilidad;

    public RepositorioHabitacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Habitacion habitacion) {
        return this.customNamedParameterJdbcTemplate.crear(habitacion, sqlCrear);
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
    public void actualizar(Habitacion habitacion) {
        this.customNamedParameterJdbcTemplate.actualizar(habitacion, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long tipo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("tipo", tipo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    @Override
    public List<DtoHabitacion> listarPorTipo() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarTipo, new MapeoHabitacion());
    }

    @Override
    public Long obtenerHabitacionDisponible(String tipo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", tipo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerHabitacionDisponible, paramSource, Long.class);
    }

    @Override
    public void actualizarDisponibilidad(Long id, String disponible) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("disponible", disponible);
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlactualizarDisponibilidad, paramSource);
    }
}
