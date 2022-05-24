/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.controller;

import com.ProyectoTDSBackend.dto.Mensaje;
import com.ProyectoTDSBackend.models.Convocatoria;
import com.ProyectoTDSBackend.service.ConvocatoriaService;
import com.ProyectoTDSBackend.util.GenericResponse;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/convocatoria")
@CrossOrigin({"*"})
public class ConvocatoriaController {

    @Autowired
    ConvocatoriaService convocatoriaService;

    @ApiOperation("Listado de las convocatorias activas")
    @CrossOrigin({"*"})
    @GetMapping("/get-ConvocatoriasDisponibles")
    public List<Convocatoria> getAllConvocatoriasDisponibles() {
        return convocatoriaService.getAllConvocatoriasDisponibles();
    }
    
    @ApiOperation("Listado de las convocatorias inhabilitadas")
    @CrossOrigin({"*"})
    @GetMapping("/get-ConvocatoriasInhabilitadas")
    public List<Convocatoria> getAllConvocatoriasInactivas() {
        return convocatoriaService.getAllConvocatoriasInhabilitadas();
    }
    
    @ApiOperation("Listado de las convocatorias por fecha de inicio")
    @CrossOrigin({"*"})
    @GetMapping("/get-ConvocatoriasByFecha")
    public List<Convocatoria> getAllConvocatoriasByFechainicio(@RequestParam(value = "fechainicio", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechainicio) {
        return convocatoriaService.getAllConvocatoriasByfechainicio(fechainicio);
    }
    
    @ApiOperation("Listado de las convocatorias por fecha de finalizacion")
    @CrossOrigin({"*"})
    @GetMapping("/get-ConvocatoriasByFechafin")
    public List<Convocatoria> getAllConvocatoriasByFechafin(@RequestParam(value = "fechafin", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechafin) {
        return convocatoriaService.getAllConvocatoriasByfechafin(fechafin);
    }
    
    @ApiOperation("Listado de las convocatorias por responsable de practicas")
    @CrossOrigin({"*"})
    @GetMapping("/get-ConvocatoriasByresponsableppp")
    public List<Convocatoria> getAllConvocatoriasByresponsableppp(@RequestParam(value = "idresponsableppp", required = true) Long idresponsableppp) {
        return convocatoriaService.getAllConvocatoriasByresponsablepp(idresponsableppp);
    }

    // 
    @ApiOperation("Crea las convocatorias")
    @CrossOrigin({"*"})
    @PostMapping("/create")
    public ResponseEntity<GenericResponse<Object>> createConvocatoria(@RequestBody Convocatoria convocatoria,Long idcarrera,Long idresponsableppp) {

        return new ResponseEntity<GenericResponse<Object>>(convocatoriaService.saveConvocatoria(convocatoria, idcarrera, idresponsableppp), HttpStatus.OK);
    }

    @ApiOperation("Actualizar convocatoria")
    @CrossOrigin({"*"})
    @PostMapping("/actualizarConvocatoria")
    ResponseEntity<GenericResponse<Object>> putConvocatoria(
            @RequestParam(value = "idconvocatoria") Long idconvocatoria,
            @RequestParam(value = "documento") String documento,
            @RequestParam(value = "requisitos") String requisitos,
            @RequestParam(value = "actividades") String actividades,
            @RequestParam(value = "fechainicio", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechainicio,
            @RequestParam(value = "fechafin" , required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechafin) {
        return new ResponseEntity<GenericResponse<Object>>(
                convocatoriaService.putActividad(idconvocatoria, documento,requisitos,actividades, fechainicio, fechafin),
                HttpStatus.OK);
    }

    @ApiOperation("Eliminado logico de convocatoria")
    @CrossOrigin({"*"})
    @PatchMapping("/deleteConvocatoria/{idconvocatoria}")
    public ResponseEntity<GenericResponse<Object>> deleteConvocatoria(@RequestParam(value = "idconvocatoria") Long idconvocatoria) {
        
        return new ResponseEntity<GenericResponse<Object>>(convocatoriaService.deleteConvocatoria(idconvocatoria), HttpStatus.OK);
    }
    
    @ApiOperation("Renovacion de convocatoria")
    @CrossOrigin({"*"})
    @PatchMapping("/RestoreConvocatoria/{idconvocatoria}")
    public ResponseEntity<GenericResponse<Object>> RestaurarConvocatoria(@RequestParam(value = "idconvocatoria") Long idconvocatoria) {
        
        return new ResponseEntity<GenericResponse<Object>>(convocatoriaService.HabilitarConvocatoria(idconvocatoria), HttpStatus.OK);
    }

    
    
    ///Tes de id
    @ApiOperation("Busca la convocatoria por ID")
    @CrossOrigin({"*"})
    @GetMapping("/buscarConvocatoria/{idconvocatoria}")
    public ResponseEntity<Convocatoria> getById(@PathVariable("idconvocatoria") Long idconvocatoria) {
        if (!convocatoriaService.existsById(idconvocatoria)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Convocatoria convo = convocatoriaService.getOne(idconvocatoria).get();
        return new ResponseEntity(convo, HttpStatus.OK);
    }
}
