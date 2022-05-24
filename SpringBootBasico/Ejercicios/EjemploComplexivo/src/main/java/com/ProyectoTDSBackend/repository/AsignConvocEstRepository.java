package com.ProyectoTDSBackend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.AsignacionConvocatoriaEstudiantes;
import com.ProyectoTDSBackend.models.Convocatoria;

@Repository
public interface AsignConvocEstRepository extends JpaRepository<AsignacionConvocatoriaEstudiantes, Long> {
	
	AsignacionConvocatoriaEstudiantes findByidasigestudconvocatoria(Long idasigestudconvocatoria);

	@Query(value = "select * from asignacion_convocatoria_estudiantes a where a.idconvocatoria =:idconvocatoria order by a.idconvocatoria desc ", nativeQuery = true)
	List<AsignacionConvocatoriaEstudiantes> findidconvocatoria(Long idconvocatoria);

	@Query(value = "Select * from asignacion_convocatoria_estudiantes a where a.idestudiante =:idestudiante order by a.fechaenvio desc ", nativeQuery = true)
	List<AsignacionConvocatoriaEstudiantes> findidestudiante(Long idestudiante);
	
	@Query(value = "Select * from asignacion_convocatoria_estudiantes a where a.idestado =:idestado order by a.fechaenvio desc ", nativeQuery = true)
	List<AsignacionConvocatoriaEstudiantes> findidestado(Long idestado);
}
