package com.ProyectoTDSBackend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddocumento", nullable = false)
	private Long iddocumento;
	@Column(name = "nombreanexo", nullable = false)
	private String nombreanexo;
	@Column(name = "tipo_documento", nullable = false)
	private String tipo_documento;
	@Column(name = "enlace_documento", nullable = false)
	private String enlace_documento;

	public Documento() {
	}

	public Documento(String nombreanexo, String tipo_documento, String enlace_documento) {
		this.nombreanexo = nombreanexo;
		this.tipo_documento = tipo_documento;
		this.enlace_documento = enlace_documento;
	}

	public Long getIddocumento() {
		return iddocumento;
	}

	public void setIddocumento(Long iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getNombreanexo() {
		return nombreanexo;
	}

	public void setNombreanexo(String nombreanexo) {
		this.nombreanexo = nombreanexo;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getEnlace_documento() {
		return enlace_documento;
	}

	public void setEnlace_documento(String enlace_documento) {
		this.enlace_documento = enlace_documento;
	}
	

}
