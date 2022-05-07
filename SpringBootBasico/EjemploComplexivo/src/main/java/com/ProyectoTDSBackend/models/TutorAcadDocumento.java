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
@Table(name = "tutoracaddocumento")
public class TutorAcadDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtutordoc", nullable = false)
	private Long idtutordoc;
	@Column(name = "fechaasignacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaasignacion;

	public Long getIdtutordoc() {
		return idtutordoc;
	}

	public void setIdtutordoc(Long idtutordoc) {
		this.idtutordoc = idtutordoc;
	}

	public Date getFechaasignacion() {
		return fechaasignacion;
	}

	public void setFechaasignacion(Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}

	public TutorAcademico getTutoracad() {
		return tutoracad;
	}

	public void setTutoracad(TutorAcademico tutoracad) {
		this.tutoracad = tutoracad;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idtutoracad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TutorAcademico tutoracad;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "iddocumento")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Documento documento;
}
