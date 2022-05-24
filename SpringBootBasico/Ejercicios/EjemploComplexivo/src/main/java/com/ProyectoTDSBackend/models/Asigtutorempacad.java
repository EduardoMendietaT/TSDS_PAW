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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "asigtutorempacad")
public class Asigtutorempacad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idasignaciontate", nullable = false)
	private Long idcarrera;
	
	
	
	public Long getIdcarrera() {
		return idcarrera;
	}

	public void setIdcarrera(Long idcarrera) {
		this.idcarrera = idcarrera;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public TutorEmpresarial getTutoremp() {
		return tutoremp;
	}

	public void setTutoremp(TutorEmpresarial tutoremp) {
		this.tutoremp = tutoremp;
	}

	public TutorAcademico getTutoracad() {
		return tutoracad;
	}

	public void setTutoracad(TutorAcademico tutoracad) {
		this.tutoracad = tutoracad;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idestudiante")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Estudiante estudiante;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idtutoremp")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private TutorEmpresarial tutoremp;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idtutoracad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private TutorAcademico tutoracad;
	

}
