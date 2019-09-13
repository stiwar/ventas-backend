package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSONA")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;

	@Column(nullable = false, length = 50)
	@Size(min = 2, message = "Nombres debe tener mínimo 2 caracteres")
	private String nombres;

	@Column(nullable = false, length = 50)
	@Size(min = 2, message = "Nombres debe tener mínimo 2 caracteres")
	private String apellidos;

	public Integer getIdPersona() {
		return idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
