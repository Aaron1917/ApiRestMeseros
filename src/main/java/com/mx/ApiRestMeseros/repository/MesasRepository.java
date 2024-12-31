package com.mx.ApiRestMeseros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.ApiRestMeseros.model.Mesas;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, Long>{

}
