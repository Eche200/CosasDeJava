package com.spring.service;

import java.util.List;

import com.spring.model.TablaDeRegistro;

public interface TablaDeRegistroService {
	
void saveTablaDeRegistro(TablaDeRegistro usuario);
	
	void deleteTablaDeRegistroById(long idUsuario);
	
	void updateTablaDeRegistro(TablaDeRegistro usuario);
	
	List<TablaDeRegistro> findAllUsuarios();
	
	TablaDeRegistro findById(long idUsuario);
	
	TablaDeRegistro findByName(String name);

}
