package com.ceiba.reserva.controlador;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.ceiba.ApplicationMock;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaInicial;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
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
@WebMvcTest(ComandoControladorReserva.class)
public class ComandoControladorReservaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    @Autowired
    DaoReserva daoReserva ;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoReservaInicial reservaInicial = new com.ceiba.resrva.servicio.testdatabuilder.ComandoReservaInicialTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/reservas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reservaInicial)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }


    @Test
    public void actualizar() throws Exception{
        // arrange
        ComandoReserva reserva = new ComandoReservaTestDataBuilder().build();
        reserva.setFechaSalida(reserva.getFechaIngreso().plusDays(5));
        // act - assert
        mocMvc.perform(put("/reservas/{id}",reserva.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk())
                .andDo(
                        resultValorar -> {
                            DtoReserva updateReservaResponse = daoReserva.obtener(reserva.getId());
                            assertEquals(reserva.getFechaIngreso().plusDays(5), updateReservaResponse.getFechaSalida());
                        }
                );
    }

    @Test
    public void actualizarReservaNoExistente() throws Exception{
        // arrange
        long id = 10000000001l;
        ComandoReserva reserva = new ComandoReservaTestDataBuilder().build();
        reserva.setFechaSalida(reserva.getFechaIngreso().plusDays(5));
        reserva.setId(id);
        // act - assert
        mocMvc.perform(put("/reservas/{id}",reserva.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/reservas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
