package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@Column(nullable = false, length = 70)
	@Size(min = 2, message = "El nombre del producto debe tener mínimo 2 caracteres")
	private String nombre;
	
	@Column(nullable = false, length = 50)
	@Size(min = 2, message = "El nombre de la marca debe tener mínimo 2 caracteres")
	private String marca;

	public Integer getIdProducto() {
		return idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
