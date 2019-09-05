package com.example.service;

import java.util.List;

public interface ICRUD<T> {
	
	T registrar(T t);
	T modificar(T t);
	T buscarPorId(Integer id);
	List<T> listar();
	void eliminar(Integer id);
	
}
