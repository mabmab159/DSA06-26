package com.cibertec.semana1.controllers;

import com.cibertec.semana1.services.ISemana1Service;
import com.cibertec.semana1.services.Semana1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/semana1") //Define la ruta base
public class Semana1 {
    //Se prohibe el uso de Autowired, -5 puntos
    private final ISemana1Service iSemana1Service;

    public Semana1(ISemana1Service iSemana1Service){
        this.iSemana1Service = iSemana1Service;
    }

    @GetMapping("/1")
    public String holaMundo(){
        return "Hola Mundo";
    }

    @GetMapping("/2")
    public ResponseEntity<String> holaMundo2(){ //Utilizar una interfaz generica de tipo ResponseEntity
        return ResponseEntity.status(201).body("Hola Mundo 2");
    }

    @PostMapping
    public ResponseEntity<String> crearObjeto(){
        return ResponseEntity.status(201).body("Objeto creado");
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<String>> filtrarAlumnos(){
        List<String> alumnos = List.of("Juan", "Pedro", "Maria");
        //Objetivo retornar todos los alumnos que empiecen con la letra J;
        return ResponseEntity.ok(alumnos.stream()
                .filter(alumno -> alumno.startsWith("J")).toList());
    }

    @GetMapping("/filtro2")
    public ResponseEntity<List<String>> filtrarServicios(){
        return ResponseEntity.ok(iSemana1Service.listadoAlumnos());
    }
}
