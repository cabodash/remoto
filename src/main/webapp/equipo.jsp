<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="clasesFifa.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<title>Proyecto Web FIFA23</title>
</head>
<body class="is-preload">
		<div id="page-wrapper">
			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.jsp" id="logo">FIFA23</a></a></h1>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li class="current"><a href="index.jsp">Inicio</a></li>
								<li>
									<a href="#">Listados</a>
									<ul>
										<li><a href="ligas.jsp">Ligas</a></li>
										<li><a href="equipos.jsp">Equipos</a></li>
										<li><a href="jugadores.jsp">Jugadores</a></li>
										
									</ul>
								</li>
								<li>
									<a href="#">Operaciones</a>
									<ul>
										<li>
											<a href="#">Jugadores</a>
											<ul>
												<li><a href="altajugador.jsp">Alta Jugador</a></li>
												<li><a href="bajajugador.jsp">Baja Jugador</a></li>
												<li><a href="#">Modificar Jugador</a></li>
											</ul>
										</li>
										<li>
											<a href="#">Equipos</a>
											<ul>
												<li><a href="altaequipo.jsp">Alta Equipo</a></li>
												<li><a href="bajaequipo.jsp">Baja Equipo</a></li>
												<li><a href="#">Modificar Equipo</a></li>
											</ul>
										</li>
										<li>
											<a href="#">Ligas</a>
											<ul>
												<li><a href="altaliga.jsp">Alta Liga</a></li>
												<li><a href="bajaliga.jsp">Baja Liga</a></li>
												<li><a href="#">Modificar Liga</a></li>
											</ul>
										</li>
										<li>
											<a href="#">Opción 4</a>
											<ul>
												<li><a href="#">Opción 1</a></li>
												
											</ul>
										</li>
									</ul>
								</li>
								<li ><a href="#">Simulador</a>
									<ul>
										<li><a href="creador.jsp">Opción 1</a></li>
									</ul>
								</li>
							</ul>
						</nav>

				</div>

			<!-- Main -->
				<section class="wrapper style1">
					<div class="container">
						<div id="content">

							<!-- Content -->
								<%
								BDController conexionBD = new BDController();
								Equipo equipo= conexionBD.consultaEquipo(Integer.parseInt(request.getParameter("codEquipo")));
								ArrayList<Jugador>jugadores= conexionBD.jugadoresDeUnEquipo(equipo.getCod_equipo());
								%>
								<article>
									<header>
										<table >
											<tr style="border:0px;" >	
												<td style="background-color: white;"><h2>Plantilla del equipo: <%=equipo.getNombre()%></h2></td><td style="text-align: right;background-color: white;""></td>
											</tr>
										</table>
										
									</header>
									
									<div class="table-wrapper">
								<table class="alt">
									<thead>
										<tr>
											<th>Nombre</th>
											<th width='325' colspan="3"></th>
											<th style="text-align: center;">RAT</th>
											<th style="text-align: center;">POS</th>
											<th style="text-align: center;">CARTA</th>
											<th style="text-align: center;">PRECIO</th>
											<th style="text-align: center;">SKI</th>
											<th style="text-align: center;">WF</th>
											<th style="text-align: center;">PAC</th>
											<th style="text-align: center;">SHO</th>
											<th style="text-align: center;">PAS</th>
											<th style="text-align: center;">DRI</th>
											<th style="text-align: center;">DEF</th>
											<th style="text-align: center;">PHI</th>
											<th style="text-align: center;">ALTURA</th>
										</tr>
									</thead>
									<tbody>
									
										<tr>
											<td width='60' rowspan="2">foto.Jug</td>
											<td width='325' colspan="3" style="padding-left: 15px;">Ronaldo Nazario</td>
											
												<td rowspan="2" width='60' style="text-align: center;">80</td>	
												<td rowspan="2" width='60' style="text-align: center;">DC</td>	
												<td rowspan="2" width='100' style="text-align: center;">SIMPLE</td>	
												<td rowspan="2" width='100' style="text-align: center;">200000</td>	
												<td rowspan="2" width='60' style="text-align: center;">4</td>	
												<td rowspan="2" width='60' style="text-align: center;">5</td>
												
												<td rowspan="2" width='60' style="text-align: center;">87</td>	
												
												<td rowspan="2" width='60' style="text-align: center;">86</td>	
												
												<td rowspan="2" width='60' style="text-align: center;">70</td>	
													
												<td rowspan="2" width='60' style="text-align: center;">65</td>	
													
												<td rowspan="2" width='60' style="text-align: center;">45</td>	
												
												<td rowspan="2" width='60' style="text-align: center;">66</td>
												<td rowspan="2" width='60' style="text-align: center;">170cm</td>
																						
										</tr>
										<tr>
										  <td width='45' style="text-align: right;">Fot.Equ</td>
										  <td width='50' style="text-align: center;">Fot.Band</td>
										  <td width='230'>Foto.Liga</td>
										</tr>
										
										
										
										
										
										
										<% for(Jugador jugador: jugadores){
											Carta cartaJug=conexionBD.consultaCarta(jugador.getCod_jugador(), "SIMPLE");
											Liga liga=conexionBD.consultaLiga(equipo.getCod_liga());
											out.print("<tr>");
											
											out.print("<td width='60' rowspan=\"2\"><a href=\"jugador.jsp?codJugador="+ jugador.getCod_jugador() +"\" title=\" " + jugador.getNombre() + " \"  ><img src='images/jugadores/"+ jugador.getCod_jugador() +".png' width=\"70\" height=\"70\"></a></td>");
											out.print("<td width='325' colspan=\"3\" style=\"padding-left: 15px;\"><a href=\"jugador.jsp?codJugador="+ jugador.getCod_jugador() +"&nombreCarta=SIMPLE title=\" " + jugador.getNombre() + " \"  >"+ jugador.getNombre() +"</a></td>");
											out.print("<td rowspan=\"2\" width='60' style=\"text-align: center;\"><div style=\"width: 80%; height=80%;text-align: center; margin: 0 auto; background-color: #E9BC0B;\">"+ cartaJug.getRat() +"</div></td>	");
											out.print("<td rowspan=\"2\"height='60' width='60' style=\"text-align: center;\">"+ cartaJug.getPos() +"</td>");
											out.print("<td rowspan=\"2\"height='60' width='100' style=\"text-align: center;\">"+ cartaJug.getNombre() +"</td>");
											out.print("<td rowspan=\"2\"height='60' width='100' style=\"text-align: center;\">"+ cartaJug.getPrecio() +"</td>");
											out.print("<td rowspan=\"2\"height='60' width='60' style=\"text-align: center;\">"+ cartaJug.getFiligranas() +"</td>");
											out.print("<td rowspan=\"2\"height='60' width='60' style=\"text-align: center;\">"+ cartaJug.getPierna_mala() +"</td>");
											
											out.print("<td rowspan=\"2\" width='60px' style=\"text-align: center;\"><div style=\"width: 80%; height=80%; margin: 0 auto; text-align: center; color: "+ Utils.textColor(cartaJug.getPac()) +"; background-color: "+ Utils.bgColor(cartaJug.getPac()) +"\">"+ cartaJug.getPac() +"</div></td>");
											
											out.print("<td rowspan=\"2\" width='60px' style=\"text-align: center;\"><div style=\"width: 80%; height=80%; margin: 0 auto; text-align: center; color: "+ Utils.textColor(cartaJug.getSho()) +"; background-color: "+ Utils.bgColor(cartaJug.getSho()) +"\">"+ cartaJug.getSho() +"</div></td>");
											
											out.print("<td rowspan=\"2\" width='60px' style=\"text-align: center;\"><div style=\"width: 80%; height=80%; margin: 0 auto; text-align: center; color: "+ Utils.textColor(cartaJug.getPas()) +"; background-color: "+ Utils.bgColor(cartaJug.getPas()) +"\">"+ cartaJug.getPas() +"</div></td>");
											
											out.print("<td rowspan=\"2\" width='60px' style=\"text-align: center;\"><div style=\"width: 80%; height=80%; margin: 0 auto; text-align: center; color: "+ Utils.textColor(cartaJug.getDri()) +"; background-color: "+ Utils.bgColor(cartaJug.getDri()) +"\">"+ cartaJug.getDri() +"</div></td>");
											
											out.print("<td rowspan=\"2\" width='60px' style=\"text-align: center;\"><div style=\"width: 80%; height=80%; margin: 0 auto; text-align: center; color: "+ Utils.textColor(cartaJug.getDef()) +"; background-color: "+ Utils.bgColor(cartaJug.getDef()) +"\">"+ cartaJug.getDef() +"</div></td>");
											
											out.print("<td rowspan=\"2\" width='60px' style=\"text-align: center;\"><div style=\"width: 80%; height=80%; margin: 0 auto; text-align: center; color: "+ Utils.textColor(cartaJug.getPhy()) +"; background-color: "+ Utils.bgColor(cartaJug.getPhy()) +"\">"+ cartaJug.getPhy() +"</div></td>");
											
											out.print("<td rowspan=\"2\" width='60px' style=\"text-align: center;\">"+ jugador.getAltura() +"cm</td>");
											
											out.print("</tr>");
											
											
											out.print("<tr>");
											out.print("<td width='45' style=\"text-align: center;\"><img src='images/equipos/"+ jugador.getCod_equipo() +".png' width='30px' height='30PX'></td>");
											out.print("<td width='50' style=\"text-align: center;\"><img src='images/paises/"+ jugador.getPais() +".png' width='25px' height='25px'></td>");
											out.print("<td width='230'><img src='images/ligas/"+ liga.getCod_liga() +".png' width='30px' height='30px'></td>");
											out.print("</tr>");
										}
										
										
										%>
										
										
									</tbody>
									
								</table>
							</div>

									
								</article>

						</div>
					</div>
				</section>
			

			<!-- Footer -->
				<div id="footer">
					<div class="container">
						<div class="row">
							<section class="col-3 col-6-narrower col-12-mobilep">
								<h3>Listados</h3>
								<ul class="links">
									<li><a href="jugadores.asp">Listado de Ligas</a></li>
									
								
								</ul>
							</section>
							<section class="col-3 col-6-narrower col-12-mobilep">
								<h3>Más Opciones</h3>
								<ul class="links">
									<li><a href="operaciones.jsp?tipo=altaJugador">Opción 1</a></li>
									
								</ul>
							</section>
							<section class="col-6 col-12-narrower">
								<h3>Solicita Información</h3>
								<form>
									<div class="row gtr-50">
										<div class="col-6 col-12-mobilep">
											<input type="text" name="name" id="name" placeholder="Name" />
										</div>
										<div class="col-6 col-12-mobilep">
											<input type="email" name="email" id="email" placeholder="Email" />
										</div>
										<div class="col-12">
											<textarea name="message" id="message" placeholder="Message" rows="5"></textarea>
										</div>
										<div class="col-12">
											<ul class="actions">
												<li><input type="submit" class="button alt" value="Enviar Email" /></li>
											</ul>
										</div>
									</div>
								</form>
							</section>
						</div>
					</div>

					<!-- Icons -->
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
							<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
							<li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
						</ul>

					<!-- Copyright -->
						<div class="copyright">
							<ul class="menu">
								<li>&copy; FIFA 23. Todos los derechos reservados</li><li>Design: <a href="https://www.centronelson.org">Centro Nelson</a></li>
							</ul>
						</div>

				</div>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
</body>
</html>