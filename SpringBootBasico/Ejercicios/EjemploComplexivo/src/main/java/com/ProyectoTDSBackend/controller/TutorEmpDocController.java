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

import com.ProyectoTDSBackend.models.TutorEmpDocument;
import com.ProyectoTDSBackend.service.TutorEmpDocService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tutorEmpDocumento")
@CrossOrigin({ "*" })
public class TutorEmpDocController {

	
	@Autowired
	TutorEmpDocService tutdocService;
	
	
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	 @CrossOrigin({"*"})
	    @PostMapping("/asignar-DocumentoAtutorEmpresarial")
	    ResponseEntity<GenericResponse<Object>> saveasignaciontutorAcademico(@RequestBody TutorEmpDocument tutordoc,
	    		@RequestParam(value = "iddocumento")Long iddocumento,@RequestParam(value = "idtutoremp")Long idtutoremp) {
	        return new ResponseEntity<GenericResponse<Object>>(tutdocService.asignarDocumentoATutorEmp(tutordoc, iddocumento, idtutoremp), HttpStatus.OK);
	    }
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-tutorEmpresarial")
	    public List<TutorEmpDocument> getByIdTutorEmpresarial(@RequestParam(value = "idtutoremp") Long idtutoremp) {
	        return tutdocService.FindBytutorempresarial(idtutoremp);
	    }
	 
//Listar todoso los documentos asignados a los tutores empresariles
	 
	@ApiOperation("Muestra el listado de documentos asignados ")
	 @CrossOrigin({"*"})
	@GetMapping("/findAll-Documentos")
	public List<TutorEmpDocument> getAllDocsEstudiante() {
		return tutdocService.getAllDocumentosAsingnados();
	}
}
