package com.ProyectoTDSBackend.service;

import java.util.Date;
import java.util.List;

import com.ProyectoTDSBackend.models.EstudianteRelDoc;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface EstudianteRelDocService {

	 GenericResponse<Object> aginarDocumentoAEstudiante(EstudianteRelDoc estudiantedoc,Long idestudiante,Long iddocumento);

	    GenericResponse<Object> puDocumentoEstudiante(Long idestudiantedoc, Long idestudiante,Long iddocumento,Date fechaasignacion);

	    List<EstudianteRelDoc> FindByestudiante(Long idestudiante);
	    
	    List<EstudianteRelDoc> getAllDocsEstudiantes();
}
