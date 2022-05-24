package com.ProyectoTDSBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Carrera;
import com.ProyectoTDSBackend.models.Estado;
import com.ProyectoTDSBackend.repository.CarreraRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;

@Service
public class CarreraService {
	
	@Autowired
	CarreraRepository carreraRepository;
	
	public GenericResponse getbyId(Long idcarrera) {
		GenericResponse<Object> response = new GenericResponse<>();
		   try {
	            if (carreraRepository.findByidcarrera(idcarrera) != null) {
	                Carrera carrera = carreraRepository.findByidcarrera(idcarrera);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject(carrera);
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            } else {
	                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                response.setObject("Carrera no encontrada");
	                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            }
	        } catch (Exception e) {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("ERROR " + e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	}
	
	
	
	    public GenericResponse<Object> createCarrera(Carrera carrera) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        try {
	            if (carreraRepository.findBynombre(carrera.getNombre().toUpperCase()) == null){
	                carrera.setDescripcion(carrera.getDescripcion().toUpperCase());
	                carreraRepository.save(carrera);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject("Carrera :"+carrera.getNombre()+" creado exitosamente como Carrera");
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            } else {
	                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                response.setObject("Nombre Carrera en Carrera duplicado");
	                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            }
	        }catch (Exception e){
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("Error: "+e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	    }
	    
	    public GenericResponse<Object> putCarrera(Long idcarrera, String descripcion,String nombre) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        Carrera carrera =carreraRepository.findByidcarrera(idcarrera);
	        if (carrera.getIdcarrera() != null ) {
	            carrera.setDescripcion(descripcion.toUpperCase());
	            carrera.setNombre(nombre.toUpperCase());
	            carreraRepository.save(carrera);
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
	    
	    public Carrera getbynombre(String nombre) {
			return carreraRepository.findBynombre(nombre);
		}
	    public List<Carrera> getAllCarreras() {
	        return carreraRepository.findAll();
	    }
	    
	    public boolean existsBynombre(String nombre) {
	        return carreraRepository.existsBynombre(nombre);
	    }

}
