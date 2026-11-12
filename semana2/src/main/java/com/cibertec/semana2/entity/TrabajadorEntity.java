package com.cibertec.semana2.entity;

import com.cibertec.semana2.dtos.RolEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table(name = "trabajador")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TrabajadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private RolEnum rol;
}
