package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Persona;
import com.example.repo.IPersonaRepo;
import com.example.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepo personaRepo;

	@Override
	public Persona registrar(Persona persona) {
		return personaRepo.save(persona);
	}

	@Override
	public Persona modificar(Persona persona) {
		return personaRepo.save(persona);
	}

	@Override
	public Persona buscarPorId(Integer idPersona) {
		return personaRepo.findById(idPersona).orElse(null);
	}

	@Override
	public List<Persona> listar() {
		return personaRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		personaRepo.deleteById(id);

	}

}
