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

import com.ProyectoTDSBackend.models.Estudiante;
import com.ProyectoTDSBackend.models.EstudianteRelDoc;
import com.ProyectoTDSBackend.service.EstudianteRelDocService;
import com.ProyectoTDSBackend.service.EstudianteService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estudiantedocumento")
@CrossOrigin({ "*" })
public class EstudianteDocumentoController {
	
	@Autowired
	EstudianteRelDocService estdocService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	 @CrossOrigin({"*"})
	    @PostMapping("/asignar-DocumentoAestudiante")
	    ResponseEntity<GenericResponse<Object>> saveVinculacion(@RequestBody EstudianteRelDoc estdoc,
	    		@RequestParam(value = "idestudiante")Long idestudiante,@RequestParam(value = "iddocumento")Long iddocumento) {
	        return new ResponseEntity<GenericResponse<Object>>(estdocService.aginarDocumentoAEstudiante(estdoc, idestudiante, iddocumento), HttpStatus.OK);
	    }
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-estudiante")
	    public List<EstudianteRelDoc> getBIdEstudiante(@RequestParam(value = "idestudiante") Long idestudiante) {
	        return estdocService.FindByestudiante(idestudiante);
	    }
	 
//Listar todas las personas
	@ApiOperation("Muestra el listado de documentos asignados a cada estudiante")
	 @CrossOrigin({"*"})
	@GetMapping("/findAll-Documentos")
	public List<EstudianteRelDoc> getAllDocsEstudiante() {
		return estdocService.getAllDocsEstudiantes();
	}

}
