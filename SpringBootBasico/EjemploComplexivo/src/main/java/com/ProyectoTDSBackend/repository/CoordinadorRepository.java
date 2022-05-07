package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Coordinador;

@Repository
public interface CoordinadorRepository extends JpaRepository<Coordinador, Long> {

	
	Coordinador findByidcoordinador(Long idcoordinador);
}
