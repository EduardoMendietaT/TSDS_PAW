package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Convenio;
import com.ProyectoTDSBackend.models.Coordinador;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
	
	Coordinador findByidconvenio(Long idconvenio);

}
