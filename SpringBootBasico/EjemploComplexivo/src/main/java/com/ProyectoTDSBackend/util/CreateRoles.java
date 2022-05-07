/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.util;

import com.ProyectoTDSBackend.security.enums.RolNombre;
import com.ProyectoTDSBackend.security.models.Rol;
import com.ProyectoTDSBackend.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author LENOVO
 */
@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol roleEstudiante = new Rol(RolNombre.ROLE_ESTU);
        Rol rolAcademico = new Rol(RolNombre.ROLE_ACADEMICO);
        Rol rolCordinador= new Rol(RolNombre.ROLE_COORDINA);
        Rol rolEmpresa= new Rol(RolNombre.ROLE_EMPRESA);
       Rol rolVincula = new Rol(RolNombre.ROLE_VICULA);

      Rol rolResponsable = new Rol(RolNombre.ROLE_RESPONSA);
        rolService.save(rolAdmin);
        rolService.save(roleEstudiante);
        rolService.save(rolAcademico);
        rolService.save(rolCordinador);
        rolService.save(rolEmpresa);
        rolService.save(rolVincula);
       rolService.save(rolResponsable);
  }
}
