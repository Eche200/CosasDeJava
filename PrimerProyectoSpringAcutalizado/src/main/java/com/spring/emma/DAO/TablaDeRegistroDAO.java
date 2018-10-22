package com.spring.emma.DAO;

import java.util.List;

import com.spring.model.*;

public interface TablaDeRegistroDAO {
	
	void saveTablaDeRegistro(TablaDeRegistro usuario);
	
	void deleteTablaDeRegistroById(long idUsuario);
	
	void updateTablaDeRegistro(TablaDeRegistro usuario);
	
	List<TablaDeRegistro> findAllUsuarios();
	
	TablaDeRegistro findById(long idUsuario);
	
	TablaDeRegistro findByName(String name);
	
	
	

}
