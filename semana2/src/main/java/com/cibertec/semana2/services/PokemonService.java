package com.cibertec.semana2.services;

import com.cibertec.semana2.dtos.PokemonDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PokemonService implements IPokemonService {

    //RestClient - RestTemplate - WebClient - Feign (Spring Cloud)
    @Override
    public PokemonDTO getPokemon(Long id) {
        RestClient base = RestClient.builder().baseUrl("https://pokeapi.co/api/v2/pokemon/" + id)
                .build();
        var response = base.get().retrieve().body(PokemonDTO.class);
        return response;
    }

    public String concatenarNombreApellido(String nombre, String apellido) {
        //return nombre + " " + apellido; // 1, 2, ..., 1998, 1999, 2000
        //return String.format("%s %s", nombre, apellido);
        //return nombre.concat(" ").concat(apellido);
        StringBuilder nombreCompleto = new StringBuilder(nombre); //1
        nombreCompleto.append(" ").append(apellido);
        return nombreCompleto.toString();
    }
}
