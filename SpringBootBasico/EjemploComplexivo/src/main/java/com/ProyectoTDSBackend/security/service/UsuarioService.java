/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.security.service;

import com.ProyectoTDSBackend.security.models.Persona;
import com.ProyectoTDSBackend.security.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LENOVO
 */
@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Persona> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public boolean existsByIdentificacion(String identificacion) {
        return usuarioRepository.existsByIdentificacion(identificacion);
    }
    
    public boolean existsByContacto(int contacto) {
        return usuarioRepository.existsByContacto(contacto);
    }
    
    
    public void save(Persona usuario) {
        usuarioRepository.save(usuario);
    }
}
