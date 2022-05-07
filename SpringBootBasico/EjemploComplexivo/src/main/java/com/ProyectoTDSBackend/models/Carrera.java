package com.ProyectoTDSBackend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="carrera")
public class Carrera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcarrera", nullable = false)
	private Long idcarrera;
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	public Carrera() {
		
	}

	public Carrera(String descripcion, String nombre) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public Long getIdcarrera() {
		return idcarrera;
	}

	public void setIdcarrera(Long idcarrera) {
		this.idcarrera = idcarrera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
