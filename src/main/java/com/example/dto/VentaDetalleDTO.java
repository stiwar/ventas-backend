package com.example.dto;

import java.util.List;

import com.example.model.Producto;
import com.example.model.Venta;
//clase no está en uso
public class VentaDetalleDTO {

	private Venta venta;
	private List<Producto> productos;
	private List<Integer> cantidadesPorProducto;

	public List<Integer> getCantidadesPorProducto() {
		return cantidadesPorProducto;
	}

	public void setCantidadesPorProducto(List<Integer> cantidadesPorProducto) {
		this.cantidadesPorProducto = cantidadesPorProducto;
	}

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
