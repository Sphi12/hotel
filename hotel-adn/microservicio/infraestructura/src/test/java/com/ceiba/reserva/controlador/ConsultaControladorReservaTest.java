package com.ceiba.reserva.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tipohabitacion.controlador.ConsultaControladorTipoHabitacion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorReserva.class)
public class ConsultaControladorReservaTest {
    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarReservaTest() throws Exception{
        // arrange
        // act - assert
        mocMvc.perform(get("/reservas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].idHabitacion", is(1)))
                .andExpect(jsonPath("$[0].tipoHabitacion", is("individual")))
                .andExpect(jsonPath("$[0].idParqueadero", is(1)))
                .andExpect(jsonPath("$[0].tipoParqueadero", is("carro")))
                .andExpect(jsonPath("$[0].idUsuario", is(1)))
                .andExpect(jsonPath("$[0].precioTotal", is(451800.0)))
                .andExpect(jsonPath("$[0].checkIn", is(false)))
                .andExpect(jsonPath("$[0].checkOut", is(false)));
        ;
    }

    @Test
    public void listarReservaIdTest() throws Exception{
        // arrange
        // act - assert
        Long id = 1L;
        mocMvc.perform(get("/reservas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.idHabitacion", is(1)))
                .andExpect(jsonPath("$.tipoHabitacion", is("individual")))
                .andExpect(jsonPath("$.idParqueadero", is(1)))
                .andExpect(jsonPath("$.tipoParqueadero", is("carro")))
                .andExpect(jsonPath("$.idUsuario", is(1)))
                .andExpect(jsonPath("$.precioTotal", is(451800.0)))
                .andExpect(jsonPath("$.checkIn", is(false)))
                .andExpect(jsonPath("$.checkOut", is(false)));

    }
}
