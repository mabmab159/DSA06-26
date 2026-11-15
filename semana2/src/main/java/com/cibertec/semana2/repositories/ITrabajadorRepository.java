package com.cibertec.semana2.repositories;

import com.cibertec.semana2.entity.TrabajadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrabajadorRepository extends JpaRepository<TrabajadorEntity, Long> {
    @Query("select trabajador from TrabajadorEntity trabajador where trabajador.nombres like %:nombre%")
    List<TrabajadorEntity> filtrarNombre(String nombre);

    @Query(value = "select * from trabajador where nombres like concat('%',:nombre,'%')", nativeQuery = true)
    List<TrabajadorEntity> filtrarNombreNativo(String nombre);
}
