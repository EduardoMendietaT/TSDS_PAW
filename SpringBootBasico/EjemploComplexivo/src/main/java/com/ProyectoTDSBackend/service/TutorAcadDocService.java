package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.models.TutorAcadDocumento;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface TutorAcadDocService {
	
	 GenericResponse<Object> asignarDocumentoATutor(TutorAcadDocumento tutordoc,Long iddocumento,Long idtutoracad);

//	    GenericResponse<Object> puDocumentoEstudiante(Long idtutordoc,Long iddocumento,Long idtutoracad,Date fechaasignacion);

	    List<TutorAcadDocumento> FindBytutoracademico(Long idtutoracad);
	    
	    List<TutorAcadDocumento> getAllDocumentosAsingnados();

}
