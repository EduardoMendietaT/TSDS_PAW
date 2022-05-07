package com.ProyectoTDSBackend.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.TutorEmpresarial;
import com.ProyectoTDSBackend.repository.EmpresaRepository;
import com.ProyectoTDSBackend.repository.TutorEmpresarialRepository;
import com.ProyectoTDSBackend.service.TutorEmpresarialService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class TutorEmpresarialImpl implements TutorEmpresarialService {
	
	@Autowired
	TutorEmpresarialRepository tutorRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	public GenericResponse<Object> createTutorEmpresarial(TutorEmpresarial tutor, Long idempresa) {
		GenericResponse<Object> response = new GenericResponse<>();
		try {
//			if (tutorRepository.findById(tutor.getIdtutoremp()) != null) {
				if (empresaRepository.findById(idempresa).isEmpty() == false) {
					
					tutor.setEmpresa(empresaRepository.findById(idempresa).get());
					tutor.setNombretutor(tutor.getNombretutor().toUpperCase());
					tutor.setIdentificacion(tutor.getIdentificacion().toUpperCase());
					tutor.setContacto(tutor.getContacto().toUpperCase());
					tutor.setEstado(1);
					tutorRepository.save(tutor);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("Tutor Empresarial creado");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
				} else {
					tutorRepository.save(tutor);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("Tutor empresarial creado");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
				}
//			} else {
//				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
//                response.setObject("El Tutor ya existe");
//                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
//			}
		} catch (Exception e) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("Error: " + e);
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		}
		return response;
	}

	@Override
	public GenericResponse<Object> putTutorEmpresarial(String nombretutor, String identificacion, String contacto, Long idempresa,Long idtutoremp) {
		 GenericResponse<Object> response = new GenericResponse<>();
	        TutorEmpresarial tutor = tutorRepository.findById(idtutoremp).get();
	        if ((tutor.getIdtutoremp()) != null) {
	            tutor.setNombretutor(nombretutor.toUpperCase());
	            tutor.setIdentificacion(identificacion.toUpperCase());
	            tutor.setContacto(contacto.toUpperCase());
	            tutor.setEstado(1);
	            tutorRepository.save(tutor);
	            response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	            response.setObject("Actualizado correctamente");
	            response.setStatus(ParametersApp.SUCCESSFUL.value());
	        } else {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error al actualizar");
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	}

	@Override
	public List<TutorEmpresarial> getAllTutores() {
		// TODO Auto-generated method stub
		return tutorRepository.findAll();
	}

	@Override
	public TutorEmpresarial getById(Long idtutoremp) {
		// TODO Auto-generated method stub
		return tutorRepository.findByidtutoremp(idtutoremp);
	}

//	@Override
//	public TutorEmpresarial getbyidentificacion(String identificacion) {
//		// TODO Auto-generated method stub
//		return tutorRepository.findByidentificacion(identificacion);
//	}

}
