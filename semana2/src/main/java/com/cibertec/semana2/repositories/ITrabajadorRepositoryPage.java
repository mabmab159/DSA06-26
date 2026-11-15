package com.cibertec.semana2.repositories;

import com.cibertec.semana2.entity.TrabajadorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepositoryPage extends PagingAndSortingRepository<TrabajadorEntity, Long> {
}
