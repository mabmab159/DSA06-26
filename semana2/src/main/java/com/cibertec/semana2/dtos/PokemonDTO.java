package com.cibertec.semana2.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {
    private Long id;
    private String name;
    @JsonProperty("base_experience")
    private String baseExperience;
    private String height;
    @JsonProperty("is_default")
    private boolean isDefault; //null <-Aca esta cayendo el servicio
    private Long order;
    private Long weight;
    private List<FormsDTO> forms;
}
