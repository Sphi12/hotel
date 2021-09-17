package com.ceiba.tipoParqueadero.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tipoHabitacion.servicio.testdatabuilder.ComandoTipoHabitacionTestDataBuilder;
import com.ceiba.tipoParqueadero.servicio.testdatabuilder.ComandoTipoParqueaderoTestDataBuilder;
import com.ceiba.tipohabitacion.comando.ComandoTipoHabitacion;
import com.ceiba.tipohabitacion.controlador.ComandoControladorTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.tipohabitacion.puerto.dao.DaoTipoHabitacion;
import com.ceiba.tipoparqueadero.comando.ComandoTipoParqueadero;
import com.ceiba.tipoparqueadero.controlador.ComandoControladorTipoParqueadero;
import com.ceiba.tipoparqueadero.modelo.dto.DtoTipoParqueadero;
import com.ceiba.tipoparqueadero.puerto.dao.DaoTipoParqueadero;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorTipoParqueadero.class)
public class ComandoControladorTipoParqueaderoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoTipoParqueadero daoTipoParqueadero;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoTipoParqueadero comandoTipoParqueadero = new ComandoTipoParqueaderoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/tipoparqueadero")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoTipoParqueadero)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"))
                .andDo(
                        resultValorar -> {
                            List<DtoTipoParqueadero> parqueaderoList = daoTipoParqueadero.listar();
                            int count = 0;
                            for (DtoTipoParqueadero tipoParqueadero:
                                    parqueaderoList) {
                                if(tipoParqueadero.getId().equals(comandoTipoParqueadero.getId())){
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
        mocMvc.perform(delete("/tipoparqueadero/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(
                        resultValorar -> {
                            List<DtoTipoParqueadero> parqueaderoList = daoTipoParqueadero.listar();
                            int count = 0;
                            for (DtoTipoParqueadero tipoParqueadero:
                                    parqueaderoList) {
                                if(tipoParqueadero.getId().equals(id)){
                                    count ++;
                                }
                            }
                            assertEquals(0, count);
                        }
                );
    }
}
