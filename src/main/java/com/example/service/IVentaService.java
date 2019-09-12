package com.example.service;

import java.util.List;

import com.example.model.DetalleVenta;
import com.example.model.Venta;

public interface IVentaService extends ICRUD<Venta>{
	
	Venta registrarTransaccionVentaDetalle(List<DetalleVenta> ventaDetalleDTO);
	
	List<DetalleVenta> obtenerDetalleVenta(Integer idDetalleVenta);
	
}
