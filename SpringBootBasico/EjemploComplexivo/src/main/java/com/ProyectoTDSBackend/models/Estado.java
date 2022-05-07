package com.ProyectoTDSBackend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idestado", nullable = false)
	private Long idestado;
	@Column(name = "descripción", nullable = false)
	private String descripcion;
	@Column(name = "color", nullable = false)
	private String color;
	
	public Estado() {
		
	}

	public Estado( String descripcion, String color) {
		
		this.descripcion = descripcion;
		this.color = color;
	}

	public Long getIdestado() {
		return idestado;
	}

	public void setIdestado(Long idestado) {
		this.idestado = idestado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

	
}
