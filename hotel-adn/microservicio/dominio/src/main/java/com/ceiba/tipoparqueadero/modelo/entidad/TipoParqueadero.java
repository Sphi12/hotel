package com.ceiba.tipoparqueadero.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TipoParqueadero {


    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre del parqueadero";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO = "Se debe ingresar el precio de del parqueadero";



    private Long id;
    private String nombre;
    private String descripción;
    private Double precio;

    public TipoParqueadero(Long id,String nombre, String descripcion,Double precio) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
         validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO);

        this.id = id;
        this.nombre = nombre;
        this.descripción = descripcion;
        this.precio = precio;
    }

}
