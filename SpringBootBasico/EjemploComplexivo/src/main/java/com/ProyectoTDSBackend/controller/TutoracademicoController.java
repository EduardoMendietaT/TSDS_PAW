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
import com.ProyectoTDSBackend.models.TutorAcademico;
import com.ProyectoTDSBackend.service.TutorAcadService;
import com.ProyectoTDSBackend.util.GenericResponse;

@RestController
@RequestMapping("/tutoracademico")
@CrossOrigin({ "*" })
public class TutoracademicoController {
	
	@Autowired
	TutorAcadService tutoracadService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	 @CrossOrigin({"*"})
	    @PostMapping("/add-TutorAcademico")
	    ResponseEntity<GenericResponse<Object>> saveTutorAcademico(@RequestBody TutorAcademico tutor, @RequestParam(value = "idcarrera") Long idcarrera, @RequestParam(value = "idpersona") int idpersona) {
	        return new ResponseEntity<GenericResponse<Object>>(tutoracadService.createTutorAcademico(tutor, idcarrera, idpersona), HttpStatus.OK);
	    }

	 
	 @CrossOrigin({"*"})
	    @GetMapping("/findAll-Tutores")
	    public List<TutorAcademico> getAllTutores() {
	        return tutoracadService.getAllTutoresAcademicos();
	    }
	   
	
	 @CrossOrigin({"*"})
	    @GetMapping("/getById-Tutor")
	    public TutorAcademico getByIdTutor(@RequestParam(value = "idtutoracad") Long idtutoracad) {
	        return tutoracadService.getById(idtutoracad);
	    }

}
