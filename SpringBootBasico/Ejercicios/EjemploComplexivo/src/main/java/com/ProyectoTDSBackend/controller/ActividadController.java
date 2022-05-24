/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.controller;

import com.ProyectoTDSBackend.models.Actividad;
import com.ProyectoTDSBackend.service.ActividadService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/actividad")
@CrossOrigin({"*"})
public class ActividadController {

    @Autowired
    ActividadService actividadService;

//Listar todas las actividades
    @ApiOperation("Lista a todas las actividades")
    @CrossOrigin({"*"})
    @GetMapping("/get-allactividades")
    public List<Actividad> getActividades() {
        return actividadService.getlListaActividades();
    }

//   @ApiOperation("Listado de las actividades")
    @CrossOrigin({"*"})
    @PostMapping("/createActividad")
    public ResponseEntity<GenericResponse<Object>>  createActividad(@RequestBody Actividad actividad,@RequestParam("idempresa")Long idempresa,@RequestParam("idresponsableppp")Long idresponsableppp) {
        return new ResponseEntity<GenericResponse<Object>>(actividadService.saveActividad(actividad, idempresa, idresponsableppp), HttpStatus.OK);
    }

    @ApiOperation("Actualizar campos de la actividad")
    @CrossOrigin({"*"})
    @PostMapping("/put-Actividad")
    ResponseEntity<GenericResponse<Object>> putActividad(
            @RequestParam(value = "idactividad") Long idactividad,
            @RequestParam(value = "descripcionactividades") String descripcionactividades,
            @RequestParam(value = "horario", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date horario,
            @RequestParam(value = "cronograma", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date cronograma)
       {
        return new ResponseEntity<GenericResponse<Object>>(
                actividadService.putActividad(idactividad,descripcionactividades ,horario, cronograma),
                HttpStatus.OK);
    }
}
