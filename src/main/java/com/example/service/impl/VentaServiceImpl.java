package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.DetalleVenta;
import com.example.model.Venta;
import com.example.repo.IDetalleVentaRepo;
import com.example.repo.IVentaRepo;
import com.example.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo ventaRepo;
	
	@Autowired
	private IDetalleVentaRepo detalleVentaRepo;

	@Override
	public Venta registrar(Venta venta) {

		return null;
	}

	@Override
	public Venta modificar(Venta venta) {
		
		return null;
	}

	@Override
	public Venta buscarPorId(Integer id) {
		return ventaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Venta> listar() {

		return ventaRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		ventaRepo.deleteById(id);
	}

	@Transactional
	@Override
	public Venta registrarTransaccionVentaDetalle(List<DetalleVenta> detalleVenta) {

		// inserción tabla venta
		Venta venta = ventaRepo.save(detalleVenta.get(0).getVenta());

		// inserción tabla detalle_venta
		for (DetalleVenta detalle : detalleVenta) {
			detalle.setVenta(venta);
			detalleVentaRepo.save(detalle);
			//ventaRepo.registrarVentaDetalle(ventaDetalleDTO.getVenta().getIdVenta(), producto.getIdProducto(), ventaDetalleDTO.getCantidadesPorProducto().get(cont));
		}

		return detalleVenta.get(0).getVenta();
	}

	@Override
	public List<DetalleVenta> obtenerDetalleVenta(Integer idVenta) {
		return detalleVentaRepo.obtenerDetalleVenta(idVenta);
		
	}

}
