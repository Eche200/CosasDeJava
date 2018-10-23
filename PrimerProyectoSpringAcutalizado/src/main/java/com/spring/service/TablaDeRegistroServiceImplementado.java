/*
 * 
 * preguntar por capa de SERVICE a SERGIO
 */

package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.emma.DAO.TablaDeRegistroDAO;
import com.spring.model.TablaDeRegistro;

@Service("tablaDeRegistroService") //el identificador nso sirve cuando llamemos a service
@Transactional
public class TablaDeRegistroServiceImplementado implements TablaDeRegistroService {

	//definimos la interfaz
	@Autowired//llamamos al objeto mas generico , en este caso tablaDeRegistorDao y llama a ese
	private TablaDeRegistroDAO _tablaDao;
	
	
	@Override
	public void saveTablaDeRegistro(TablaDeRegistro usuario) {

		_tablaDao.saveTablaDeRegistro(usuario);
	}

	@Override
	public void deleteTablaDeRegistroById(long idUsuario) {

		_tablaDao.deleteTablaDeRegistroById(idUsuario);
	}

	@Override
	public void updateTablaDeRegistro(TablaDeRegistro usuario) {

		_tablaDao.updateTablaDeRegistro(usuario);
	}

	@Override
	public List<TablaDeRegistro> findAllUsuarios() {
		return _tablaDao.findAllUsuarios();
	}

	@Override
	public TablaDeRegistro findById(long idUsuario) {
		return _tablaDao.findById(idUsuario);
	}

	@Override
	public TablaDeRegistro findByName(String name) {
		return _tablaDao.findByName(name);
	}

	
	
	
}
