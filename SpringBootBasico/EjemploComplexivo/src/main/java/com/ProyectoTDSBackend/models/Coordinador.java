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
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.ProyectoTDSBackend.security.models.Persona;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "coordinador")
public class Coordinador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcoordinador", nullable = false)
	private Long idcoordinador;
	@Column(name = "estado", nullable = false)
	private int estado;


	public Coordinador() {
	}

	public Coordinador(int estado) {
		this.estado = estado;
	}
	

	public Long getIdcoordinador() {
		return idcoordinador;
	}

	public void setIdcoordinador(Long idcoordinador) {
		this.idcoordinador = idcoordinador;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idpersona")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Persona persona;

	
	@OneToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idcarrera")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Carrera carrera;
}
