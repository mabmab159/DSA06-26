package com.cibertec.semana1.utils;

import java.util.List;

public class ClaseStreams {
    //Stream -> Flujos de datos != Lista de datos
    List<String> nombres = List.of("Miguel", "Juan", "Pepe");

    public void Prueba(){
        nombres.stream() //List -> Stream
                .map(nombre -> nombre.toUpperCase()) //Stream
                .toList();// Stream -> List
    }
}
