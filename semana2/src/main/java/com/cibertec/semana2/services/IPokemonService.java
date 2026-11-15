package com.cibertec.semana2.services;

import com.cibertec.semana2.dtos.PokemonDTO;

public interface IPokemonService {
    PokemonDTO getPokemon(Long id);
}
