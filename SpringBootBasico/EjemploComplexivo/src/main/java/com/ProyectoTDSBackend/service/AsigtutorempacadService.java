package com.ProyectoTDSBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Asignatura;
import com.ProyectoTDSBackend.models.Asigtutorempacad;
import com.ProyectoTDSBackend.models.Estudiante;
import com.ProyectoTDSBackend.models.TutorAcademico;
import com.ProyectoTDSBackend.repository.AsigtutorempacadRepository;
import com.ProyectoTDSBackend.repository.EstudianteRepository;
import com.ProyectoTDSBackend.repository.TutorAcadRepository;
import com.ProyectoTDSBackend.repository.TutorEmpresarialRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class AsigtutorempacadService {
	
	@Autowired
	AsigtutorempacadRepository asigtutorempacadRepository;
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Autowired
	TutorEmpresarialRepository  tutorempRepository;
	
	@Autowired
	TutorAcadRepository tutoracadRepository;
	
	
	 public List<Asigtutorempacad> getlListarAsignaciones() {
	        return asigtutorempacadRepository.findAll();
	    }
	 public List<Asigtutorempacad> getByIdtutorAcademico(Long idtutoracad) {
	        return asigtutorempacadRepository.findByidtutoracad(idtutoracad);
	    }
	 public List<Asigtutorempacad> getByIdtutorEmpresarial(Long idtutoremp) {
	        return asigtutorempacadRepository.findByidtutoremp(idtutoremp);
	    }
	 public List<Asigtutorempacad> getByIdestudiante(Long idestudiante) {
	        return asigtutorempacadRepository.findByidestudiante(idestudiante);
	    }
	 
	   public GenericResponse<Object> saveAsignacion(Asigtutorempacad asignacion,Long idtutoracad,Long idtutoremp,Long idestudiante) {
	    	GenericResponse<Object> response = new GenericResponse<>();
	    	if((tutoracadRepository.findById(idtutoracad).isEmpty())&&(estudianteRepository.findById(idestudiante).isEmpty())&&(tutorempRepository.findById(idtutoremp).isEmpty())==true) {
	    		response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("No se puede crear la asignatura porque no se encontró tutor academico, tutor empresarial, estudiante");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	    	}else {
	    		
	    		asignacion.setEstudiante(estudianteRepository.findById(idestudiante).get());
	    		asignacion.setTutoracad(tutoracadRepository.findById(idtutoracad).get());
	    		asignacion.setTutoremp(tutorempRepository.findById(idtutoremp).get());
	    		asigtutorempacadRepository.save(asignacion);
				response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
				response.setObject("Se han asignado correctamente tutor academico y tutor empresarial a estudiante se ha creado");
				response.setStatus(ParametersApp.SUCCESSFUL.value());
	    	}
	        
	    	return response;
	    }

}
