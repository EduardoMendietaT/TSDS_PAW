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
@Table(name ="responsableppp")
public class ResponsablePPP implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idresponsableppp", nullable = false)
	private Long idresponsableppp;
	
	
	
    public Long getIdresponsableppp() {
		return idresponsableppp;
	}

	public void setIdresponsableppp(Long idresponsableppp) {
		this.idresponsableppp = idresponsableppp;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcarrera")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Carrera carrera;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idpersona")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;

}
