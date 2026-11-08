package com.cibertec.semana1.services;

import com.cibertec.semana1.models.Alumno;

import java.util.List;

public interface ISemana1Service {
    List<String> listadoAlumnos();
    List<Alumno> listaAlumnosObjeto();
    List<Alumno> listaAlumnosObjeto2();
}
