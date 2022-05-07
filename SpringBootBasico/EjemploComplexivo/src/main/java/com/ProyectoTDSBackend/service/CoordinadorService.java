package com.ProyectoTDSBackend.service;

import java.util.List;

import com.ProyectoTDSBackend.models.Coordinador;
import com.ProyectoTDSBackend.util.GenericResponse;

public interface CoordinadorService {

	GenericResponse<Object> createCoordinador(Coordinador coordinador,Long idcarrera,int idpersona);

	GenericResponse<Object> putCoordinador(int idPersona, Long idcoordinador, String identificacion,
			String primernombre, String segundonombre, String primerapellido, String SegundoApellido, String email,int contacto);

	List<Coordinador> getAllCoordinadores();

	Coordinador getById(Long idcoordinador);

}
