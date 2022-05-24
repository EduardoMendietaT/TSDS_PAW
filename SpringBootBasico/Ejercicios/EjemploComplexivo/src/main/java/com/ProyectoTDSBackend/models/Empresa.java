package com.ProyectoTDSBackend.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempresa", nullable = false)
	    private Long idempresa;
	@Column(name = "nombreempresa", nullable = false)
	    private String nombreempresa;
	@Column(name = "direccion", nullable = false)
	 	private String direccion;
	@Column(name = "descripcion", nullable = false)
	 	private String descripcion;
	@Column(name = "email", nullable = false)
	 	private String email;
	@Column(name = "contacto", length = 10)
	 	private String contacto;
	@Column(name = "estado", nullable = false)
	 	private int estado;
	 	
		public Empresa() {
		}

		public Empresa(String nombreempresa, String direccion, String descripcion, String email,String contacto, int estado) {
			this.nombreempresa = nombreempresa;
			this.direccion = direccion;
			this.descripcion = descripcion;
			this.email = email;
			this.contacto = contacto;
			this.estado = estado;
		}

		public Long getIdempresa() {
			return idempresa;
		}

		public void setIdempresa(Long idempresa) {
			this.idempresa = idempresa;
		}

		public String getNombreempresa() {
			return nombreempresa;
		}

		public void setNombreempresa(String nombreempresa) {
			this.nombreempresa = nombreempresa;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
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
		
	 	
}
