package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	
	boolean existsBydescripcion(String descripcion);
	
	Estado findByidestado(Long idestado);

	Estado findBydescripcion(String descripcion);

}
