/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.security.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author LENOVO
 */
public class PersonaPrincipal implements UserDetails {

    private String identificacion;

    private String primernombre;

    private String segundonombre;

    private String primerapellido;

    private String segundoapellido;

    private String email;

    private String nombreUsuario;

    private int estado;

    private String password;
    
    private Collection<? extends GrantedAuthority> authorities;

    public PersonaPrincipal(String identificacion, String primernombre, String segundonombre, String primerapellido, String segundoapellido, String email, String nombreUsuario, int estado, String password, Collection<? extends GrantedAuthority> authorities) {
        this.identificacion = identificacion;
        this.primernombre = primernombre;
        this.segundonombre = segundonombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.estado = estado;
        this.password = password;
        this.authorities = authorities;
    }

  

    public static PersonaPrincipal build(Persona persona) {
        List<GrantedAuthority> authorities
                = persona.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre().name())).collect(Collectors.toList());
        return new PersonaPrincipal(persona.getIdentificacion(), persona.getPrimernombre(), persona.getSegundonombre(), persona.getPrimerapellido(), persona.getSegundoapellido(), persona.getEmail(), persona.getNombreUsuario(), persona.getEstado(), persona.getPassword(), authorities);
    }

  
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
}
