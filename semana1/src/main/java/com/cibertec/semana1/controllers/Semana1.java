package com.cibertec.semana1.controllers;

import com.cibertec.semana1.models.Alumno;
import com.cibertec.semana1.models.AlumnoDTO;
import com.cibertec.semana1.services.ISemana1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/semana1") //Define la ruta base
@RequiredArgsConstructor
public class Semana1 {
    //Se prohibe el uso de Autowired, -5 puntos
    private final ISemana1Service iSemana1Service;
    private final ObjectMapper objectMapper;

    @GetMapping("/1")
    public String holaMundo() {
        return "Hola Mundo";
    }

    @GetMapping("/2")
    public ResponseEntity<String> holaMundo2() { //Utilizar una interfaz generica de tipo ResponseEntity
        return ResponseEntity.status(201).body("Hola Mundo 2");
    }

    @PostMapping
    public ResponseEntity<String> crearObjeto() {
        return ResponseEntity.status(201).body("Objeto creado");
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<String>> filtrarAlumnos() {
        List<String> alumnos = List.of("Juan", "Pedro", "Maria");
        //Objetivo retornar todos los alumnos que empiecen con la letra J;
        return ResponseEntity.ok(alumnos.stream()
                .filter(alumno -> alumno.startsWith("J")).toList());
    }

    @GetMapping("/filtro2")
    public ResponseEntity<List<String>> filtrarServicios() {
        return ResponseEntity.ok(iSemana1Service.listadoAlumnos());
    }

    @GetMapping("/alumno")
    public ResponseEntity<Alumno> alumno() {
        return ResponseEntity.ok(new Alumno(1L, "Miguel", "Berrio", "Software"));
    }

    @GetMapping("/alumno2")
    public ResponseEntity<List<AlumnoDTO>> alumnosDTOS() {
        //Solucion 1
        /*return ResponseEntity.ok(iSemana1Service.listaAlumnosObjeto()
                .stream().map(alumno -> AlumnoDTO.builder()
                        .nombre(alumno.getNombre())
                        .apellido(alumno.getApellido())
                        .carrera(alumno.getCarrera())
                        .build()).toList()*/
        //Solucion 2
        /*return ResponseEntity.ok(iSemana1Service.listaAlumnosObjeto()
                .stream()
                .map(AlumnoDTO::transform)
                .toList());*/
        //Solucion 3
        return ResponseEntity.ok(iSemana1Service.listaAlumnosObjeto()
                .stream()
                .map(alumno -> objectMapper.convertValue(alumno, AlumnoDTO.class))
                .toList()
        );
    }

    @GetMapping("/alumno3")
    public ResponseEntity<List<AlumnoDTO>> alumnosDTOS2() {
        List<AlumnoDTO> listaFiltro = iSemana1Service.listaAlumnosObjeto2()
                .stream()
                .filter(alumno -> alumno.getNombre() != null && alumno.getNombre().length() >= 5)
                .map(alumno -> AlumnoDTO.builder()
                        .nombre(alumno.getNombre())
                        .apellido(alumno.getApellido())
                        .carrera(alumno.getCarrera())
                        .build())
                .toList();
        return ResponseEntity.ok(listaFiltro);
    }

    @GetMapping("/alumno4")
    public ResponseEntity<List<AlumnoDTO>> alumnosDTOS3() {
        return ResponseEntity.ok(iSemana1Service.listaAlumnosObjeto2()
                .stream()
                .filter(alumno -> alumno.getNombre()!=null && alumno.getNombre().startsWith("M"))
                .map(alumno -> objectMapper.convertValue(alumno, AlumnoDTO.class))
                .toList());
    }

    @GetMapping("/alumno5")
    public ResponseEntity<List<AlumnoDTO>> alumnosDTOS4() {
        //Filtres los que su nombre es Miguel
        return ResponseEntity.ok(iSemana1Service.listaAlumnosObjeto2()
                .stream()
                .filter(alumno -> "Miguel".equals(alumno.getNombre()))
                .map(alumno -> objectMapper.convertValue(alumno, AlumnoDTO.class))
                .toList());
    }
}
