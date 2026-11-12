package com.cibertec.semana2.services;

import com.cibertec.semana2.dtos.TrabajadorDTO;

import java.util.List;

public interface ITrabajadorService {
    List<TrabajadorDTO> getAllTrabajador();
    TrabajadorDTO getTrabajador(Long id);
    TrabajadorDTO saveTrabajador(TrabajadorDTO trabajadorDTO);
}
