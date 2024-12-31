package com.mx.ApiRestMeseros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.ApiRestMeseros.model.Mesero;

@Repository
public interface MeserosRepository extends JpaRepository<Mesero, Long>{

}
