package com.ProyectoTDSBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTDSBackend.models.Actividad;
import com.ProyectoTDSBackend.models.AsignacionConvocatoriaEstudiantes;
import com.ProyectoTDSBackend.service.AsignConvocEstService;
import com.ProyectoTDSBackend.util.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Asignacionestudiantesconvocatoria")
@CrossOrigin({"*"})
public class AsignEstConvController {
	
	@Autowired
	AsignConvocEstService asignacionService;
	@ApiOperation("Muestra todos las asignaciones")
	 @CrossOrigin({"*"})
	    @GetMapping("/findAll-asignaciones")
	    public List<AsignacionConvocatoriaEstudiantes> getAllAsignaciones() {
	        return asignacionService.getAllAsignaciones();
	    }
	
   @ApiOperation("Crear asignacion a convocatoria")
   @CrossOrigin({"*"})
   @PostMapping("/createAsignacion")
   public ResponseEntity<GenericResponse<Object>>  createAsignacion(@RequestBody AsignacionConvocatoriaEstudiantes asignacion,@RequestParam("idconvocatoria")Long idconvocatoria,@RequestParam("idestudiante")Long idestudiante) {
       return new ResponseEntity<GenericResponse<Object>>(asignacionService.saveAsignacion(asignacion, idestudiante, idconvocatoria), HttpStatus.OK);
   }
	
	@ApiOperation("Recibe la id del estudiante y lista sus tutores asignados")
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-Estudiante")
	    public 	List<AsignacionConvocatoriaEstudiantes> getByIdEstudiante(@RequestParam(value = "idestudiante") Long idestudiante) {
	        return asignacionService.getbyidestudiante(idestudiante);
	    }
	@ApiOperation("Recibe la id de convocatoria para mostrar estudiantes asignados")
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-convocatoria")
	    public 	List<AsignacionConvocatoriaEstudiantes> getByIdConvocatoria(@RequestParam(value = "idconvocatoria") Long idconvocatoria) {
	        return asignacionService.getbyidconvocatoria(idconvocatoria);
	    }
	@ApiOperation("Recibe la id de estado segun el tiempo de entrega de convocatoria")
	 @CrossOrigin({"*"})
	 @GetMapping("/getById-estado")
	    public 	List<AsignacionConvocatoriaEstudiantes> getByIdEstado(@RequestParam(value = "idestado") Long idestado) {
	        return asignacionService.getbyidestado(idestado);
	    }
//    @ApiOperation("Eliminado fisico de la asignacion")
//    @CrossOrigin({"*"})
//    @PatchMapping("/deleteasignacion/{idasigestudconvocatoria}")
//    public ResponseEntity<GenericResponse<Object>> deleteasignacion(@RequestParam(value = "idasigestudconvocatoria") Long idasigestudconvocatoria) {
//        
//        return new ResponseEntity<GenericResponse<Object>>(asignacionService.deleteasignacion(idasigestudconvocatoria), HttpStatus.OK);
//    }
    @ApiOperation("Eliminado fisico de la asignación")
    @CrossOrigin({"*"})
    @DeleteMapping("/deleteasignacion/{idasigestudconvocatoria}")
    public ResponseEntity<GenericResponse<Object>> deleteasignacion(@RequestParam(value = "idasigestudconvocatoria") Long idasigestudconvocatoria) {
        
        return new ResponseEntity<GenericResponse<Object>>(asignacionService.deleteasignacion(idasigestudconvocatoria), HttpStatus.OK);
    }

}
