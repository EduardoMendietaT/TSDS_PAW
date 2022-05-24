package com.ProyectoTDSBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.EstudiantAsignatura;
import com.ProyectoTDSBackend.repository.AsignaturaRepository;
import com.ProyectoTDSBackend.repository.EstudiantAsignaturaRepository;
import com.ProyectoTDSBackend.repository.EstudianteRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class EstudiantAsignaturaService {
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Autowired
	EstudiantAsignaturaRepository  estudasignRepository;
	
	 public List<EstudiantAsignatura> getlListarEstudiantesDocumentos() {
	        return estudasignRepository.findAll();
	    }
	 public List<EstudiantAsignatura> getByIdestudiante(Long idestudiante) {
	        return estudasignRepository.findByidestudiante(idestudiante);
	    }
	 
	   public GenericResponse<Object> saveAsignacionEstDoc(EstudiantAsignatura asignacion,double promedio,Long idestudiante,Long idasignatura) {
	    	GenericResponse<Object> response = new GenericResponse<>();
	    	if((asignaturaRepository.findById(idestudiante).isEmpty())&&(asignaturaRepository.findById(idasignatura).isEmpty())==true) {
	    		response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("No se puede crear la asignatura porque no se encontró el estudiante o asignatura");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	    	}else {
	    		asignacion.setPromedio(promedio);
	    		asignacion.setEstudiante(estudianteRepository.findById(idestudiante).get());
	    		asignacion.setAsignatura(asignaturaRepository.findById(idasignatura).get());
	    		estudasignRepository.save(asignacion);
				response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
				response.setObject("Se han asignado correctamente la asignatura al estudiante :se ha creado");
				response.setStatus(ParametersApp.SUCCESSFUL.value());
	    	}
	        
	    	return response;
	    }


}
