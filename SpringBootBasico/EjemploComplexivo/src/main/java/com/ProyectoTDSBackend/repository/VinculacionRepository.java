package com.ProyectoTDSBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Vinculacion;

@Repository
public interface VinculacionRepository extends JpaRepository<Vinculacion, Long> {

	
	Vinculacion findByPersonaIdentificacion(String identificacion);
	
	Vinculacion findByidvinculacion(Long idvinculacion);
	List <Vinculacion> findByrolvinculacion(String rolvinculacion);
	
	List<Vinculacion> findAll();
	

}
