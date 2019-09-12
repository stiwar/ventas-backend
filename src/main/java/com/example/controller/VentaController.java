package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.exception.ModelNotFoundException;
import com.example.model.DetalleVenta;
import com.example.model.Venta;
import com.example.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private IVentaService ventaService;

/*
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> registrarVenta(@RequestBody VentaDetalleDTO ventaDetalleDTO){
		
		Venta venta = ventaService.registrarTransaccionVentaDetalle(ventaDetalleDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
		
	}
*/
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> registrarVenta(@RequestBody List<DetalleVenta> detalleVenta){
		
		Venta venta = ventaService.registrarTransaccionVentaDetalle(detalleVenta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<Venta>> listarVentas(){
		List<Venta> ventas = ventaService.listar();
		return new ResponseEntity<>(ventas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable("id") Integer idVenta){
		Venta venta = ventaService.buscarPorId(idVenta);
		
		if(venta == null)
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + idVenta);
		
		return new ResponseEntity<>(venta,HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{idVenta}")
	public ResponseEntity<List<DetalleVenta>> obtenerDetalleVentaPorIdVenta(@PathVariable("idVenta") Integer idDetalleVenta){
		List<DetalleVenta> detalleVenta = ventaService.obtenerDetalleVenta(idDetalleVenta);

		
		if(detalleVenta == null || detalleVenta.isEmpty())
			throw new ModelNotFoundException("EL DETALLE CON ID: " + idDetalleVenta + " NO FUE ENCONTRADO");
		
		return new ResponseEntity<>(detalleVenta,HttpStatus.OK);
	}
}