package com.cibertec.semana2.controllers;

import com.cibertec.semana2.dtos.TrabajadorDTO;
import com.cibertec.semana2.services.ITrabajadorService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajador")
@RequiredArgsConstructor
public class TrabajadorController {
    private final ITrabajadorService iTrabajadorService;

    @GetMapping("/all")
    public ResponseEntity<List<TrabajadorDTO>> getAllTrabajador(){
        return ResponseEntity.ok(iTrabajadorService.getAllTrabajador());
    }

    @GetMapping("/{id}") // /alumno/5 <=Estas devolviendo un recurso | /alumno?ciclo=4&apellido=B <=Filtro
    public ResponseEntity<TrabajadorDTO> getTrabajador(@PathVariable Long id){
        return ResponseEntity.ok(iTrabajadorService.getTrabajador(id));
    }

    @PostMapping
    public ResponseEntity<TrabajadorDTO> saveTrabajador(@RequestBody TrabajadorDTO trabajadorDTO){
        return ResponseEntity.ok(iTrabajadorService.saveTrabajador(trabajadorDTO));
    }
}