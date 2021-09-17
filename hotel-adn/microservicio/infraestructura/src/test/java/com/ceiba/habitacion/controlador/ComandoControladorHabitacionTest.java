package com.ceiba.habitacion.controlador;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.ceiba.ApplicationMock;
import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.puerto.dao.DaoHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.ComandoHabitacionTestDataBuilder;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorHabitacion.class)
public class ComandoControladorHabitacionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoHabitacion daoHabitacion;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoHabitacion habitacion = new ComandoHabitacionTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/habitaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(habitacion)))
                .andExpect(status().is5xxServerError());

    }


    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        Long tipoHabitacion = 2L;
        ComandoHabitacion habitacion = new ComandoHabitacionTestDataBuilder().build();
        habitacion.setTipo(tipoHabitacion);
        habitacion.setId(id);

        // act - assert
        mocMvc.perform(put("/habitaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(habitacion)))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 3L;

        // act - assert
        mocMvc.perform(delete("/habitaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(
                        resultValorar -> {
                            List<DtoHabitacion> habitacionList = daoHabitacion.listar();
                            int count = 0;
                            for (DtoHabitacion habitacion :
                                    habitacionList) {
                                if (habitacion.getId().equals(id)) {
                                    count++;
                                }
                            }
                            assertEquals(0, count);
                        }
                );
    }
}
