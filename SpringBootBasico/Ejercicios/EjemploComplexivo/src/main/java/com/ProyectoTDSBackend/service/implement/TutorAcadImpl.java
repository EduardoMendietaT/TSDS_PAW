package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.TutorAcademico;
import com.ProyectoTDSBackend.repository.CarreraRepository;
import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.repository.TutorAcadRepository;
import com.ProyectoTDSBackend.service.TutorAcadService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class TutorAcadImpl implements TutorAcadService{
	
	@Autowired
	TutorAcadRepository tutorRepository;
	
	@Autowired
	CarreraRepository carreraRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	TutorAcadService tutoracadService;
	

	@Override
	public GenericResponse<Object> createTutorAcademico(TutorAcademico tutor, Long idcarrera, int idpersona) {
		GenericResponse<Object> response = new GenericResponse<>();
		try {
			if (tutorRepository.findById(tutor.getIdtutoracad()) != null) {
				if (carreraRepository.findById(idcarrera).isEmpty() == false) {
					if (personaRepository.findById(idpersona).isEmpty() == false) {
						if (personaRepository.findByIdentificacion(tutor.getPersona().getIdentificacion()) != null) {
	                       tutor.setEstado(1);
	                        tutor.setPersona(personaRepository.findById(idpersona).get());
	                        tutor.setCarrera(carreraRepository.findByidcarrera(idcarrera));
	                        tutorRepository.save(tutor);
	                        response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                        response.setObject("Responsable de PPP creado");
	                        response.setStatus(ParametersApp.SUCCESSFUL.value());
	                        //return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
	                    } else {
	                    	 response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                         response.setObject("No se puede asignar este tutor academico ");
	                         response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	                    }
					} else {
					response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
					response.setObject("No se puede asignar carrera");
					response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
				}
			} else {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("No se puede asignar tutor academico");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}}else {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("El tutor academico ya existe");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("Error: " + e);
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		}
		return response;
	}

	@Override
	public List<TutorAcademico> getAllTutoresAcademicos() {
		return tutorRepository.findAll();
	}

	@Override
	public TutorAcademico getById(Long idtutoracad) {
		return tutorRepository.findByidtutoracad(idtutoracad);
	}

}
