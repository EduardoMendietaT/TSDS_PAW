package com.ProyectoTDSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Carrera;
import com.ProyectoTDSBackend.service.CarreraService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/carrera")
@CrossOrigin({ "*" })
public class CarreraController {
	
	@Autowired
	CarreraService carreraService;
	
	@ApiOperation("Extraer por nombre")
	 @CrossOrigin({"*"})
	@GetMapping("/carrera/{nombre}")
	public ResponseEntity<Carrera> getByNombre(@PathVariable("nombre") String nombre) {

		if (!carreraService.existsBynombre(nombre)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		Carrera carrera = carreraService.getbynombre(nombre);
		return new ResponseEntity(carrera, HttpStatus.OK);
	}
//Listar todas las carreras
	@ApiOperation("Muestra el listado de carreras")
	 @CrossOrigin({"*"})
	@GetMapping("/findAll-Carreras")
	public List<Carrera> getAllCarreras() {
		return carreraService.getAllCarreras();
	}
	
	@ApiOperation("Permite añadir carreras")
	 @CrossOrigin({"*"})
	@PostMapping("/add-Carrera")
	ResponseEntity<GenericResponse<Object>> saveCarrero(@RequestBody Carrera carrera) {
		return new ResponseEntity<GenericResponse<Object>>(carreraService.createCarrera(carrera), HttpStatus.OK);
	}
	@ApiOperation("Actualizar campos de carrera")
	 @CrossOrigin({"*"})
	    @PostMapping("/put-carrera")
	    ResponseEntity<GenericResponse<Object>> putCarrera(
	            @RequestParam(value = "idcarrera") Long idcarrera,
	            @RequestParam(value = "descripcion") String descripcion,
	            @RequestParam(value = "nombre") String nombre
	    ) {
	        return new ResponseEntity<GenericResponse<Object>>(carreraService.putCarrera(idcarrera, descripcion, nombre), HttpStatus.OK);
	    }

}
