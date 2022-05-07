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

import com.ProyectoTDSBackend.models.TutorAcadDocumento;
import com.ProyectoTDSBackend.service.TutorAcadDocService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tutorAcedemicoDocumento")
@CrossOrigin({ "*" })
public class TutorAcadDocController {
	
	@Autowired
	TutorAcadDocService tutdocService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	 @CrossOrigin({"*"})
	    @PostMapping("/asignar-Documentotutoracademico")
	    ResponseEntity<GenericResponse<Object>> saveasignaciontutorAcademico(@RequestBody TutorAcadDocumento tutordoc,
	    		@RequestParam(value = "iddocumento")Long iddocumento,@RequestParam(value = "idtutoracad")Long idtutoracad) {
	        return new ResponseEntity<GenericResponse<Object>>(tutdocService.asignarDocumentoATutor(tutordoc, iddocumento, idtutoracad), HttpStatus.OK);
	    }
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-tutoracademico")
	    public List<TutorAcadDocumento> getByIdtutoracademico(@RequestParam(value = "idtutoracad") Long idtutoracad) {
	        return tutdocService.FindBytutoracademico(idtutoracad);
	    }
	 
//Listar todas los documentos
	@ApiOperation("Muestra el listado de documentos asignados a cada tutor academico")
	 @CrossOrigin({"*"})
	@GetMapping("/findAll-Documentos")
	public List<TutorAcadDocumento> getAllDocsTutores() {
		return tutdocService.getAllDocumentosAsingnados();
	}

}
