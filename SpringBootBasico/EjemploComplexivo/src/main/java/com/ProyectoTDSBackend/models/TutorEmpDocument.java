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
@Table(name = "tutorempdocument")
public class TutorEmpDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtuempresdoc", nullable = false)
	private Long idtuempresdoc;
	@Column(name = "fechaasignacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaasignacion;	

	public Long getIdtuempresdoc() {
		return idtuempresdoc;
	}

	public void setIdtuempresdoc(Long idtuempresdoc) {
		this.idtuempresdoc = idtuempresdoc;
	}

	public Date getFechaasignacion() {
		return fechaasignacion;
	}

	public void setFechaasignacion(Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}

	public TutorEmpresarial getTutoremp() {
		return tutoremp;
	}

	public void setTutoremp(TutorEmpresarial tutoremp) {
		this.tutoremp = tutoremp;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idtutoremp")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private TutorEmpresarial tutoremp;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "iddocumento")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Documento documento;


}
