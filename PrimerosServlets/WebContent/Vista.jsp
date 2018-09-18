<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.echeconea.emmanuel.RegistroUsuario.ControladorServlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] titulos = (String[]) request.getAttribute("listaDeProductos");

	out.println("Ahor con array");
	out.println("<br>");
		for(int x = 0;x < titulos.length; x++){
			out.println(titulos[x]);
		}
		out.println("<br>");
		out.println("Ahor con lists");
		
		List<String> titulos2 = new ArrayList<String>(Arrays.asList((String[]) request.getAttribute("listaDeProductos")));
		out.println("<br>");
		for(String titulo : titulos2){
			out.println(titulo);
		}
			
	%>
</body>
</html>