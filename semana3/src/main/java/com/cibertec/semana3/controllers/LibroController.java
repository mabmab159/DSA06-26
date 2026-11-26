package com.cibertec.semana3.controllers;

import com.cibertec.semana3.configuration.LibroModelAssembler;
import com.cibertec.semana3.models.LibroDTO;
import com.cibertec.semana3.services.ILibroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
@RequiredArgsConstructor
public class LibroController {
    private final ILibroService iLibroService;
    private final LibroModelAssembler libroModelAssembler;

    @GetMapping("/all")
    public ResponseEntity<List<LibroDTO>> getAllLibros(){
        return ResponseEntity.ok(iLibroService.getAllLibros()) ;
    }

    @PostMapping
    public ResponseEntity<LibroDTO> saveLibro(@Valid @RequestBody LibroDTO libroDTO){
        return ResponseEntity.status(201)
                .body(iLibroService.saveLibro(libroDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<LibroDTO>> getLibro(@PathVariable Long id){
        var response = iLibroService.getLibro(id);
        return ResponseEntity.ok(libroModelAssembler.toModel(response));
    }
}
