package com.ProyectoTDSBackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.TutorAcadDocumento;
import com.ProyectoTDSBackend.models.TutorEmpDocument;

@Repository
public interface TutorEmpDocRepository extends JpaRepository<TutorEmpDocument, Long>{
	

	
	Optional<TutorEmpDocument> findById(Long idtuempresdoc);
	
	@Query(value = "select * from tutorempdocument t where t.idtutoremp= :idtutoremp order by t.iddocumento desc ", nativeQuery = true)
    List<TutorEmpDocument> findByidtutoremp(Long idtutoremp);

}
