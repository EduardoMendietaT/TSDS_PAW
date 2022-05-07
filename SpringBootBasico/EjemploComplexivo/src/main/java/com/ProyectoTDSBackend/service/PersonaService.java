package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.security.enums.RolNombre;
import com.ProyectoTDSBackend.security.models.Persona;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface PersonaService {


	Persona getById(int idpersona);
	List<Persona> getAllPersonas();
	
	GenericResponse<Object> putPermisos(int idpersona,RolNombre idrol);
}
