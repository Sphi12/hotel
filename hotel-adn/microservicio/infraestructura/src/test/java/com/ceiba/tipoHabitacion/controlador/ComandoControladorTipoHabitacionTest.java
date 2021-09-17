package com.ceiba.tipoHabitacion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.habitacion.comando.ComandoHabitacion;
import com.ceiba.habitacion.modelo.dto.DtoHabitacion;
import com.ceiba.habitacion.servicio.testdatabuilder.ComandoHabitacionTestDataBuilder;
import com.ceiba.tipoHabitacion.servicio.testdatabuilder.ComandoTipoHabitacionTestDataBuilder;
import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;
import com.ceiba.tipohabitacion.controlador.ComandoControladorTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.tipohabitacion.puerto.dao.DaoTipoHabitacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorTipoHabitacion.class)
public class ComandoControladorTipoHabitacionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoTipoHabitacion daoTipoHabitacion;
    @Test
    public void crear() throws Exception{
        // arrange
        ComandoTipoHabitacion comandoTipoHabitacion = new ComandoTipoHabitacionTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/tipohabitacion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoTipoHabitacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}")).andDo(
                        resultValorar -> {
                            List<DtoTipoHabitacion> updateHabitacionList = daoTipoHabitacion.listar();
                            int count = 0;
                            for (DtoTipoHabitacion habitacionItem:
                                    updateHabitacionList) {
                                if(habitacionItem.getId().equals(comandoTipoHabitacion.getId())){
                                    count ++;
                                }
                            }
                            assertEquals(1, count);
                        }
                );
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/tipohabitacion/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andDo(
                            resultValorar -> {
                                List<DtoTipoHabitacion> updateHabitacionList = daoTipoHabitacion.listar();
                                int count = 0;
                                for (DtoTipoHabitacion habitacionItem:
                                        updateHabitacionList) {
                                    if(habitacionItem.getId().equals(id)){
                                        count ++;
                                    }
                                }
                                assertEquals(0, count);
                            }
                          );
    }
}
