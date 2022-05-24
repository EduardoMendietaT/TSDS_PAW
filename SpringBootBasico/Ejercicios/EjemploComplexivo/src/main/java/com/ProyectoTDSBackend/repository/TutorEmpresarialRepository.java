package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.TutorEmpresarial;

@Repository
public interface TutorEmpresarialRepository extends JpaRepository<TutorEmpresarial, Long> {
	
	TutorEmpresarial findByidtutoremp(Long idtutoremp);
	
	TutorEmpresarial findByidentificacion(String identificacion);
	
}
