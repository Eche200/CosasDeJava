package com.echeconea.emmanue.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlets
 */
@WebServlet("/PrimerServlets")
public class PrimerServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimerServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter salida = response.getWriter();
		salida.println("<html><body>");
		salida.println("<h1 style='text-align:center'>Probando</h1>");
		salida.println("<h2 style='text-align:center'>Probando2</h1>");
		salida.println("<h3 style='text-align:center'>Probando3</h1>");
		salida.println("<h4 style='text-align:center'>Probando4</h1>");
		salida.println("<h5 style='text-align:center'>Probando5</h1>");
		
		salida.println(new Date());
		
		salida.println("</html></body>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
