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

import com.ProyectoTDSBackend.models.ResponsablePPDocumento;
import com.ProyectoTDSBackend.service.ResponsablePPDocService;
import com.ProyectoTDSBackend.util.GenericResponse;

@RestController
@RequestMapping("/responsableppdocontroller")
@CrossOrigin({ "*" })
public class ResponsablePPDocController {

	@Autowired
	ResponsablePPDocService responsableService;

	/**
	 * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
	 */
	@CrossOrigin({ "*" })
	@PostMapping("/add-asignardocumentoaresponsable")
	ResponseEntity<GenericResponse<Object>> saveResponsablePPp(@RequestBody ResponsablePPDocumento responsable,
			@RequestParam(value = "iddocumento")Long iddocumento,
			@RequestParam(value = "idresponsableppp")Long idresponsableppp) {
		return new ResponseEntity<GenericResponse<Object>>(
				responsableService.asignarDocumentoATutor(responsable,iddocumento,idresponsableppp), HttpStatus.OK);
	}

	@CrossOrigin({ "*" })
	@GetMapping("/findAll-DocsResponsablePPP")
	public List<ResponsablePPDocumento> getAllDocsResponsables() {
		return responsableService.getAllDocumentosAsingnados();
	}

	@CrossOrigin({ "*" })
	@GetMapping("/getById-Responsable")
	public List<ResponsablePPDocumento> getByIdResponsable(
			@RequestParam(value = "idresponsableppp")Long idresponsableppp) {
		return responsableService.FindByResponsablePPP(idresponsableppp);
	}

}
