package com.echeconea.emmanuel.RegistroUsuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroUsuario
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* si mando por GET se manda asi
		//primero creamor el  objeto printwriter, para dar salida a lo que queremos mandar
		PrintWriter salida = response.getWriter();
		
		salida.println("<html><body>");
		salida.println("<br>Nombre introducido: "+ request.getParameter("nombre"));
		salida.println("<br>Apellido introducido: " + request.getParameter("apellido"));
		salida.println("<br>Dni introducido: "+ request.getParameter("dni"));
		
		salida.println("</html></body>");
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// si mando por POST se manda asi , debemos indicarle de que forma le vamos
		//a enviar la informacin
		doGet(request, response);
		
		response.setContentType("text/html");
		
		//primero creamor el  objeto printwriter, para dar salida a lo que queremos mandar
		PrintWriter salida = response.getWriter();
				
		salida.println("<html><body>");
		salida.println("<br>Nombre introducido: "+ request.getParameter("nombre"));
		salida.println("<br>Apellido introducido: " + request.getParameter("apellido"));
		salida.println("<br>Dni introducido: "+ request.getParameter("dni"));	
		salida.println("</html></body>");
		
	}

}
