package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.models.TutorAcademico;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface TutorAcadService {
	
	GenericResponse<Object> createTutorAcademico(TutorAcademico tutor,Long idcarrera,int idpersona);

	List<TutorAcademico> getAllTutoresAcademicos();

	TutorAcademico getById(Long idtutoracad);

}
