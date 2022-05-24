package com.ProyectoTDSBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	boolean existsBynombreempresa(String nombreempresa);
	
	 Empresa findByidempresa(Long idempresa);
	 
	 Empresa findBynombreempresa(String nombreempresa);
	 
	 List<Empresa> findByEstado(Integer estado);

}
