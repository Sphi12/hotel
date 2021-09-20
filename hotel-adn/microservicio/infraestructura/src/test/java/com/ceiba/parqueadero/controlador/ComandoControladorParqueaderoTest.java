package com.ceiba.parqueadero.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.parqueadero.comando.ComandoParqueadero;
import com.ceiba.parqueadero.servicio.testdatabuilder.ComandoParqueaderoTestDataBuilder;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorParqueadero.class)
public class ComandoControladorParqueaderoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;


    @Test
    public void crear() throws Exception{
        // arrange
        ComandoParqueadero comandoParqueadero = new ComandoParqueaderoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/parqueaderos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoParqueadero)))
                .andExpect(status().is5xxServerError());
            //    .andExpect(content().json("{'valor': 2}"));

    }


    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 5L;
        ComandoParqueadero comandoParqueadero = new ComandoParqueaderoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/parqueaderos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoParqueadero)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 3L;

        // act - assert
        mocMvc.perform(delete("/parqueaderos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
