package com.ProyectoTDSBackend.service;

import java.util.Date;
import java.util.List;

import com.ProyectoTDSBackend.models.Convenio;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface ConvenioService {

	
	GenericResponse<Object> createConvenio(Convenio convenio,Long idempresa,Long idvinculacion,Long idcoordinador);

	GenericResponse<Object> putConvenio(Long idconvenio, Long idcoordinador, Long idempresa,Long idvinculacion,String descripcionconvenio,Date fechaconvenio);

	List<Convenio> getAllConvenio();

	Convenio getById(Long idconvenio);
}
