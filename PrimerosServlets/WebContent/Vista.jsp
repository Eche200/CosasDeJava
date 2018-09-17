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
		List<String> titulos = new ArrayList<String>();
		titulos.add(0,(String) request.getAttribute("listaDeProductos"));
		
		
			out.println(titulos.get(0));
			
	%>
</body>
</html>