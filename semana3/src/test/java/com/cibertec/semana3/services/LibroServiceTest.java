package com.cibertec.semana3.services;

import com.cibertec.semana3.models.LibroDTO;
import com.cibertec.semana3.models.LibroEntity;
import com.cibertec.semana3.repositories.ILibroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibroServiceTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private ILibroRepository iLibroRepository;

    @InjectMocks
    private LibroService libroService;

    private LibroDTO libroDto;
    private LibroEntity libroEntity;

    @BeforeEach
    void setUp(){
        libroDto = new LibroDTO();
        libroEntity = new LibroEntity();
    }

    @Test
    void getAllLibros_RetornoDeLibros(){
        when(iLibroRepository.findAll()).thenReturn(List.of(libroEntity, libroEntity));
        when(objectMapper.convertValue(libroEntity, LibroDTO.class)).thenReturn(libroDto);

        List<LibroDTO> resultado = libroService.getAllLibros(); //recuperar(F) - stream - convertir(F) - list
        assertNotNull(resultado); //Validar - No venga nula la lista
        assertEquals(2, resultado.size());
        assertEquals(libroDto, resultado.getFirst());

        verify(iLibroRepository, times(1)).findAll();
        verify(objectMapper, times(2)).convertValue(libroEntity, LibroDTO.class);
    }
}