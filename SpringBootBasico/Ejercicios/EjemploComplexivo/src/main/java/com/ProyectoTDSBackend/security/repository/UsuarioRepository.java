/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.security.repository;

import com.ProyectoTDSBackend.security.models.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    boolean existsByIdentificacion (String identificacion);
    boolean existsByContacto (int identificacion);
 
}
