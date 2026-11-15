package com.cibertec.semana2.services;

import com.cibertec.semana2.dtos.TrabajadorDTO;
import com.cibertec.semana2.entity.TrabajadorEntity;
import com.cibertec.semana2.repositories.ITrabajadorRepository;
import com.cibertec.semana2.repositories.ITrabajadorRepositoryPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrabajadorService implements ITrabajadorService {
    private final ITrabajadorRepository iTrabajadorRepository;
    private final ITrabajadorRepositoryPage iTrabajadorRepositoryPage;
    private final ObjectMapper objectMapper;

    //List<TrabajadorDTO> listaTrabajador = new ArrayList<>();

    @Override
    public List<TrabajadorDTO> getAllTrabajador() {
        return iTrabajadorRepository.findAll()
                .stream()
                .map(e ->
                        objectMapper.convertValue(e, TrabajadorDTO.class)
                ).toList();
        // return listaTrabajador;
    }

    @Override
    public TrabajadorDTO getTrabajador(Long id) {
        /*return listaTrabajador.stream()
                .filter(t -> t.getId() == id)
                .toList()
                .getFirst(); //0*/
        Optional<TrabajadorEntity> respuesta = iTrabajadorRepository.findById(id);
        if (respuesta.isPresent()) {
            //Devuelve lo de adentro del optional
            return objectMapper.convertValue(respuesta.get(), TrabajadorDTO.class);
        }
        return null;
    }

    @Override
    public TrabajadorDTO saveTrabajador(TrabajadorDTO trabajadorDTO) {
       /* listaTrabajador.add(trabajadorDTO);
        return trabajadorDTO;*/
        trabajadorDTO.setId(null);
        TrabajadorEntity trabajadorEntity = objectMapper.convertValue(trabajadorDTO, TrabajadorEntity.class);
        return objectMapper.convertValue(iTrabajadorRepository.save(trabajadorEntity), TrabajadorDTO.class);
    }

    @Override
    public List<TrabajadorDTO> getAllTrabajadorPage(Pageable pageable) {
        return iTrabajadorRepositoryPage.findAll(pageable)
                .get()
                .map(e -> objectMapper.convertValue(e, TrabajadorDTO.class))
                .toList();
    }

    @Override
    public List<TrabajadorDTO> filtrarNombre(String nombre) {
        return iTrabajadorRepository.filtrarNombre(nombre)
                .stream().map(p -> objectMapper.convertValue(p, TrabajadorDTO.class))
                .toList();
    }
}
