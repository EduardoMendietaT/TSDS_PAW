package com.ProyectoTDSBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Estado;
import com.ProyectoTDSBackend.repository.EstadoRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	
	public GenericResponse getbyId(Long idestado) {
		GenericResponse<Object> response = new GenericResponse<>();
		   try {
	            if (estadoRepository.findByidestado(idestado) != null) {
	                Estado estado = estadoRepository.findByidestado(idestado);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject(estado);
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            } else {
	                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                response.setObject("Estado no encontrado");
	                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            }
	        } catch (Exception e) {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("ERROR " + e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	}
	
	
	
	    public GenericResponse<Object> createEstado(Estado estado) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        try {
	            if (estadoRepository.findBydescripcion(estado.getDescripcion().toUpperCase()) == null){
	                estado.setDescripcion(estado.getDescripcion().toUpperCase());
	                estado.setColor(estado.getColor());
	                estadoRepository.save(estado);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject("Estado :"+estado.getDescripcion()+" creado exitosamente como Estado");
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            } else {
	                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                response.setObject("Nombre de Empresa en Empresa duplicado");
	                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            }
	        }catch (Exception e){
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error: "+e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	    }
	    
	    public GenericResponse<Object> putEstado(Long idestado, String descripcion,String color) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        Estado estado = estadoRepository.findByidestado(idestado);
	        if (estado.getIdestado() != null ) {
	            estado.setDescripcion(descripcion.toUpperCase());
	            estado.setColor(color.toUpperCase());
	            estadoRepository.save(estado);
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
	    
	    public Estado getbydescripcion(String descripcion) {
			return estadoRepository.findBydescripcion(descripcion);
		}
	    public List<Estado> getAllEstados() {
	        return estadoRepository.findAll();
	    }
	    
	    public boolean existsBydescripcion(String descripcion) {
	        return estadoRepository.existsBydescripcion(descripcion);
	    }
}
