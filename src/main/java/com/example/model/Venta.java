package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VENTA")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;

	@JoinColumn(name = "id_persona", nullable = false)
	@ManyToOne
	private Persona persona;

	@Column(nullable = false)
	private double importe;

	@Column(nullable = false)
	private LocalDateTime fecha;

	public Integer getIdVenta() {
		return idVenta;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
