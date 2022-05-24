/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.service;

import com.ProyectoTDSBackend.models.Convocatoria;
import com.ProyectoTDSBackend.repository.CarreraRepository;
import com.ProyectoTDSBackend.repository.ConvocatoriaRepository;
import com.ProyectoTDSBackend.repository.ResponsablePPRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class ConvocatoriaService {

	@Autowired
	CarreraRepository carreraRepository;
	
	@Autowired
	ResponsablePPRepository responsableRepository;
	
    @Autowired
    ConvocatoriaRepository convocatoriaRepository;

    public List<Convocatoria> getAllConvocatorias() {
        return convocatoriaRepository.findAll();
    }
    
    public List<Convocatoria> getAllConvocatoriasDisponibles() {
        return convocatoriaRepository.findAllConvocatoriasActivas();
    }
    public List<Convocatoria> getAllConvocatoriasInhabilitadas() {
        return convocatoriaRepository.findAllConvocatoriasInactivas();
    }
  
    public List<Convocatoria> getAllConvocatoriasByfechafin(Date fechafin) {
        return convocatoriaRepository.findByfechafin(fechafin);
    }
    public List<Convocatoria> getAllConvocatoriasByfechainicio(Date fechainicio) {
        return convocatoriaRepository.findByfechainicio(fechainicio);
    }
    
    public List<Convocatoria> getAllConvocatoriasByresponsablepp(Long idresponsableppp) {
        return convocatoriaRepository.findByidresponsableppp(idresponsableppp);
    }
    public Optional<Convocatoria> getOne(Long id) {
        return convocatoriaRepository.findById(id);
    }

    public GenericResponse<Object> saveConvocatoria(Convocatoria convocatoria,Long idcarrera,Long idresponsableppp) {
    	GenericResponse<Object> response = new GenericResponse<>();
    	
    	if ((carreraRepository.findById(idcarrera).isEmpty())
				&& (responsableRepository.findById(idresponsableppp).isEmpty()) == true) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject(
					"No se puede crear la convocatoria porque no se encontró la carrera o el responsable de practicas");
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		} else {
			convocatoria.setEstado(1);
			convocatoria.setCarrera(carreraRepository.findById(idcarrera).get());
			convocatoria.setResponsable(responsableRepository.findById(idresponsableppp).get());
			convocatoriaRepository.save(convocatoria);
			response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
			response.setObject("La convocatoria se ha creado");
			response.setStatus(ParametersApp.SUCCESSFUL.value());
		}

		return response;
    }

    public boolean existsById(Long id) {
        return convocatoriaRepository.existsById(id);
    }

    public GenericResponse<Object> putActividad(Long idconvocatoria, String documento,String requisitos, String actividades, Date fecha_inicio, Date fecha_fin) {
        GenericResponse<Object> response = new GenericResponse<>();
        Convocatoria convocatoria = convocatoriaRepository.findById(idconvocatoria).get();
        if (convocatoria.getIdconvocatoria() != null) {
            convocatoria.setDocumento(documento.toUpperCase());
            convocatoria.setRequisitos(requisitos.toUpperCase());
            convocatoria.setActividades(actividades.toUpperCase());
            convocatoria.setFechainicio(fecha_inicio);
            convocatoria.setFechafin(fecha_fin);
            convocatoriaRepository.save(convocatoria);
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

    public Optional<Convocatoria> getOne(long id) {
        return convocatoriaRepository.findById(id);
    }
    
    public GenericResponse<Object> deleteConvocatoria(Long idconvocatoria) {
    	GenericResponse<Object> response = new GenericResponse<>();
    	Convocatoria convocatoria = convocatoriaRepository.findById(idconvocatoria).get();
    	
    	   if (convocatoria.getIdconvocatoria() != null) {
    		   convocatoria.setEstado(0);
               convocatoriaRepository.save(convocatoria);
               response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
               response.setObject("Eliminado correctamente");
               response.setStatus(ParametersApp.SUCCESSFUL.value());
           } else {
               response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
               response.setObject("Error al eliminar");
               response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
           }
           return response;
    }
    public GenericResponse<Object> HabilitarConvocatoria(Long idconvocatoria) {
    	GenericResponse<Object> response = new GenericResponse<>();
    	Convocatoria convocatoria = convocatoriaRepository.findById(idconvocatoria).get();
    	
    	   if (convocatoria.getIdconvocatoria() != null) {
    		   convocatoria.setEstado(1);
               convocatoriaRepository.save(convocatoria);
               response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
               response.setObject("Convocatoria habilitada correctamente");
               response.setStatus(ParametersApp.SUCCESSFUL.value());
           } else {
               response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
               response.setObject("Error al eliminar");
               response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
           }
           return response;
    }

}
