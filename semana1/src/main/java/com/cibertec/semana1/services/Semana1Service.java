package com.cibertec.semana1.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Semana1Service implements ISemana1Service{
    public List<String> listadoAlumnos(){
        return List.of("Juan", "Pedro", "Maria");
    }
}
