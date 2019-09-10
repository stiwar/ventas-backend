package com.example.dto;

import java.util.List;

import com.example.model.Producto;
import com.example.model.Venta;

public class VentaDetalleDTO {

	private Venta venta;
	private List<Producto> productos;

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
