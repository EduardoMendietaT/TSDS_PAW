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

import com.ProyectoTDSBackend.models.ResponsablePPP;
import com.ProyectoTDSBackend.service.ResponsablePPService;
import com.ProyectoTDSBackend.service.VinculacionService;
import com.ProyectoTDSBackend.util.GenericResponse;

@RestController
@RequestMapping("/responsableppp")
@CrossOrigin({ "*" })
public class ResponsablePPPController {
	
	
	@Autowired
	ResponsablePPService responsableService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	 @CrossOrigin({"*"})
	    @PostMapping("/add-ResponsablePPP")
	    ResponseEntity<GenericResponse<Object>> saveResponsablePPp(@RequestBody ResponsablePPP responsable, @RequestParam(value = "idcarrera") Long idcarrera, @RequestParam(value = "idpersona") int idpersona) {
	        return new ResponseEntity<GenericResponse<Object>>(responsableService.createResponsablePPP(responsable, idcarrera, idpersona), HttpStatus.OK);
	    }

	 
	 @CrossOrigin({"*"})
	    @GetMapping("/findAll-ResponsablePPP")
	    public List<ResponsablePPP> getAllResponsables() {
	        return responsableService.getAllResponsablesPPP();
	    }
	   
	
	 @CrossOrigin({"*"})
	    @GetMapping("/getById-Responsable")
	    public ResponsablePPP getByIdResponsable(@RequestParam(value = "idresponsableppp") Long idresponsableppp) {
	        return responsableService.getById(idresponsableppp);
	    }
	


}
