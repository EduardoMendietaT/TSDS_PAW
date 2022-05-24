package com.ProyectoTDSBackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.EstudianteRelDoc;
import com.ProyectoTDSBackend.models.ResponsablePPDocumento;

@Repository
public interface ResponsablePPDocRepository extends JpaRepository<ResponsablePPDocumento, Long> {
	
	ResponsablePPDocumento findByidresponsabledoc(Long idresponsabledoc);
	

	Optional<ResponsablePPDocumento> findById(Long idresponsabledoc);
	
	@Query(value = "select * from responsableppdocumento t where t.idresponsableppp= :idresponsableppp order by t.iddocumento desc ", nativeQuery = true)
    List<ResponsablePPDocumento> findByidresponsableppp(Long idresponsableppp);

}
