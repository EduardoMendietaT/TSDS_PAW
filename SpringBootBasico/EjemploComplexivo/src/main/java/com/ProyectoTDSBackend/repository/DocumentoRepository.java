package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
	

	boolean existsBynombreanexo(String nombreanexo);
	
	Documento findByiddocumento(Long iddocumento);

	Documento findBynombreanexo(String nombreanexo);

}
