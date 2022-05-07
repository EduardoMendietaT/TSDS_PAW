package com.ProyectoTDSBackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.TutorAcadDocumento;

@Repository
public interface TutorAcadDocRepository extends JpaRepository<TutorAcadDocumento, Long>{
	
	TutorAcadDocumento findByidtutordoc(Long idtutordoc);
	

	Optional<TutorAcadDocumento> findById(Long idtutordoc);
	
	@Query(value = "select * from tutoracaddocumento t where t.idtutoracad= :idtutoracad order by t.iddocumento desc ", nativeQuery = true)
    List<TutorAcadDocumento> findByidtutoracad(Long idtutoracad);

}
