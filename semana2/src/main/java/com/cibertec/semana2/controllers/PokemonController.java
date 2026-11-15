package com.cibertec.semana2.controllers;

import com.cibertec.semana2.dtos.PokemonDTO;
import com.cibertec.semana2.services.IPokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {
    private final IPokemonService iPokemonService;

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.ok(iPokemonService.getPokemon(id));
    }
}
