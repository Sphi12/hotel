package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.reserva.controlador.ConsultaControladorReserva;
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
@WebMvcTest(ConsultaControladorUsuario.class)
public class ConsultaControladorUsuarioTest {
    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarUsuarioTest() throws Exception{
        // arrange
        // act - assert

        mocMvc.perform(get("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("test")))
                .andExpect(jsonPath("$[0].clave", is("1234")))
                .andExpect(jsonPath("$[0].fechaCreacion", is(LocalDate.now().toString())))


                .andExpect(jsonPath("$[1].id", is(109)))
                .andExpect(jsonPath("$[1].clave", is("1234")))
                .andExpect(jsonPath("$[1].fechaCreacion", is(LocalDate.now().toString())));
        ;
    }
}
