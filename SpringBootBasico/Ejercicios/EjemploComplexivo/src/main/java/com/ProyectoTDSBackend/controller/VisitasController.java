package com.ProyectoTDSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTDSBackend.models.TutorAcadDocumento;
import com.ProyectoTDSBackend.service.SeguimientoService;
import com.ProyectoTDSBackend.service.TutorAcadDocService;
import com.ProyectoTDSBackend.service.VisitasService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/anexos/")
@CrossOrigin({ "*" })
public class VisitasController {

	@Autowired
	VisitasService visitasService;
	
	
	 /**
     * CONSTRUCCION DEL METODO PARA GENERAR EL REGISTRO DE SEGUIMIENTO
     */
	@GetMapping(value="anexo11", produces= MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody ResponseEntity<Object> getReportJasper(@RequestParam(name = "persona") Integer personaId){
		byte[] media = visitasService.getJasperReport(1);
		return ResponseEntity.ok(media);
	}
	 
}

