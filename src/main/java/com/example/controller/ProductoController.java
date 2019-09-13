package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ModelNotFoundException;
import com.example.model.Producto;
import com.example.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@GetMapping
	public ResponseEntity<List<Producto>> listarProductos() {
		List<Producto> productos = productoService.listar();
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable("id") Integer idProducto) {
		Producto producto = productoService.buscarPorId(idProducto);

		if (producto == null)
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + idProducto);

		return new ResponseEntity<>(producto, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Producto> registrarProducto(@Valid @RequestBody Producto producto) {
		Producto prod = productoService.registrar(producto);
		return new ResponseEntity<>(prod, HttpStatus.CREATED);
	}

	@PutMapping
	public Producto actualizarProducto(@Valid @RequestBody Producto producto) {
		return productoService.modificar(producto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarProducto(@PathVariable("id") Integer idProducto) {
		
		Producto producto = productoService.buscarPorId(idProducto);
		
		if(producto == null)
			throw new ModelNotFoundException("NO ES POSIBLE ELIMINAR EL REGISTRO, EL PRODUCTO CUYO ID ES: " + idProducto + " NO FUE ENCONTRADO.");
		else
			productoService.eliminar(idProducto);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
