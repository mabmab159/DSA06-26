package com.cibertec.semana1.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AlumnoDTO {
    private String nombre;
    private String apellido;
    private String carrera;

    public static AlumnoDTO transform(Alumno alumno){
        return AlumnoDTO.builder()
                .nombre(alumno.getNombre())
                .apellido(alumno.getApellido())
                .carrera(alumno.getCarrera())
                .build();
    }
}
