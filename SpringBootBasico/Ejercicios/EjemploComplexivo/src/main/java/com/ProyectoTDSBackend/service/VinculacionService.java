package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.models.Vinculacion;
import com.ProyectoTDSBackend.util.GenericResponse;


public interface VinculacionService {


	 GenericResponse<Object> createVinculacion(Vinculacion vinculacion,int idpersona);

	    GenericResponse<Object> putVinculacion(int idPersona, Long idvinculacion, String identificacion, String primernombre, String segundonombre,String primerapellido,String SegundoApellido, String email);

	    List<Vinculacion> getAllVinculaciones();

	    Vinculacion getById(Long idvinculacion);
	    
	    List<Vinculacion> getByrolvinculacion(String rolvinculacion);

	    //GenericResponse<Object> eliminarvinculacionById(Long idvinculacion);

}
