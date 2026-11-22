package com.cibertec.semana3.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    @NotNull
    private Long id;
    @NotNull(message = "No debe ser nulo")
    @NotEmpty(message = "No debe estar vacio")
    @NotBlank(message = "No debe ser blanco")
    @Length(min = 10, message = "Longitud minima 10")
    private String nombre;
    private String autor;
    private String editorial;
    private LocalDate fechaPublicacion;
}
