package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.models.TutorEmpDocument;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface TutorEmpDocService {
	
	 GenericResponse<Object> asignarDocumentoATutorEmp(TutorEmpDocument tutordoc,Long iddocumento,Long idtutoremp);

//	    GenericResponse<Object> puDocumentoEstudiante(Long idtutordoc,Long iddocumento,Long idtutoracad,Date fechaasignacion);

	    List<TutorEmpDocument> FindBytutorempresarial(Long idtutoremp);
	    
	    List<TutorEmpDocument> getAllDocumentosAsingnados();

}
