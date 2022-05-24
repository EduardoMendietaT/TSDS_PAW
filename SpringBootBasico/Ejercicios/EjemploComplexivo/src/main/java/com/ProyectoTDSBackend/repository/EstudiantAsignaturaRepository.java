package com.ProyectoTDSBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.EstudiantAsignatura;

@Repository
public interface EstudiantAsignaturaRepository extends JpaRepository<EstudiantAsignatura,Long> {
	
	@Query(value = "select * from estudiant_asignatura e where e.idestudiante= :idestudiante order by e.idasignatura desc ", nativeQuery = true)
	List<EstudiantAsignatura> findByidestudiante(Long idestudiante);
	
	@Query(value = "select * from estudiant_asignatura e where e.promedio= :promedio order by e.idasignatura desc ", nativeQuery = true)
	List<EstudiantAsignatura> findBypromedio(double promedio);
}