/*
 * preguntar todo sobre esto a sergio , no entiendo una mierda jaja
 */

package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.TablaDeRegistro;
import com.spring.service.TablaDeRegistroService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class TablaDeRegistroController {
	
	TablaDeRegistroService _tablaDeRegistroService;
	
	
	//cualquier cosa que entre o salga de aqui debe ser un JSON
	@RequestMapping(value="/tablaDeRegistro" ,method = RequestMethod.GET,headers = "Accept=application/json")
	public ResponseEntity<List<TablaDeRegistro>> getTablaDeRegistro()
	{
		List<TablaDeRegistro> usuariosDeLaTabla = new ArrayList<>();
		
		usuariosDeLaTabla = _tablaDeRegistroService.findAllUsuarios(); 
		
		if(usuariosDeLaTabla.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<TablaDeRegistro>>(usuariosDeLaTabla,HttpStatus.OK);
	}
	
	

}
