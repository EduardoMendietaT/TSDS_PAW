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
@Table(name = "estudiantereldoc")
public class EstudianteRelDoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idestudiantedoc", nullable = false)
	private Long idestudiantedoc;
	@Column(name = "fechaasignacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaasignacion;
	
	
	
	public Long getIdestudiantedoc() {
		return idestudiantedoc;
	}

	public void setIdestudiantedoc(Long idestudiantedoc) {
		this.idestudiantedoc = idestudiantedoc;
	}


	public Date getFechaasignacion() {
		return fechaasignacion;
	}

	public void setFechaasignacion(Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idestudiante")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Estudiante estudiante;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "iddocumento")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Documento documento;
	

}
