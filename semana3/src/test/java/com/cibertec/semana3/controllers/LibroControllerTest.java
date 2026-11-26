package com.cibertec.semana3.controllers;

import com.cibertec.semana3.configuration.LibroModelAssembler;
import com.cibertec.semana3.services.ILibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibroController.class)
class LibroControllerTest {
    @MockitoBean
    private LibroModelAssembler libroModelAssembler;

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ILibroService iLibroService;

    @Test
    void getAllLibros_Status200() throws Exception {
        when(iLibroService.getAllLibros()).thenReturn(List.of());
        mockMvc.perform(get("/api/v1/libro/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(iLibroService).getAllLibros();
    }
}