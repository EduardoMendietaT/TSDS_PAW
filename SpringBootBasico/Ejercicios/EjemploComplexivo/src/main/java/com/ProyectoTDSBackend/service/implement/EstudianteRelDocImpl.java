package com.ProyectoTDSBackend.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.EstudianteRelDoc;
import com.ProyectoTDSBackend.repository.DocumentoRepository;
import com.ProyectoTDSBackend.repository.EstadoRepository;
import com.ProyectoTDSBackend.repository.EstudianteRelDocRepository;
import com.ProyectoTDSBackend.repository.EstudianteRepository;
import com.ProyectoTDSBackend.service.EstudianteRelDocService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class EstudianteRelDocImpl implements EstudianteRelDocService{

	@Autowired
	EstudianteRelDocRepository estdocumentoRepository;
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Autowired
	DocumentoRepository documentoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	EstudianteRelDocService estdocumentoService;
	
	@Override
	public GenericResponse<Object> aginarDocumentoAEstudiante(EstudianteRelDoc estudiantedoc, Long idestudiante,
			Long iddocumento) {
		GenericResponse<Object> response = new GenericResponse<>();
		  try {
	            if (estdocumentoRepository.findById(estudiantedoc.getIdestudiantedoc()) != null){
	            	if(documentoRepository.findById(estudiantedoc.getDocumento().getIddocumento())!=null) {
	            		 estudiantedoc.setDocumento(documentoRepository.findByiddocumento(iddocumento));
	                     estudiantedoc.setEstudiante(estudianteRepository.findByidestudiante(idestudiante));
	                    
		                estdocumentoRepository.save(estudiantedoc);
		                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
		                response.setObject("Se ha asignado documento ha:"+estudiantedoc.getEstudiante().getPersona().getPrimernombre()+" creado exitosamente");
		                response.setStatus(ParametersApp.SUCCESSFUL.value());
		            } else {
		                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
		                response.setObject("Documento  duplicado");
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
	public GenericResponse<Object> puDocumentoEstudiante(Long idestudiantedoc, Long idestudiante, Long iddocumento, Date fechaasignacion) {
		GenericResponse<Object> response = new GenericResponse<>();

		try {
			if (estdocumentoRepository.findById(idestudiantedoc).isEmpty() == false) {
				EstudianteRelDoc estdoc = estdocumentoRepository.findById(idestudiantedoc).get();
				if ((documentoRepository.findById(iddocumento).isEmpty()) == true) {
					response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
					response.setObject("No se puede asignar documento porque no se encontró documento,estado o estudiante");
					response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
				} else {

					estdoc.setDocumento(documentoRepository.findByiddocumento(iddocumento));
					estdoc.setEstudiante(estudianteRepository.findByidestudiante(idestudiante));
					estdoc.setFechaasignacion(fechaasignacion);
					estdocumentoRepository.saveAndFlush(estdoc);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("Coordinador Editado");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
				}
			} else {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("Convenio no encontrado");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("ERROR " + e);
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		}
		return response;
	}

	@Override
	public List<EstudianteRelDoc> getAllDocsEstudiantes() {
		// TODO Auto-generated method stub
		return estdocumentoRepository.findAll();
	}

	@Override
	public List<EstudianteRelDoc> FindByestudiante(Long idestudiante) {
		
		return estdocumentoRepository.findByidestudiante(idestudiante);
	}

	
	

}
