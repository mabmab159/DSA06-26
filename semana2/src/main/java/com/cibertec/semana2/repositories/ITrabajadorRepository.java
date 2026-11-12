package com.cibertec.semana2.repositories;

import com.cibertec.semana2.entity.TrabajadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepository extends JpaRepository<TrabajadorEntity, Long> {
}
