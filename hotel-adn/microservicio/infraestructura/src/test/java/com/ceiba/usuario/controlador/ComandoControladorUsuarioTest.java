package com.ceiba.usuario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.ceiba.ApplicationMock;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoUsuarioTestDataBuilder;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorUsuario.class)
public class ComandoControladorUsuarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoUsuario daoUsuario;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder()
                .conId(3l).conNombre("Pepito").build();

        // act - assert
        mocMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}")).andDo(
                        resultValorar -> {
                            List<DtoUsuario> usuarioList = daoUsuario.listar();
                            int count = 0;
                            for (DtoUsuario dtoUsuario :
                                    usuarioList) {
                                if (dtoUsuario.getId().equals(usuario.getId())) {
                                    count++;
                                }
                            }
                            assertEquals(1, count);
                        }
                );
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 109L;
        ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder().
                conId(id).conNombre("SOphiaV ").build();

        // act - assert
        mocMvc.perform(put("/usuarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andDo(
                        resultValorar -> {
                            List<DtoUsuario> usuarioList = daoUsuario.listar();
                            for (DtoUsuario dtoUsuario :
                                    usuarioList) {
                                if (dtoUsuario.getId().equals(usuario.getId())) {
                                    assertEquals(dtoUsuario.getNombre(), usuario.getNombre());                                }
                            }
                        }
                );
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 3L;

        // act - assert
        mocMvc.perform(delete("/usuarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(
                        resultValorar -> {
                            List<DtoUsuario> usuarioList = daoUsuario.listar();
                            int count = 0;
                            for (DtoUsuario dtoUsuario :
                                    usuarioList) {
                                if (dtoUsuario.getId().equals(id)) {
                                    count++;
                                }
                            }
                            assertEquals(0, count);
                        }
                );
    }
}
