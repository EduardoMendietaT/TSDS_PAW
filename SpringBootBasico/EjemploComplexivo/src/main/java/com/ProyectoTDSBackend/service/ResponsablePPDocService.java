package com.ProyectoTDSBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.ResponsablePPDocumento;
import com.ProyectoTDSBackend.repository.DocumentoRepository;
import com.ProyectoTDSBackend.repository.ResponsablePPDocRepository;
import com.ProyectoTDSBackend.repository.ResponsablePPRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class ResponsablePPDocService {
	
//	@Autowired
//	ResponsablePPRepository responsableRepository;
//	
	@Autowired
	DocumentoRepository documentoRepository;
	
	@Autowired
	ResponsablePPDocRepository responsableDocRepository;
	
	@Autowired
	ResponsablePPRepository responsableRepository;
	

	public GenericResponse<Object> asignarDocumentoATutor(ResponsablePPDocumento tutordoc, Long iddocumento,
			Long idresponsableppp) {
		GenericResponse<Object> response = new GenericResponse<>();
		  try {
	            if (responsableDocRepository.findByidresponsabledoc(tutordoc.getIdresponsabledoc())== null){
	            	if(documentoRepository.findById(tutordoc.getDocumento().getIddocumento())!=null) {
	            		 tutordoc.setDocumento(documentoRepository.findByiddocumento(iddocumento));
	                     tutordoc.setResponsableppp(responsableRepository.findByidresponsableppp(idresponsableppp));
	                    
		                responsableDocRepository.save(tutordoc);
		                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
		                response.setObject("Se ha asignado documento ha:"+tutordoc.getResponsableppp().getPersona().getPrimernombre()+" creado exitosamente");
		                response.setStatus(ParametersApp.SUCCESSFUL.value());
		            } else {
		                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
		                response.setObject("No se ha podido asignar este documento está duplicado");
		                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		            }
	            	}else {
	            		response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
		                response.setObject("Error al procesar informacion");
		                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            	}
	        }catch (Exception e){
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error: "+e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;	
	}



	public List<ResponsablePPDocumento> FindByResponsablePPP(Long idresponsableppp) {
 	return responsableDocRepository.findByidresponsableppp(idresponsableppp);
	}
	
	public List<ResponsablePPDocumento> getAllDocumentosAsingnados() {
		return responsableDocRepository.findAll();
	
	}
}
