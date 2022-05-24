/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ProyectoTDSBackend.models.Actividad;
import com.ProyectoTDSBackend.repository.ActividadRepository;
import com.ProyectoTDSBackend.repository.EmpresaRepository;
import com.ProyectoTDSBackend.repository.ResponsablePPRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class ActividadService {

	@Autowired
	ActividadRepository actividadRepository;
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	ResponsablePPRepository responsableRepository;

	public List<Actividad> getlListaActividades() {
		return actividadRepository.findAll();
	}

	public Optional<Actividad> getOne(Long id) {
		return actividadRepository.findById(id);
	}

	public GenericResponse<Object> saveActividad(Actividad actividad, Long idempresa, Long idresponsableppp) {
		GenericResponse<Object> response = new GenericResponse<>();

		if ((empresaRepository.findById(idempresa).isEmpty())
				&& (responsableRepository.findById(idresponsableppp).isEmpty()) == true) {

			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject(
					"No se puede crear la actividad porque no se encontró la carrera o el responsable de practicas");
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		} else {

			actividad.setEmpresa(empresaRepository.findById(idempresa).get());
			actividad.setResponsableppp(responsableRepository.findById(idresponsableppp).get());
			actividadRepository.save(actividad);
			response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
			response.setObject("La actividad se ha creado");
			response.setStatus(ParametersApp.SUCCESSFUL.value());
		}

		return response;
	}

	public void delete(Long id) {
		actividadRepository.deleteById(id);
	}

	public boolean existsById(Long id) {
		return actividadRepository.existsById(id);
	}

	public GenericResponse<Object> putActividad(Long idactividad,String descripcionactividades, Date horario, Date cronograma) {
		GenericResponse<Object> response = new GenericResponse<>();
		Actividad actividad = actividadRepository.findById(idactividad).get();
		if (actividad.getIdactividad() != null) {
			actividad.setDescripcionactividades(descripcionactividades);
			actividad.setHorario(horario);
			actividad.setCronograma(cronograma);
			actividadRepository.save(actividad);
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

}
