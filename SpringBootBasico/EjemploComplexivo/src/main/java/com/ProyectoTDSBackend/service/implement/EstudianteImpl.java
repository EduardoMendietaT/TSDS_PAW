package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Estudiante;
import com.ProyectoTDSBackend.repository.EstudianteRepository;
import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.security.models.Persona;
import com.ProyectoTDSBackend.service.EstudianteService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class EstudianteImpl implements EstudianteService {
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Autowired
	EstudianteService estudianteService;

	@Autowired
	PersonaRepository personaRepository;

	@Override
	public GenericResponse<Object> createEstudiante(Estudiante estudiante, int idpersona) {
		GenericResponse<Object> response = new GenericResponse<>();
		try {
			if (estudianteRepository.findById(estudiante.getIdestudiante()) != null) {
				if (personaRepository.findById(idpersona).isEmpty() == false) {
					Persona persona = personaRepository
							.findByIdentificacion(estudiante.getPersona().getIdentificacion());
					persona.setPrimernombre(estudiante.getPersona().getPrimernombre().toUpperCase());
					persona.setSegundonombre(estudiante.getPersona().getSegundonombre().toUpperCase());
					persona.setPrimerapellido(estudiante.getPersona().getPrimerapellido().toUpperCase());
					persona.setSegundoapellido(estudiante.getPersona().getSegundoapellido().toUpperCase());
					persona.setContacto(estudiante.getPersona().getContacto());
					persona.setEmail(estudiante.getPersona().getEmail());
					estudiante.setPersona(persona);
					estudianteRepository.save(estudiante);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("Estudiante creado");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
				} else {
					estudianteRepository.save(estudiante);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("Estudiante creado");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
				}
			} else {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
                response.setObject("El estudiante ya existe");
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
	public List<Estudiante> getAllEstudiantes() {
		// TODO Auto-generated method stub
		return estudianteRepository.findAll();
	}

	@Override
	public Estudiante getById(Long idestudiante) {
		// TODO Auto-generated method stub
		return estudianteRepository.findByidestudiante(idestudiante);
	}

}
