/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.service;

import com.ProyectoTDSBackend.models.Asignatura;
import com.ProyectoTDSBackend.repository.AsignaturaRepository;
import com.ProyectoTDSBackend.repository.CarreraRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class AsignaturaService {

    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    CarreraRepository carreraRepository;
    
    public List<Asignatura> getlListaAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> getOne(Long idasignatura) {
        return asignaturaRepository.findById(idasignatura);
    }


    public GenericResponse<Object> saveAsignatura(Asignatura asignatura,Long idcarrera) {
    	GenericResponse<Object> response = new GenericResponse<>();
    	if(carreraRepository.findById(idcarrera).isEmpty()==true) {
    		
    		response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("No se puede crear la asignatura porque no se encontró la carrera");
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
    	}else {
    		
    		asignatura.setCarrera(carreraRepository.findById(idcarrera).get());
    		asignaturaRepository.save(asignatura);
			response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
			response.setObject("La asignatura se ha creado");
			response.setStatus(ParametersApp.SUCCESSFUL.value());
    	}
        
    	return response;
    }



    public GenericResponse<Object> putAsignatura(Long idasignatura,String nombreasignatura, Date fechacreacion,Long idcarrera) {
        GenericResponse<Object> response = new GenericResponse<>();

        if (asignaturaRepository.findById(idasignatura).isEmpty()== false) {
        	Asignatura asignatura=asignaturaRepository.findById(idasignatura).get();
        	if(carreraRepository.findById(idcarrera).isEmpty() == true) {
        		
        		response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("No se puede actualizar la asignatura porque no se encontró la carrera");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
        		
        	}else {
        		asignatura.setCarrera(carreraRepository.findByidcarrera(idcarrera));
        		asignatura.setNombreasignatura(nombreasignatura.toUpperCase());
                asignatura.setFechacreacion(fechacreacion);
                asignaturaRepository.save(asignatura);
                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
                response.setObject("Actualizado correctamente");
                response.setStatus(ParametersApp.SUCCESSFUL.value());
        	}
           
        } else {
            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
            response.setObject("Error al actualizar");
            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
        }
        return response;
    }

}
