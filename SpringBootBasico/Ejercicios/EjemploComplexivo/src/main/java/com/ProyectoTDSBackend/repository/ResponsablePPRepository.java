package com.ProyectoTDSBackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.ResponsablePPP;

@Repository
public interface ResponsablePPRepository extends JpaRepository<ResponsablePPP, Long> {

	
	ResponsablePPP findByidresponsableppp(Long idresponsableppp);
	

	Optional<ResponsablePPP> findById(Long idresponsableppp);
	
//	@Query(value = "select * from estudiantereldoc e where e.idestudiante= :idestudiante order by e.iddocumento desc ", nativeQuery = true)
//    List<ResponsablePPP> findByidestudiante(Long idestudiante);
}
