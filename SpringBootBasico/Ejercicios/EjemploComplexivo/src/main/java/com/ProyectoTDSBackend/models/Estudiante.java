package com.ProyectoTDSBackend.models;

import java.io.Serializable;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idestudiante", nullable = false)
	private Long idestudiante;
	
	
	
	public Long getIdestudiante() {
		return idestudiante;
	}



	public void setIdestudiante(Long idestudiante) {
		this.idestudiante = idestudiante;
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
