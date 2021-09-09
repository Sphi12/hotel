package com.ceiba.parqueadero.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Parqueadero {

    private static final String SE_DEBE_INGRESAR_ID_TIPO_PARQUEADERO = "Se debe ingresar el id del tipoParqueadero";
    private static final String SE_DEBE_INGRESAR_DISPONIBLE = "Se debe ingresar si el parqueadero esta disponible o no";



    private Long id;
    private Long idTipoParqueadero;
    private boolean disponible;


    public Parqueadero(Long id,Long idTipoParqueadero, boolean disponible) {
        validarObligatorio(disponible, SE_DEBE_INGRESAR_DISPONIBLE);

        this.id = id;
        this.idTipoParqueadero = idTipoParqueadero;
        this.disponible = true;

    }

}
