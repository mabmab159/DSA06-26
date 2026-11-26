package com.cibertec.semana3.configuration;

import com.cibertec.semana3.controllers.LibroController;
import com.cibertec.semana3.models.LibroDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LibroModelAssembler implements RepresentationModelAssembler<LibroDTO, EntityModel<LibroDTO>> {
    @Override
    public EntityModel<LibroDTO> toModel(LibroDTO libroDTO) {

        return EntityModel.of(
                libroDTO,

                //Consultar la información adicional de todos los libros
                linkTo(methodOn(LibroController.class).getAllLibros())
                        .withRel("libros"),

                //Consultar el libro actual
                linkTo(methodOn(LibroController.class).getLibro(libroDTO.getId()))
                        .withSelfRel(),

                linkTo(methodOn(LibroController.class).saveLibro(libroDTO))
                        .withRel("guardar")
        );

    }

    @Override
    public CollectionModel<EntityModel<LibroDTO>> toCollectionModel(Iterable<? extends LibroDTO> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
