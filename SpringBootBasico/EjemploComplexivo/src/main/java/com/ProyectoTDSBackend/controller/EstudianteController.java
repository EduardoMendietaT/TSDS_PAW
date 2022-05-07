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
import com.ProyectoTDSBackend.service.EstudianteService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/estudiante")
@CrossOrigin({ "*" })
public class EstudianteController {
	
	@Autowired
	EstudianteService estudianteService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	 @CrossOrigin({"*"})
	    @PostMapping("/add-estudiante")
	    ResponseEntity<GenericResponse<Object>> saveVinculacion(@RequestBody Estudiante estudiante, @RequestParam(value = "idpersona") int idpersona) {
	        return new ResponseEntity<GenericResponse<Object>>(estudianteService.createEstudiante(estudiante, idpersona), HttpStatus.OK);
	    }
	 @GetMapping("/getById-estudiantes")
	    public Estudiante getByIPersona(@RequestParam(value = "idestudiante") Long idestudiante) {
	        return estudianteService.getById(idestudiante);
	    }
//Listar todas las personas
	@ApiOperation("Muestra el listado de estudiantes")
	 @CrossOrigin({"*"})
	@GetMapping("/findAll-Personas")
	public List<Estudiante> getAllPersonas() {
		return estudianteService.getAllEstudiantes();
	}

}
