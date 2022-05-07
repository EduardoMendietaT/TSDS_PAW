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

import com.ProyectoTDSBackend.models.TutorEmpresarial;
import com.ProyectoTDSBackend.service.TutorEmpresarialService;
import com.ProyectoTDSBackend.service.implement.TutorEmpresarialImpl;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tutorempresarial")
@CrossOrigin({ "*" })
public class TutorEmpresController {
	
	
	@Autowired
	TutorEmpresarialImpl tutorEService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	 @CrossOrigin({"*"})
	    @PostMapping("/asignar-tutorEmpresarial")
	    ResponseEntity<GenericResponse<Object>> saveasignaciontutorEmpresarial(@RequestBody TutorEmpresarial tutor,
	    		@RequestParam(value = "idempresa")Long idempresa) {
	        return new ResponseEntity<GenericResponse<Object>>(tutorEService.createTutorEmpresarial(tutor, idempresa), HttpStatus.OK);
	    }
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-tutorempresarial")
	    public TutorEmpresarial getBIdTutor(@RequestParam(value = "idtutoremp") Long idtutoremp) {
	        return tutorEService.getById(idtutoremp);
	    }
	 
	@ApiOperation("Muestra el listado de empresas con los  tutor empresariales asignados")
	 @CrossOrigin({"*"})
	@GetMapping("/findAll-Tutores")
	public List<TutorEmpresarial> getAllDocsTutoresEmpresariales() {
		return tutorEService.getAllTutores();
	}


}
