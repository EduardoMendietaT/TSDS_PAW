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
import com.ProyectoTDSBackend.models.Estado;
import com.ProyectoTDSBackend.service.EstadoService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estado")
@CrossOrigin({ "*" })
public class EstadoController {
	@Autowired
	EstadoService estadoService;

	
	@ApiOperation("Extraer por descripción de estado")
	 @CrossOrigin({"*"})
	@GetMapping("/{descripcion}")
	public ResponseEntity<Estado> getByDescripcion(@PathVariable("descripcion") String descripcion) {

		if (!estadoService.existsBydescripcion(descripcion)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		Estado empresa = estadoService.getbydescripcion(descripcion);
		return new ResponseEntity(empresa, HttpStatus.OK);
	}
	
	@ApiOperation("Muestra el listado de estados descripción y color")
	 @CrossOrigin({"*"})
	@GetMapping("/findAll-Estado")
	public List<Estado> getAllEstados() {
		return estadoService.getAllEstados();
	}
//añadir un estado
	@ApiOperation("Permite añadir estados")
	 @CrossOrigin({"*"})
	@PostMapping("/add-Estado")
	ResponseEntity<GenericResponse<Object>> saveEstado(@RequestBody Estado estado) {
		return new ResponseEntity<GenericResponse<Object>>(estadoService.createEstado(estado), HttpStatus.OK);
	}
	@ApiOperation("Actualizar campos de estado")
	 @CrossOrigin({"*"})
	    @PostMapping("/put-estado")
	    ResponseEntity<GenericResponse<Object>> putEstado(
	            @RequestParam(value = "idestado") Long idestado,
	            @RequestParam(value = "descripcion") String descripcion,
	            @RequestParam(value = "color") String color
	    ) {
	        return new ResponseEntity<GenericResponse<Object>>(estadoService.putEstado(idestado, descripcion, color), HttpStatus.OK);
	    }
}
