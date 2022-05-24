package com.ProyectoTDSBackend.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTDSBackend.models.Empresa;
import com.ProyectoTDSBackend.repository.EmpresaRepository;
import com.ProyectoTDSBackend.util.GenericResponse;
import com.ProyectoTDSBackend.util.ParametersApp;
@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;

	public GenericResponse getbyId(Long idempresa) {
		GenericResponse<Object> response = new GenericResponse<>();
		   try {
	            if (empresaRepository.findByidempresa(idempresa) != null) {
	                Empresa empresa = empresaRepository.findByidempresa(idempresa);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject(empresa);
	                response.setStatus(ParametersApp.SUCCESSFUL.value());
	            } else {
	                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	                response.setObject("Empresa no encontrado");
	                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	            }
	        } catch (Exception e) {
	            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
	            response.setObject("ERROR " + e);
	            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
	        }
	        return response;
	}
	
	
	
	    public GenericResponse<Object> createEmpresa(Empresa empresa) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        try {
	            if (empresaRepository.findBynombreempresa(empresa.getNombreempresa().toUpperCase()) == null){
	                empresa.setNombreempresa(empresa.getNombreempresa().toUpperCase());
	                empresa.setEstado(1);
	                empresaRepository.save(empresa);
	                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
	                response.setObject("Empresa :"+empresa.getNombreempresa()+" creado exitosamente como Empresa");
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
	    
	    public GenericResponse<Object> putEmpresa(Long idempresa, String nombreempresa,String direccion,String descripcion,String email, String contacto) {
	        GenericResponse<Object> response = new GenericResponse<>();
	        Empresa empresa = empresaRepository.findById(idempresa).get();
	        if (empresa.getIdempresa() != null ) {
	            empresa.setNombreempresa(nombreempresa.toUpperCase());
	            empresa.setDireccion(direccion.toUpperCase());
	            empresa.setDescripcion(descripcion.toUpperCase());
	            empresa.setEmail(email.toUpperCase());
	            empresa.setContacto(contacto);
	
	            empresaRepository.save(empresa);
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
	    
	    
	    public List<Empresa> getAllEmpresasHabilitados() {
	        return empresaRepository.findByEstado(1);
	    }
	    
	    public Empresa getbynombre(String nombreempresa) {
			return empresaRepository.findBynombreempresa(nombreempresa);
		}
	    
	    public boolean existsByNombre(String nombremepresa) {
	        return empresaRepository.existsBynombreempresa(nombremepresa);
	    }

	    public Optional<Empresa> getOne(Long idempresa) {
	        return empresaRepository.findById(idempresa);
	    }
	    
	    public void save(Empresa empresa) {
	        empresaRepository.save(empresa);
	    }
	    
	 
}
