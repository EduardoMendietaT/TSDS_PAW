/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoTDSBackend.models.Asignatura;

/**
 *
 * @author LENOVO
 */
@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{
	
	Asignatura findByidasignatura(Long idasignatura);

	Asignatura findBynombreasignatura(String nombreasignatura);
    
}
