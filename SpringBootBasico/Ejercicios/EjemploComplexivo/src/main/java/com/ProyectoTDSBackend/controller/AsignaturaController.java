/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.controller;

import com.ProyectoTDSBackend.models.Asignatura;
import com.ProyectoTDSBackend.service.AsignaturaService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Asignatura")
@CrossOrigin({ "*" })
public class AsignaturaController {

	@Autowired
	AsignaturaService asignaturaService;

//Listar todas las empresas
	@ApiOperation("Listado de las asignaturas")
	@CrossOrigin({ "*" })
	@GetMapping("/findAll-asignaturas")
	public List<Asignatura> getAllAsignaturas() {
		return asignaturaService.getlListaAsignaturas();
	}

	//
	@PostMapping("/add-createAsignatura")
	@CrossOrigin({"*"})
	public ResponseEntity<GenericResponse<Object>> saveAsignatura(@RequestBody Asignatura asignatura,
			@RequestParam(value = "idcarrera") Long idcarrera) {
		return new ResponseEntity<GenericResponse<Object>>(asignaturaService.saveAsignatura(asignatura, idcarrera),
				HttpStatus.OK);
	}
	
	 @CrossOrigin({"*"})
    @PostMapping("/put-Asignatura")
    ResponseEntity<GenericResponse<Object>> putAsignatura(
    		 @RequestParam(value = "idasignatura") Long idasignatura,
    		@RequestParam(value = "nombreasignatura") String nombreasignatura,
    		@RequestParam(value = "fechacreacion", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechacreacion,
            @RequestParam(value = "idcarrera") Long idcarrera
            
    ) {
        return new ResponseEntity<GenericResponse<Object>>(asignaturaService.putAsignatura(idasignatura, nombreasignatura, fechacreacion, idcarrera), HttpStatus.OK);
    }
	 @CrossOrigin({"*"})
    @GetMapping("/getById-Asignatura")
    public Optional<Asignatura> getByIdAsignatura(@RequestParam(value = "idasignatura") Long idasignatura) {
        return asignaturaService.getOne(idasignatura);
    }

}
