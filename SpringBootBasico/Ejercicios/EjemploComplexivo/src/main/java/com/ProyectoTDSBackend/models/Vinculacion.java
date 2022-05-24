package com.ProyectoTDSBackend.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ProyectoTDSBackend.security.models.Persona;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "vinculacion")
public class Vinculacion implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvinculacion", nullable = false)
	private Long idvinculacion;
	@Column(name = "rolvinculacion", nullable = false)
	private String rolvinculacion;

    
	
	public Long getIdvinculacion() {
		return idvinculacion;
	}
	public void setIdvinculacion(Long idvinculacion) {
		this.idvinculacion = idvinculacion;
	}
	public String getRolvinculacion() {
		return rolvinculacion;
	}
	public void setRolvinculacion(String rolvinculacion) {
		this.rolvinculacion = rolvinculacion;
	}
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idpersona")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Persona persona;

}
