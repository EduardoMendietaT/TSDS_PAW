package com.ProyectoTDSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTDSBackend.models.EstudianteRelDoc;
import com.ProyectoTDSBackend.service.EstudiantAsignaturaService;
import com.ProyectoTDSBackend.service.EstudianteRelDocService;
import com.ProyectoTDSBackend.util.GenericResponse;

import com.ProyectoTDSBackend.models.EstudiantAsignatura;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estudianteasignatura")
@CrossOrigin({ "*" })
public class EstudianteAsignaturaController {

	
	@Autowired
	EstudiantAsignaturaService asignacionService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	@ApiOperation("Permite añadir una asignatura a un estudiante")
	 @CrossOrigin({"*"})
	    @PostMapping("/add-asignar-AsignaturaAestudiante")
	    ResponseEntity<GenericResponse<Object>> saveVinculacion(@RequestBody EstudiantAsignatura asignacion,
	    		@RequestParam(value = "promedio")double promedio,
	    		@RequestParam(value = "idestudiante")Long idestudiante,@RequestParam(value = "idasignatura")Long idasignatura) {
	        return new ResponseEntity<GenericResponse<Object>>(asignacionService.saveAsignacionEstDoc(asignacion,promedio, idestudiante, idasignatura), HttpStatus.OK);
	    }
	 @ApiOperation("Muestra un estudiante y sus datos por id del estudiante")
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-estudiante")
	    public List<EstudiantAsignatura> getBIdEstudiante(@RequestParam(value = "idestudiante") Long idestudiante) {
	        return asignacionService.getByIdestudiante(idestudiante);
	    }
	 
	@ApiOperation("Muestra el listado de asignaturas asignadas a cada estudiante")
	 @CrossOrigin({"*"})
	@GetMapping("/findAll-Documentos")
	public List<EstudiantAsignatura> getAllAsignaturasEstudiante() {
		return asignacionService.getlListarEstudiantesDocumentos();
	}
}
