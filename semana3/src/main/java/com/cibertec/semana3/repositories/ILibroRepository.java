package com.cibertec.semana3.repositories;

import com.cibertec.semana3.models.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<LibroEntity, Long> {
}
