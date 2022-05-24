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

import com.ProyectoTDSBackend.models.Asigtutorempacad;
import com.ProyectoTDSBackend.models.Coordinador;
import com.ProyectoTDSBackend.models.TutorEmpresarial;
import com.ProyectoTDSBackend.service.AsigtutorempacadService;
import com.ProyectoTDSBackend.service.CoordinadorService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Asignación a estudiante")
@CrossOrigin({"*"})
public class AsignacionEstTeTaController {

	
	@Autowired
	AsigtutorempacadService asignacionService;
	 /**
     * CONSTRUCCION DEL METODO POST PARA SOLICITAR LA CREACION DE UN NUEVO REGISTRO
     */
	@ApiOperation("Recibe los parametros de tutores/academico/empresarial y estudiante")
	 @CrossOrigin({"*"})
	    @PostMapping("/add-asignartutores")
	    ResponseEntity<GenericResponse<Object>> saveAsignacion(@RequestBody Asigtutorempacad asignacion, @RequestParam(value = "idtutoracad") Long idtutoracad, @RequestParam(value = "idtutoremp") Long idtutoremp, @RequestParam(value = "idestudiante") Long idestudiante) {
	        return new ResponseEntity<GenericResponse<Object>>(asignacionService.saveAsignacion(asignacion, idtutoracad, idtutoremp, idestudiante), HttpStatus.OK);
	    }
	@ApiOperation("Muestra todos las asignaciones")
	 @CrossOrigin({"*"})
	    @GetMapping("/findAll-asignaciones")
	    public List<Asigtutorempacad> getAllCoordinadores() {
	        return asignacionService.getlListarAsignaciones();
	    }
	@ApiOperation("Recibe un parametro de ¿l tutor empresarial y lista las asignaciones")
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-tutorempresarial")
	    public 	List<Asigtutorempacad> getBIdTutorEmpresarial(@RequestParam(value = "idtutoremp") Long idtutoremp) {
	        return asignacionService.getByIdtutorEmpresarial(idtutoremp);
	    }
	
	@ApiOperation("Recibe un parametro de tutor academico y lista las asignaciones")
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-tutoracademico")
	    public 	List<Asigtutorempacad> getBIdTutorAcademico(@RequestParam(value = "idtutoracad") Long idtutoracad) {
	        return asignacionService.getByIdtutorAcademico(idtutoracad);
	    }
	
	@ApiOperation("Recibe la id del estudiante y lista sus tutores asignados")
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-Estudiante")
	    public 	List<Asigtutorempacad> getByIdEstudiante(@RequestParam(value = "idestudiante") Long idestudiante) {
	        return asignacionService.getByIdestudiante(idestudiante);
	    }
}
