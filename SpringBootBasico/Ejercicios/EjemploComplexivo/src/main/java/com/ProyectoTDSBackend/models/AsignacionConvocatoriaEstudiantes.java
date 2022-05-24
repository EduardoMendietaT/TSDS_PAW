package com.ProyectoTDSBackend.models;

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
@Table(name="AsignacionConvocatoriaEstudiantes")
public class AsignacionConvocatoriaEstudiantes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idasigestudconvocatoria", nullable = false)
	private Long idasigestudconvocatoria;
	
	@Column(name = "documento", nullable = false)
	private String documento;
	
	@Column(name = "fechaenvio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaenvio;
	
	public Long getIdasigestudconvocatoria() {
		return idasigestudconvocatoria;
	}

	public void setIdasigestudconvocatoria(Long idasigestudconvocatoria) {
		this.idasigestudconvocatoria = idasigestudconvocatoria;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaenvio() {
		return fechaenvio;
	}

	public void setFechaenvio(Date fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idconvocatoria")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Convocatoria convocatoria;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idestudiante")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Estudiante estudiante;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idestado")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Estado estado;

}
