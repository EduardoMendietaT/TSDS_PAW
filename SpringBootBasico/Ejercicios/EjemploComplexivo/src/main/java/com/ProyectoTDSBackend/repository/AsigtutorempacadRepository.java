package com.ProyectoTDSBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Asigtutorempacad;

@Repository
public interface AsigtutorempacadRepository extends JpaRepository<Asigtutorempacad, Long> {

	@Query(value = "select * from asigtutorempacad e where e.idestudiante= :idestudiante order by e.idtutoremp desc ", nativeQuery = true)
	List<Asigtutorempacad> findByidestudiante(Long idestudiante);

	@Query(value = "select * from asigtutorempacad e where e.idtutoremp= :idtutoremp order by e.idestudiante desc ", nativeQuery = true)
	List<Asigtutorempacad> findByidtutoremp(Long idtutoremp);

	@Query(value = "select * from asigtutorempacad e where e.idtutoracad= :idtutoracad order by e.idestudiante desc ", nativeQuery = true)
	List<Asigtutorempacad> findByidtutoracad(Long idtutoracad);

}
