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
@Table(name="responsableppdocumento")
public class ResponsablePPDocumento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresponsabledoc", nullable = false)
    private Long idresponsabledoc;
	
	@Column(name = "fechaasignacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaasignacion;
	
	
	
	public Long getIdresponsabledoc() {
		return idresponsabledoc;
	}

	public void setIdresponsabledoc(Long idresponsabledoc) {
		this.idresponsabledoc = idresponsabledoc;
	}

	public Date getFechaasignacion() {
		return fechaasignacion;
	}

	public void setFechaasignacion(Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}

	public ResponsablePPP getResponsableppp() {
		return responsableppp;
	}

	public void setResponsableppp(ResponsablePPP responsableppp) {
		this.responsableppp = responsableppp;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idresponsableppp")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ResponsablePPP responsableppp;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "iddocumento")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Documento documento;

}
