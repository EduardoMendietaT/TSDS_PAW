/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "convocatoria")
public class Convocatoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idconvocatoria", nullable = false)
	private Long idconvocatoria;

	@Column(name = "documento", nullable = false)
	private String documento;
	
	@Column(name = "requisitos", nullable = false)
	private String requisitos;
	
	@Column(name = "actividades", nullable = false)
	private String actividades;

	@Column(name = "fechainicio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechainicio;

	@Column(name = "fechafin", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechafin;

	@Column(name = "estado")
	private int estado;

	public Convocatoria() {
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public ResponsablePPP getResponsable() {
		return responsable;
	}

	public void setResponsable(ResponsablePPP responsable) {
		this.responsable = responsable;
	}

	public Long getIdconvocatoria() {
		return idconvocatoria;
	}

	public void setIdconvocatoria(Long idconvocatoria) {
		this.idconvocatoria = idconvocatoria;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idcarrera")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Carrera carrera;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idresponsableppp")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ResponsablePPP responsable;

}
