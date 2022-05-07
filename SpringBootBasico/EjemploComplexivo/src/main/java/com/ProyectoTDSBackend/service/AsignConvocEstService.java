package com.ProyectoTDSBackend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.AsignacionConvocatoriaEstudiantes;
import com.ProyectoTDSBackend.models.Convocatoria;
import com.ProyectoTDSBackend.repository.AsignConvocEstRepository;
import com.ProyectoTDSBackend.repository.CarreraRepository;
import com.ProyectoTDSBackend.repository.ConvocatoriaRepository;
import com.ProyectoTDSBackend.repository.EstadoRepository;
import com.ProyectoTDSBackend.repository.EstudianteRepository;
import com.ProyectoTDSBackend.repository.ResponsablePPRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.LongArraySerializer;

@Service
public class AsignConvocEstService {

	@Autowired
	AsignConvocEstRepository asignacionConvEst;
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Autowired
	ConvocatoriaRepository convocatoriaRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
    public List<AsignacionConvocatoriaEstudiantes> getAllAsignaciones() {
        return asignacionConvEst.findAll();
    }
    
    public GenericResponse<Object> saveAsignacion(AsignacionConvocatoriaEstudiantes asignacion,Long idestudiante,Long idconvocatoria) {
    	GenericResponse<Object> response = new GenericResponse<>();
    	
    	if ((estudianteRepository.findById(idestudiante).isEmpty())
				&& (convocatoriaRepository.findById(idconvocatoria).isEmpty()) == true) {
			response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
			response.setObject(
					"No se puede asignar al estudiante porque no se encontró la convocatoria");
			response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
		} else {
		Long id =Integer.toUnsignedLong(1);
			asignacion.setEstado(estadoRepository.findByidestado(id));
			asignacion.setEstudiante(estudianteRepository.findById(idestudiante).get());
			asignacion.setConvocatoria(convocatoriaRepository.findById(idconvocatoria).get());
			asignacionConvEst.save(asignacion);
			response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
			response.setObject("La asingacion del estudiante a la convocato se ha creado");
			response.setStatus(ParametersApp.SUCCESSFUL.value());
		}

		return response;
    }

    public GenericResponse<Object> putasignacion(Long idasigestudconvocatoria, String documento,Date fechaenvio,Long idconvocatoria,Long idestudiante) {
        GenericResponse<Object> response = new GenericResponse<>();
       AsignacionConvocatoriaEstudiantes asignacion = asignacionConvEst.findById(idasigestudconvocatoria).get();
        if (asignacion.getIdasigestudconvocatoria() != null) {
            asignacion.setDocumento(documento.toUpperCase());
            asignacion.setFechaenvio(fechaenvio);
            asignacionConvEst.save(asignacion);
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
    
    public List<AsignacionConvocatoriaEstudiantes> getbyidconvocatoria(Long idconvocatoria){
    	return asignacionConvEst.findidconvocatoria(idconvocatoria);
    }
    
    public List<AsignacionConvocatoriaEstudiantes> getbyidestudiante(Long idestudiante){
    	return asignacionConvEst.findidestudiante(idestudiante);
    }
    public List<AsignacionConvocatoriaEstudiantes> getbyidestado(Long idestado){
    	return asignacionConvEst.findidestado(idestado);
    }
    
    public GenericResponse<Object> deleteasignacion(Long idasigestudconvocatoria) {
    	GenericResponse<Object> response = new GenericResponse<>();
    	AsignacionConvocatoriaEstudiantes asignacion = asignacionConvEst.findByidasigestudconvocatoria(idasigestudconvocatoria);
    	   if (asignacion.getIdasigestudconvocatoria() != null) {
    		   asignacionConvEst.delete(asignacion);
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
	
}
