package com.ceiba.tipohabitacion.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipohabitacion.puerto.dao.DaoTipoHabitacion;
import com.ceiba.usuario.adaptador.dao.MapeoTipoHabitacion;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

@Component
public class DaoTipoHabitacionMysql implements DaoTipoHabitacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipohabitacion", value="listar")
    private static String sqlListar;

    public DaoTipoHabitacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DaoTipoHabitacion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTipoHabitacion());
    }
}
