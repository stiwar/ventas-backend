package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Producto;
import com.example.repo.IProductoRepo;
import com.example.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public Producto registrar(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public Producto buscarPorId(Integer id) {
		return productoRepo.findById(id).orElse(null);
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
