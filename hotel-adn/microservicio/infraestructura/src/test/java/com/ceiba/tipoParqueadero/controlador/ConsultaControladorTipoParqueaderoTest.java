package com.ceiba.tipoParqueadero.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tipoparqueadero.controlador.ConsultaControladorTipoParqueadero;
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
@WebMvcTest(ConsultaControladorTipoParqueadero.class)
public class ConsultaControladorTipoParqueaderoTest {
    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarTipoParqueaderoTest() throws Exception{
        // arrange
        // act - assert

        mocMvc.perform(get("/tipoparqueadero")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("carro")))
                .andExpect(jsonPath("$[0].descripcion", is("carro")))
                .andExpect(jsonPath("$[0].precio", is(3000.0)));

    }
}
