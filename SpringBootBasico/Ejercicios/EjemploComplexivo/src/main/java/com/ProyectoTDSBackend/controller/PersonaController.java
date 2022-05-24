package com.ProyectoTDSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Carrera;
import com.ProyectoTDSBackend.security.enums.RolNombre;
import com.ProyectoTDSBackend.security.models.Persona;
import com.ProyectoTDSBackend.service.PersonaService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/persona")
@CrossOrigin({ "*" })
public class PersonaController {

	@Autowired
	PersonaService personaService;

	@CrossOrigin({ "*" })
	@GetMapping("/getById-Persona")
	public Persona getByIPersona(@RequestParam(value = "idpersona") int idpersona) {
		return personaService.getById(idpersona);
	}

//Listar todas las personas
	@ApiOperation("Muestra el listado de personas")
	@CrossOrigin({ "*" })
	@GetMapping("/findAll-Personas")
	public List<Persona> getAllPersonas() {
		return personaService.getAllPersonas();
	}
	
    /**
     * CONSTRUCCION DEL METODO PUT PARA ACTUALIZAR DATOS DE VINCULACIÓN
     */
 @CrossOrigin({"*"})
    @PostMapping("/put-persona")
    ResponseEntity<GenericResponse<Object>> putArrendatario(
    		 @RequestParam(value = "idpersona") int idpersona,
    		@RequestParam(value = "rol") RolNombre rol
    ) {
        return new ResponseEntity<GenericResponse<Object>>(personaService.putPermisos(idpersona, rol), HttpStatus.OK);
    }

}
