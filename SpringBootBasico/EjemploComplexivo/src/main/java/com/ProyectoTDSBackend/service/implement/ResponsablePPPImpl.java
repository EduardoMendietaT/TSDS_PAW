package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.ResponsablePPP;
import com.ProyectoTDSBackend.repository.CarreraRepository;
import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.repository.ResponsablePPRepository;
import com.ProyectoTDSBackend.service.ResponsablePPService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class ResponsablePPPImpl implements ResponsablePPService{
	@Autowired
	ResponsablePPRepository responsableRepository;
	
	@Autowired
	CarreraRepository carreraRepository;
	
	@Autowired
	PersonaRepository personaRepository;

	@Override
	public GenericResponse<Object> createResponsablePPP(ResponsablePPP responsable, Long idcarrera, int idpersona) {
		GenericResponse<Object> response = new GenericResponse<>();
		try {
//			if (responsableRepository.findById(responsable.getIdresponsableppp()).isEmpty() == true) {
				if (carreraRepository.findById(idcarrera).isEmpty() == false) {
					if (personaRepository.findById(idpersona).isEmpty() == false) {
//						if (personaRepository.findByIdentificacion(responsable.getPersona().getIdentificacion()) != null) {
	                       
	                        responsable.setPersona(personaRepository.findById(idpersona).get());
	                        responsable.setCarrera(carreraRepository.findByidcarrera(idcarrera));
	                        responsableRepository.save(responsable);
	                        response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                        response.setObject("Responsable de PPP creado");
	                        response.setStatus(ParametersApp.SUCCESSFUL.value());
	                        //return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
//	                    } else {
//	                    	 response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
//	                         response.setObject("No se puede asignar un coordinador a esta persona");
//	                         response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
//	                    }
					} else {
					response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
					response.setObject("No se puede asignar  persona");
					response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
				}
			} else {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("No se puede asignar carrera");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
//				}else {
//				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
//				response.setObject("El Responsable ya existe");
//				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
//			}
		} catch (Exception e) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("Error: " + e);
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		}
		return response;
	}

	@Override
	public List<ResponsablePPP> getAllResponsablesPPP() {
		// TODO Auto-generated method stub
		return responsableRepository.findAll();
	}

	@Override
	public ResponsablePPP getById(Long idresponsableppp) {
		// TODO Auto-generated method stub
		return responsableRepository.findByidresponsableppp(idresponsableppp);
	}
	

}
