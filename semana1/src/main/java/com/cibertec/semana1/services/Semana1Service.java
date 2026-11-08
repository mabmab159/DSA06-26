package com.cibertec.semana1.services;

import com.cibertec.semana1.models.Alumno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Semana1Service implements ISemana1Service{
    public List<String> listadoAlumnos(){
        return List.of("Juan", "Pedro", "Maria");
    }

    @Override
    public List<Alumno> listaAlumnosObjeto() {
        Alumno alumno1 = Alumno.builder().id(1L).nombre("Miguel").build();
        Alumno alumno2 = Alumno.builder().id(2L).nombre("Juan").apellido("Berrio").build();
        return List.of(alumno1, alumno2);
    }

    @Override
    public List<Alumno> listaAlumnosObjeto2() {
        Alumno alumno1 = Alumno.builder().id(1L).nombre("Miguel").build();
        Alumno alumno2 = Alumno.builder().id(2L).nombre("Juan").apellido("Berrio").build();
        Alumno alumno3 = Alumno.builder().id(3L).nombre("Diego").apellido("Berrio").build();
        Alumno alumno4 = Alumno.builder().id(4L).apellido("Berrio").build();
        return List.of(alumno1, alumno2, alumno3, alumno4);
    }
}
