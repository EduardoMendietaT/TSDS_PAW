package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.models.Estudiante;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface EstudianteService {
	
	GenericResponse<Object> createEstudiante(Estudiante estudiante,int idpersona);
	
	  List<Estudiante> getAllEstudiantes();

	    Estudiante getById(Long idestudiante);

}
