package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.DetalleVenta;

public interface IDetalleVentaRepo extends JpaRepository<DetalleVenta, Integer>{
	
	@Query(value = "SELECT * FROM detalle_venta dv WHERE dv.id_venta = :idVenta", nativeQuery = true)
	List<DetalleVenta> obtenerDetalleVenta(@Param("idVenta") Integer idVenta);

}
