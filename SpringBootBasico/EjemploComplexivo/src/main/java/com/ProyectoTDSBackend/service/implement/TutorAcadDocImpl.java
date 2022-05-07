package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.TutorAcadDocumento;
import com.ProyectoTDSBackend.repository.DocumentoRepository;
import com.ProyectoTDSBackend.repository.TutorAcadDocRepository;
import com.ProyectoTDSBackend.repository.TutorAcadRepository;
import com.ProyectoTDSBackend.service.TutorAcadDocService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class TutorAcadDocImpl implements TutorAcadDocService{
	
	
	@Autowired
	TutorAcadDocRepository tutoracaddocRepository;
	
	@Autowired
	DocumentoRepository documentoRepository;
	
	@Autowired
	TutorAcadDocService tutordocumentoService;
	
	@Autowired
	TutorAcadRepository tutorRepository;

	@Override
	public GenericResponse<Object> asignarDocumentoATutor(TutorAcadDocumento tutordoc, Long iddocumento,
			Long idtutoracad) {
		GenericResponse<Object> response = new GenericResponse<>();
		  try {
	            if (tutoracaddocRepository.findById(tutordoc.getIdtutordoc()) != null){
	            	if(documentoRepository.findById(tutordoc.getDocumento().getIddocumento())!=null) {
	            		 tutordoc.setDocumento(documentoRepository.findByiddocumento(iddocumento));
	                     tutordoc.setTutoracad(tutorRepository.findByidtutoracad(idtutoracad));
	                    
		                tutoracaddocRepository.save(tutordoc);
		                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
		                response.setObject("Se ha asignado documento ha:"+tutordoc.getTutoracad().getPersona().getPrimernombre()+" creado exitosamente");
		                response.setStatus(ParametersApp.SUCCESSFUL.value());
		            } else {
		                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
		                response.setObject("No se ha podido asignar este documento está duplicado");
		                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		            }
	            	}else {
	            		response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
		                response.setObject("Ya se ha asignado el documento a este estudiante");
		                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            	}
	        }catch (Exception e){
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error: "+e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;	
	}

//	@Override
//	public GenericResponse<Object> puDocumentoEstudiante(Long idtutordoc, Long iddocumento, Long idtutoracad,
//			Date fechaasignacion) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<TutorAcadDocumento> FindBytutoracademico(Long idtutoracad) {
		// TODO Auto-generated method stub
 	return tutoracaddocRepository.findByidtutoracad(idtutoracad);
	}

	@Override
	public List<TutorAcadDocumento> getAllDocumentosAsingnados() {
		// TODO Auto-generated method stub
		return tutoracaddocRepository.findAll();
	
	}




}
