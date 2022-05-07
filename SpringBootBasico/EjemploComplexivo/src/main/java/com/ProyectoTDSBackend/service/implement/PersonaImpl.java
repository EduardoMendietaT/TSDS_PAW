package com.ProyectoTDSBackend.service.implement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Vinculacion;
import com.ProyectoTDSBackend.repository.PersonaRepository;
import com.ProyectoTDSBackend.security.enums.RolNombre;
import com.ProyectoTDSBackend.security.models.Persona;
import com.ProyectoTDSBackend.security.models.Rol;
import com.ProyectoTDSBackend.security.repository.RolRepository;
import com.ProyectoTDSBackend.security.service.RolService;
import com.ProyectoTDSBackend.service.PersonaService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;
@Service
public class PersonaImpl implements PersonaService{
	@Autowired
	PersonaRepository personaRepository;
	
	 @Autowired
	 RolRepository rolrepo;
	 
	 @Autowired
	 RolService rolser;
	 @Override
	    public List<Persona> getAllPersonas() {
	        return personaRepository.findAll();
	    }


		@Override
		public Persona getById(int idpersona) {
			 Persona persona = personaRepository.findByidpersona(idpersona);
		        return persona;
		}


		@Override
		public GenericResponse<Object> putPermisos(int idpersona,RolNombre rol) {
			GenericResponse<Object> response = new GenericResponse<>();

			try {
					Persona persona = personaRepository.findByidpersona(idpersona);
					if (personaRepository.findById(idpersona).isEmpty() == true) {
						response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
						response.setObject("No se puede actualizar la persona porque no se encontro");
						response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
					} else {
						  Set<Rol> roles = new HashSet<>();
					        roles.add(rolser.getByRolNombre(rol).get());
					        persona.setEstado(1);
					        persona.setRoles(roles);
						
						personaRepository.saveAndFlush(persona);
						response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
						response.setObject("Usuario Editado");
						response.setStatus(ParametersApp.SUCCESSFUL.value());
					}
			} catch (Exception e) {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("ERROR " + e);
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
			return response;
		}

	
}
