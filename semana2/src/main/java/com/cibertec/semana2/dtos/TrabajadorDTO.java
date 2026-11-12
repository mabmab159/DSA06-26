package com.cibertec.semana2.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

@Data //Setter, getter, toString, HashCod, All
@NoArgsConstructor
@AllArgsConstructor
public class TrabajadorDTO {
    private Long id;
    @NotBlank //{"nombre": ""}
    @NotNull //{"nombre": null}
    @NotEmpty //{"nombre": "      "}
    private String nombres;
    @Min(value = 4, message = "La longitud minima es 4")
    @Max(value = 250, message = "La longitud maxima es 250")
    private String apellidos;
    @Email // xxxx@xxx.xx
    private String correo;
    private RolEnum rol;
}
