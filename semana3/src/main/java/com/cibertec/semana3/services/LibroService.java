package com.cibertec.semana3.services;

import com.cibertec.semana3.models.LibroDTO;
import com.cibertec.semana3.models.LibroEntity;
import com.cibertec.semana3.repositories.ILibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibroService implements ILibroService {
    private final ObjectMapper objectMapper;
    private final ILibroRepository iLibroRepository;

    @Override
    public List<LibroDTO> getAllLibros() {
        return iLibroRepository.findAll()
                .stream()
                .map(p -> objectMapper.convertValue(p, LibroDTO.class))
                .toList();
    }

    @Override
    public LibroDTO saveLibro(LibroDTO libroDTO) {
        var response = iLibroRepository.save(objectMapper.convertValue(libroDTO, LibroEntity.class));
        return libroDTO;
    }

    @Override
    public LibroDTO getLibro(Long id) {
         Optional<LibroEntity> response = iLibroRepository.findById(id);
         if(response.isPresent()){
             return objectMapper.convertValue(response.get(), LibroDTO.class);
         }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el libro");
    }
}
