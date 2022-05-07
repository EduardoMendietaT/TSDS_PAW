package com.ProyectoTDSBackend.service.implement;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Convenio;
import com.ProyectoTDSBackend.repository.ConvenioRepository;
import com.ProyectoTDSBackend.repository.CoordinadorRepository;
import com.ProyectoTDSBackend.repository.EmpresaRepository;
import com.ProyectoTDSBackend.repository.VinculacionRepository;
import com.ProyectoTDSBackend.service.ConvenioService;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class ConvenioImpl implements ConvenioService {

	@Autowired
	ConvenioRepository convenioRepository;
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	VinculacionRepository vinculacionRepository;
	@Autowired
	CoordinadorRepository coordinadorRepository;

	@Autowired
	ConvenioService convenioService;

	@Override
	public GenericResponse<Object> putConvenio(Long idconvenio, Long idcoordinador, Long idempresa, Long idvinculacion,
			String descripcionconvenio, Date fechaconvenio) {
		GenericResponse<Object> response = new GenericResponse<>();

		try {
//			if (convenioRepository.findById(idconvenio).isEmpty() == false) {
				Convenio convenio = convenioRepository.findById(idconvenio).get();
				if (coordinadorRepository.findById(idcoordinador).isEmpty() == true) {
					response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
					response.setObject("No se puede actualizar el convenio porque no se encontro este coordinador");
					response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
				} else {

					convenio.setEmpresa(empresaRepository.findByidempresa(idempresa));
					convenio.setCoordinador(coordinadorRepository.findByidcoordinador(idcoordinador));
					convenio.setVinculacion(vinculacionRepository.findByidvinculacion(idvinculacion));
					convenio.setDescripcionconvenio(descripcionconvenio.toUpperCase());
					convenio.setFechaconvenio(fechaconvenio);
					convenioRepository.saveAndFlush(convenio);
					response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
					response.setObject("Coordinador Editado");
					response.setStatus(ParametersApp.SUCCESSFUL.value());
				}
//			} else {
//				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
//				response.setObject("Convenio no encontrado");
//				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
//			}
		} catch (Exception e) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("ERROR " + e);
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		}
		return response;
	}

	@Override
	public List<Convenio> getAllConvenio() {

		return convenioRepository.findAll();
	}

	@Override
	public Convenio getById(Long idconvenio) {
		return convenioService.getById(idconvenio);
	}

	@Override
	public GenericResponse<Object> createConvenio(Convenio convenio, Long idempresa, Long idvinculacion,
			Long idcoordinador) {
		GenericResponse<Object> response = new GenericResponse<>();
		try {
			if (convenioRepository.findById(convenio.getIdconvenio()) != null) {
				if (empresaRepository.findById(idempresa).isEmpty() == false) {
					if (vinculacionRepository.findById(idvinculacion).isEmpty() == false) {
						if (coordinadorRepository.findById(convenio.getCoordinador().getIdcoordinador()) != null) {
							if (coordinadorRepository.findById(convenio.getCoordinador().getIdcoordinador()) != null) {
								convenio.setDescripcionconvenio(convenio.getDescripcionconvenio());
								convenio.setFechaconvenio(convenio.getFechaconvenio());
								
		                        convenio.setEmpresa(empresaRepository.findById(idempresa).get());
		                        convenio.setVinculacion(vinculacionRepository.findById(idvinculacion).get());
		                        convenio.setCoordinador(coordinadorRepository.findById(idcoordinador).get());
		                        convenioRepository.save(convenio);
								response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
								response.setObject("Convenio creado");
								response.setStatus(ParametersApp.SUCCESSFUL.value());
							} else {
								convenioRepository.save(convenio);
								response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
								response.setObject("Convenio creado");
								response.setStatus(ParametersApp.SUCCESSFUL.value());
							}
						} else {
	                    	 response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                         response.setObject("No se puede asignar un coordinador a esta persona");
	                         response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	                    }
					} else {
					response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
					response.setObject("No se puede asignar  persona");
					response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
				}
			} else {
				response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
				response.setObject("No se puede asignar empresa");
				response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		}else {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("El convenio ya existe");
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
			}
		} catch (Exception e) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject("Error: " + e);
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		}
		return response;
	}

}
