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

import com.ProyectoTDSBackend.models.Coordinador;
import com.ProyectoTDSBackend.service.CoordinadorService;
import com.ProyectoTDSBackend.util.GenericResponse;

@RestController
@RequestMapping("/coordinador")
@CrossOrigin({ "*" })
public class CoordinadorController {
	
	@Autowired
	CoordinadorService coordinadorService;
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
		@CrossOrigin({"*"})
	    @PostMapping("/add-coordinador")
	    ResponseEntity<GenericResponse<Object>> saveCoordinador(@RequestBody Coordinador coordinador, @RequestParam(value = "idcarrera") Long idcarrera, @RequestParam(value = "idpersona") int idpersona) {
	        return new ResponseEntity<GenericResponse<Object>>(coordinadorService.createCoordinador(coordinador,idcarrera,idpersona), HttpStatus.OK);
	    }
	 
	 	@CrossOrigin({"*"})
	    @GetMapping("/findAll-Coordinadores")
	    public List<Coordinador> getAllCoordinadores() {
	        return coordinadorService.getAllCoordinadores();
	    }
	 
	    /**
	     * CONSTRUCCION DEL METODO PUT PARA ACTUALIZAR DATOS DEL coordinador
	     */
	 	 @CrossOrigin({"*"})
	    @PostMapping("/put-coordinador")
	    ResponseEntity<GenericResponse<Object>> putCoordinador(
	    		 @RequestParam(value = "idpersona") int idpersona,
	    		@RequestParam(value = "idcoordinador") Long idcoordinador,
	            @RequestParam(value = "identificacion") String identificacion,
	            @RequestParam(value = "primernombre") String primernombre,
	            @RequestParam(value = "segundonombre") String segundonombre,
	            @RequestParam(value = "primerapellido") String primerapellido,
	            @RequestParam(value = "segundoapellido") String segundoapellido,
	            @RequestParam(value = "email") String email,
	            @RequestParam(value = "contacto") int contacto
	    ) {
	        return new ResponseEntity<GenericResponse<Object>>(coordinadorService.putCoordinador(idpersona, idcoordinador, identificacion, primernombre, segundonombre, primerapellido, segundoapellido, email, contacto), HttpStatus.OK);
	    }
	 	@CrossOrigin({"*"})
	    @GetMapping("/getById-coordinador")
	    public Coordinador getByICoordinador(@RequestParam(value = "idcoordinador") Long idcoordinador) {
	        return coordinadorService.getById(idcoordinador);
	    }
	   
	

}
