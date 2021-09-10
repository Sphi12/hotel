package com.ceiba.parqueadero.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.controlador.ConsultaControladorHabitacion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorParqueadero.class)
public class ConsultaControladorParqueaderoTest {
    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarParqueaderoTest() throws Exception{
        // arrange
        // act - assert

        mocMvc.perform(get("/parqueaderos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].idTipoParqueadero", is(1)))
                .andExpect(jsonPath("$[0].disponible", is(true)))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].idTipoParqueadero", is(2)))
                .andExpect(jsonPath("$[1].disponible", is(true)))

                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].idTipoParqueadero", is(3)))
                .andExpect(jsonPath("$[2].disponible", is(true)));


    }

}
