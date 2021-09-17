package com.ceiba.tipoHabitacion.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;

import com.ceiba.tipohabitacion.controlador.ConsultaControladorTipoHabitacion;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorTipoHabitacion.class)
public class ConsultaControladorTipoHabitacionTest {
    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarTipoHabitacionTest() throws Exception{
        // arrange
        // act - assert
        mocMvc.perform(get("/tipohabitacion")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("individual")))
                .andExpect(jsonPath("$[0].descripcion", is("Habitacion individual")))
                .andExpect(jsonPath("$[0].precioSemana", is(90000.0)))
                .andExpect(jsonPath("$[0].precioFinSemana", is(110000.0)))
                .andExpect(jsonPath("$[0].capacidadPersonas", is(1)))
                .andExpect(jsonPath("$[0].numeroCamas", is(1)))
                .andExpect(jsonPath("$[0].descripcionCamas", is("1 cama individual")));
        ;
    }

}
