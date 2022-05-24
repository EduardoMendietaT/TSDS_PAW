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
@Table(name = "actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactividad", nullable = false)
    private Long idactividad;
    @Column(name = "descripcionactividades", nullable = false)
    private String descripcionactividades;

    @Column(name = "horario", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date horario;

    @Column(name = "cronograma", nullable = false)
   	@Temporal(TemporalType.TIMESTAMP)
    private Date cronograma;

    public Actividad() {
    }



	public Actividad(String descripcionactividades, Date horario, Date cronograma) {
		super();
		this.descripcionactividades = descripcionactividades;
		this.horario = horario;
		this.cronograma = cronograma;
	}



	public Long getIdactividad() {
		return idactividad;
	}



	public void setIdactividad(Long idactividad) {
		this.idactividad = idactividad;
	}



	public String getDescripcionactividades() {
		return descripcionactividades;
	}



	public void setDescripcionactividades(String descripcionactividades) {
		this.descripcionactividades = descripcionactividades;
	}



	public Date getHorario() {
		return horario;
	}



	public void setHorario(Date horario) {
		this.horario = horario;
	}



	public Date getCronograma() {
		return cronograma;
	}



	public void setCronograma(Date cronograma) {
		this.cronograma = cronograma;
	}



	public Empresa getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	public ResponsablePPP getResponsableppp() {
		return responsableppp;
	}



	public void setResponsableppp(ResponsablePPP responsableppp) {
		this.responsableppp = responsableppp;
	}



	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idempresa")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Empresa empresa;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idresponsableppp")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private ResponsablePPP responsableppp;

}
