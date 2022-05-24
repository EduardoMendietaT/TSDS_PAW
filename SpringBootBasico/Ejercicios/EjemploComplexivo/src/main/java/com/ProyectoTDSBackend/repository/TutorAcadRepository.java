package com.ProyectoTDSBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.TutorAcademico;

@Repository
public interface TutorAcadRepository extends JpaRepository<TutorAcademico, Long> {

	TutorAcademico findByidtutoracad(Long idtutoracad);

	Optional<TutorAcademico> findById(Long idtutoracad);

//	@Query(value = "select * from estudiantereldoc e where e.idestudiante= :idestudiante order by e.iddocumento desc ", nativeQuery = true)
//    List<ResponsablePPP> findByidestudiante(Long idestudiante);

}
