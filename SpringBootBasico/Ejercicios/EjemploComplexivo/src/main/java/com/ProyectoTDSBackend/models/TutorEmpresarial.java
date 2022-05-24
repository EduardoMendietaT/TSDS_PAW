package com.ProyectoTDSBackend.models;

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

import com.ProyectoTDSBackend.security.models.Persona;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tutorempresarial")
public class TutorEmpresarial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtutoremp", nullable = false)
	private Long idtutoremp;
	@Column(name = "nombretutor", nullable = false, length = 50)
    private String nombretutor;
	@Column(name = "identificacion", nullable = false, length = 10)
    private String identificacion;
	@Column(name = "contacto", nullable = false, length = 10)
    private String contacto;
	@Column(name = "estado", nullable = false, length = 1)
    private int estado;
	
	
	
	public Long getIdtutoremp() {
		return idtutoremp;
	}



	public void setIdtutoremp(Long idtutoremp) {
		this.idtutoremp = idtutoremp;
	}



	public String getNombretutor() {
		return nombretutor;
	}



	public void setNombretutor(String nombretutor) {
		this.nombretutor = nombretutor;
	}



	public String getIdentificacion() {
		return identificacion;
	}



	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}



	public String getContacto() {
		return contacto;
	}



	public void setContacto(String contacto) {
		this.contacto = contacto;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}



	public Empresa getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idempresa")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Empresa empresa;
	

}
