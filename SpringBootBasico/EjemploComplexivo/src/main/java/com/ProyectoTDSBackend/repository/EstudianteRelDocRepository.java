package com.ProyectoTDSBackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.EstudianteRelDoc;



@Repository
public interface EstudianteRelDocRepository extends JpaRepository<EstudianteRelDoc, Long>{

	EstudianteRelDoc findByidestudiantedoc(Long idestudiantedoc);
	

	Optional<EstudianteRelDoc> findById(Long idestudiantedoc);
	
	@Query(value = "select * from estudiantereldoc e where e.idestudiante= :idestudiante order by e.iddocumento desc ", nativeQuery = true)
    List<EstudianteRelDoc> findByidestudiante(Long idestudiante);
}
