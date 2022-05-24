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
@Table(name = "estudiantAsignatura")
public class EstudiantAsignatura implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasigest", nullable = false)
    private Long idasigest;
	
	@Column(name = "promedio", nullable = false)
    private double promedio;
	
	
	public Long getIdasigest() {
		return idasigest;
	}

	public void setIdasigest(Long idasigest) {
		this.idasigest = idasigest;
	}



	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idasignatura")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Asignatura asignatura;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idestudiante")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Estudiante estudiante;

}
