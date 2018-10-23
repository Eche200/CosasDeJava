/*
 * Pregunta a SERGIO si cada vez que hago RequestMapping es para que pase
 * algo en el momento que yo le indique, osea entre a cierta pagina o
 * realice X operacion
 */

package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // le decimos que la clase es un controlador
public class MainController {
	
	@RequestMapping("/")// esto es para que cuando alguien entre a la URL hjaga lo que esta ahi abajo para eso se mapea
	@ResponseBody//hay que poner esto , para devolver la informacion
	public String index() {
		String respuesta = "<a>Bienvenido a mi pagina</a>";
		return respuesta;
	}
	
	

}
