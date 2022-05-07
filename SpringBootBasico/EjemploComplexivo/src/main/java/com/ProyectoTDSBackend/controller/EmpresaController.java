package com.ProyectoTDSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Empresa;
import com.ProyectoTDSBackend.repository.EmpresaRepository;
import com.ProyectoTDSBackend.service.EmpresaService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/empresa")
@CrossOrigin({ "*" })
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;
	@Autowired
	EmpresaRepository empresaRepository;

	@ApiOperation("Extraer por nombre de empresa")
	 @CrossOrigin({"*"})
	@GetMapping("/empresa/{nombreempresa}")
	public ResponseEntity<Empresa> getByNombre(@PathVariable("nombreempresa") String nombreempresa) {

		if (!empresaService.existsByNombre(nombreempresa)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		Empresa empresa = empresaService.getbynombre(nombreempresa);
		return new ResponseEntity(empresa, HttpStatus.OK);
	}

//Listar todas las empresas
	@ApiOperation("Muestra el listado de empresas")
	 @CrossOrigin({"*"})
	@GetMapping("/findAllDisponibles-Empresa")
	public List<Empresa> getAllEmpresasDisponibles() {
		return empresaService.getAllEmpresasHabilitados();
	}

//añadir una empresa
	@ApiOperation("Permite añadir empresas")
	 @CrossOrigin({"*"})
	@PostMapping("/add-Empresa")
	ResponseEntity<GenericResponse<Object>> saveEmpresa(@RequestBody Empresa empresa) {
		return new ResponseEntity<GenericResponse<Object>>(empresaService.createEmpresa(empresa), HttpStatus.OK);
	}

	@ApiOperation("Actualizar campos de empresa")
	 @CrossOrigin({"*"})
	@PostMapping("/put-empresa")
	ResponseEntity<GenericResponse<Object>> putEmpresa(@RequestParam(value = "idempresa") Long idempresa,
			@RequestParam(value = "nombreempresa") String nombreempresa,
			@RequestParam(value = "direccion") String direccion,
			@RequestParam(value = "descripcion") String descripcion, @RequestParam(value = "email") String email,
			@RequestParam(value = "contacto") String contacto) {
		return new ResponseEntity<GenericResponse<Object>>(
				empresaService.putEmpresa(idempresa, nombreempresa, direccion, descripcion, email, contacto),
				HttpStatus.OK);
	}
	@ApiOperation("Eliminado logico de empresa")
    @CrossOrigin({"*"})
    @PatchMapping("/deleteEmpresa/{idempresa}")
    public ResponseEntity<?> deleteEmpresa(@RequestParam(value = "idempresa") Long idempresa) {
        Empresa empresa = empresaService.getOne(idempresa).get();
        empresa.setEstado(0);
        empresaService.save(empresa);
        return new ResponseEntity(new Mensaje("empresa eliminada"), HttpStatus.OK);
    }

}
