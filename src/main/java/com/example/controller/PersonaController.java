package com.example.controller;

import java.util.List;

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
import com.example.model.Persona;
import com.example.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping
	public ResponseEntity<List<Persona>> listarPersonas() {
		List<Persona> personas = personaService.listar();
		return new ResponseEntity<>(personas,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable("id") Integer idPersona) {
		Persona persona = personaService.buscarPorId(idPersona);
		if(persona == null)
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + idPersona);
		
		return new ResponseEntity<>(persona, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Persona> registrarPersona(@RequestBody Persona persona) {
		 Persona per = personaService.registrar(persona);
		 return new ResponseEntity<>(per, HttpStatus.CREATED);
	}

	@PutMapping
	public Persona actualizarPersona(@RequestBody Persona persona) {
		return personaService.modificar(persona);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarPersona(@PathVariable("id") Integer idPersona) {
		
		Persona persona = personaService.buscarPorId(idPersona);
		
		if(persona == null)
			throw new ModelNotFoundException("NO ES POSIBLE ELIMINAR EL REGISTRO, LA PERSONA CON ID: " + idPersona + " NO FUE ENCONTRADA.");
		else
			personaService.eliminar(idPersona);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
