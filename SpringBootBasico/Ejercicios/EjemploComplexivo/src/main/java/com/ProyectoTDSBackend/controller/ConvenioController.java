package com.ProyectoTDSBackend.controller;

import java.util.Date;
import java.util.List;

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

import com.ProyectoTDSBackend.models.Convenio;
import com.ProyectoTDSBackend.service.ConvenioService;
import com.ProyectoTDSBackend.util.GenericResponse;


@RestController
@RequestMapping("/convenio")
@CrossOrigin({ "*" })
public class ConvenioController {
	
	@Autowired
	ConvenioService convenioService;
	
	 @CrossOrigin({"*"})
	    @PostMapping("/add-convenio")
	    ResponseEntity<GenericResponse<Object>> saveConvenio(@RequestBody Convenio convenio, @RequestParam(value = "idempresa") Long idempresa,
	    		@RequestParam(value = "idvinculacion") Long idvinculacion, @RequestParam(value = "idcoordinador") Long idcoordinador) {
	        return new ResponseEntity<GenericResponse<Object>>(convenioService.createConvenio(convenio, idempresa, idvinculacion, idcoordinador), HttpStatus.OK);
	    }

	 
	 	@CrossOrigin({"*"})
	    @GetMapping("/findAll-convenios")
	    public List<Convenio> getAllConvenios() {
	        return convenioService.getAllConvenio();
	    }
	   
	    /**
	     * CONSTRUCCION DEL METODO PUT PARA ACTUALIZAR DATOS DE Convenio
	     */
	 	 @CrossOrigin({"*"})
	    @PostMapping("/put-convenio")
	    ResponseEntity<GenericResponse<Object>> putConvenio(
	    		 @RequestParam(value = "idconvenio") Long idconvenio,
	    		@RequestParam(value = "idcoordinador") Long idcoordinador,
	            @RequestParam(value = "idempresa") Long idempresa,
	            @RequestParam(value = "idvinculacion") Long idvinculacion,
	            @RequestParam(value = "descripcionconvenio") String descripcionconvenio,
	            @RequestParam(value = "fechaconvenio", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaconvenio
	    ) {
	        return new ResponseEntity<GenericResponse<Object>>(convenioService.putConvenio(idconvenio, idcoordinador, idempresa, idvinculacion, descripcionconvenio, fechaconvenio), HttpStatus.OK);
	    }

}
