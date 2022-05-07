package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.TutorEmpDocument;
import com.ProyectoTDSBackend.repository.DocumentoRepository;
import com.ProyectoTDSBackend.repository.TutorEmpDocRepository;
import com.ProyectoTDSBackend.repository.TutorEmpresarialRepository;
import com.ProyectoTDSBackend.service.TutorEmpDocService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class TutorEmpDocImpl implements TutorEmpDocService {
	
	@Autowired
	TutorEmpDocRepository tdocumentoRepository;
	
	@Autowired
	TutorEmpresarialRepository tutorempRepository;

	@Autowired
	DocumentoRepository documentoRepository;

	@Override
	public GenericResponse<Object> asignarDocumentoATutorEmp(TutorEmpDocument tutordoc, Long iddocumento,
			Long idtutoremp) {
		GenericResponse<Object> response = new GenericResponse<>();
		  try {
	            if (tdocumentoRepository.findById(tutordoc.getIdtuempresdoc()) != null){
	            	if(documentoRepository.findById(tutordoc.getDocumento().getIddocumento())!=null) {
	            		 tutordoc.setDocumento(documentoRepository.findByiddocumento(iddocumento));
	                     tutordoc.setTutoremp(tutorempRepository.findByidtutoremp(idtutoremp));
	                    
		                tdocumentoRepository.save(tutordoc);
		                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
		                response.setObject("Se ha asignado documento ha:"+tutordoc.getTutoremp().getNombretutor()+" creado exitosamente");
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

	@Override
	public List<TutorEmpDocument> FindBytutorempresarial(Long idtutoremp) {
		return tdocumentoRepository.findByidtutoremp(idtutoremp);
	}

	@Override
	public List<TutorEmpDocument> getAllDocumentosAsingnados() {
		return tdocumentoRepository.findAll();
	}

}
