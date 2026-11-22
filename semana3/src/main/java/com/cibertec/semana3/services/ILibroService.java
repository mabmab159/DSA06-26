package com.cibertec.semana3.services;

import com.cibertec.semana3.models.LibroDTO;

import java.util.List;

public interface ILibroService {
    List<LibroDTO> getAllLibros();
    LibroDTO saveLibro(LibroDTO libroDTO);
    LibroDTO getLibro(Long id);
}
