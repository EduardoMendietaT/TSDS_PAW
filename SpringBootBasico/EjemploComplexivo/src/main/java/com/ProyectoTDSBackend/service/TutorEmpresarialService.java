package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.models.TutorEmpresarial;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface TutorEmpresarialService {
	
	GenericResponse<Object> createTutorEmpresarial(TutorEmpresarial tutor,Long idempresa);
	
	GenericResponse<Object> putTutorEmpresarial(String nombretutor, String identificacion, String contacto,Long idempresa,Long idtutoremp);
	
	  List<TutorEmpresarial> getAllTutores();

	    TutorEmpresarial getById(Long idtutoremp);
	    
//	    TutorEmpresarial getbyidentificacion(String identificacion);

}
