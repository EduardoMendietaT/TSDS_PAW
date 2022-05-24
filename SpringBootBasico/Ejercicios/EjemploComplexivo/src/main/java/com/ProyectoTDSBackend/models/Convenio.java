package com.ProyectoTDSBackend.models;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="convenio")
public class Convenio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idconvenio", nullable = false)
	private Long idconvenio;
	@Column(name = "descripcionconvenio", nullable = false)
	private String descripcionconvenio;
	@Column(name = "fechaconvenio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaconvenio;
	
	public Convenio() {
	}
	public Convenio(String descripcionconvenio, Date fechaconvenio) {
		this.descripcionconvenio = descripcionconvenio;
		this.fechaconvenio = fechaconvenio;
	}
	
	
	
	
	public Long getIdconvenio() {
		return idconvenio;
	}
	public void setIdconvenio(Long idconvenio) {
		this.idconvenio = idconvenio;
	}
	public String getDescripcionconvenio() {
		return descripcionconvenio;
	}
	public void setDescripcionconvenio(String descripcionconvenio) {
		this.descripcionconvenio = descripcionconvenio;
	}
	public Date getFechaconvenio() {
		return fechaconvenio;
	}
	public void setFechaconvenio(Date fechaconvenio) {
		this.fechaconvenio = fechaconvenio;
	}
	public Coordinador getCoordinador() {
		return coordinador;
	}
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Vinculacion getVinculacion() {
		return vinculacion;
	}
	public void setVinculacion(Vinculacion vinculacion) {
		this.vinculacion = vinculacion;
	}




	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idempresa")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Empresa empresa;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idvinculacion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Vinculacion vinculacion;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idcoordinador")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Coordinador coordinador;
	
	
}
