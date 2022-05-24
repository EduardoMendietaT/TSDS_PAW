package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera ,Long> {

boolean existsBynombre(String nombre);
	
	Carrera findByidcarrera(Long idcarrera);

	Carrera findBynombre(String nombre);
}
