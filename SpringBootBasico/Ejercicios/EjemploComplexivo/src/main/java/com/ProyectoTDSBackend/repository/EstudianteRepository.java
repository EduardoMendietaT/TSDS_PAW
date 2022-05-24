package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
	
	Estudiante findByidestudiante(Long idestudiante);

}
