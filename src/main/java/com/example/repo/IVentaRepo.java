package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer>{
	
	//@Modifying
	//@Query(value = "INSERT INTO detalle_venta(id_venta,id_producto,cantidad) VALUES (:idVenta, :idProducto, :cantidad)", nativeQuery = true)
	//Integer registrarVentaDetalle(@Param("idVenta") Integer idVenta, @Param("idProducto") Integer idProducto, @Param("cantidad") Integer cantidad);

}
