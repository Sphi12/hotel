package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="reserva", value="crear")
    private static String sqlCrearReserva;

    @SqlStatement(namespace="reserva", value="actualizar")
    private static String sqlActualizarReserva;

    @SqlStatement(namespace="reserva", value="eliminar")
    private static String sqlEliminarReserva;

    @SqlStatement(namespace="reserva", value="existe")
    private static String sqlExisteReserva;

    @SqlStatement(namespace="reserva", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoIdReserva;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearReserva(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrearReserva);
    }

    @Override
    public void eliminarReserva(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarReserva, paramSource);
    }

    @Override
    public boolean existeReserva(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteReserva,paramSource, Boolean.class);
    }

    @Override
    public void actualizarReserva(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizarReserva);
    }

    @Override
    public boolean existeExcluyendoIdReserva(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdReserva,paramSource, Boolean.class);
    }
}
