<%@page import="java.util.ArrayList"%>
<%@page import="clasesFifa.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
#mySelect option {
	background-repeat: no-repeat;
	background-size: 25px 25px;
	padding-left: 30px; /* Aumenta el espacio para la imagen y el texto */
}

<%BDController conexionBD = new BDController();
ArrayList<Jugador> jugadores = conexionBD.consultaJugadores();
for (Jugador jugador : jugadores) {%> 
	#mySelect
	option[value="<%=jugador.getCod_jugador()%>"] { background-image:url("images/jugadores/<%=jugador.getCod_jugador()%>.png");
	
}
<%}%>
</style>
<title>Insert title here</title>
</head>
<body>

	<select id="mySelect">
	<%
	for (Jugador jugador : jugadores) {%> 
		<option value="<%=jugador.getCod_jugador()%>"><%=jugador.getNombre()%></option>
	<%}%>

	</select>

</body>
</html>