package com.cibertec.semana1.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Alumno {
    private Long id;
    private String nombre;
    private String apellido;
    private String carrera;
}
