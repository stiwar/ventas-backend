package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@PostMapping
	public ResponseEntity<Object> registrarVenta(){
		return null;
	}
}


/*

{

	"venta" : {
		"persona" : {
			"idPersona" : 1
		},

		"importe" : 30000,
		"fecha" : "2019-09-10T05:00:00.000Z",

	},

	"productos" : [
					{"idProducto" : 1},
					{"idProducto" : 3}
				  ]

}
 */