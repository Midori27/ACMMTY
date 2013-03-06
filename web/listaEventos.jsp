<%-- 
    Document   : listaEventos
    Created on : Mar 5, 2013, 10:34:48 PM
    Author     : juanjo
--%>

<%@page import="Controlador.ServletEvento,Modelo.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Evento[] eventos = (Evento[]) request.getAttribute(ServletEvento.ATRIBUTO_EVENTOS);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<!-- Fonts de google -->
	<link href='http://fonts.googleapis.com/css?family=Numans' rel='stylesheet' type='text/css'/>
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<title>ACM MTY</title>
	<meta name="Description" content="ACMMTY"
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/scrollto.js"></script>
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/scrollto.js"></script>
	<script type="text/javascript" src="js/validacion.js"></script>
</head>

<body>

	<!-- Barra fija -->
	<div id="topbar">
		<!-- Logo ACM -->
		<img src="images/logo.png" class="logo" alt="ACM MTY" />
		
		<!-- Navegación de página -->
		<div id="navigation">
		  <ul>
			<li><a href="index.jsp" >Inicio</a></li>
			<li><a href="eventos.html" title="Eventos">Eventos</a></li>
			<li><a href="contacto.html" title="Contacto">Contacto</a></li>
			<li><a href="nosotros.html" title="Acerca">Acerca de Nosotros</a></li>
		  </ul>
		</div>
		<!-- Final del menu de navegación -->
	</div>
	<!-- FINAL barra fija -->

	<div class="container">

		<!-- Barra Izquierda -->
		<div id="sidebar">

			<h2>Contacto</h2>
			
			<p>
				Puedes encontrarnos en las redes sociales a través de:
			</p>

			<!-- Redes Sociales -->
			<div id="socials">
			  <ul>
				<li class="twitter"><a href="#"></a></li>
				<li class="facebook"><a href="#"></a></li>

			  </ul>
			</div>
			<!--Final Redes Sociales-->
			
			<div class="clearer"></div>
			

		</div>
		<!--Final barra izquierda-->
		
		<!-- Contenido -->
		<div id="contentInside">
		
			<h3>Administración de Eventos</h3>
	
			<p>
				Lista 
			</p>
			
			AQUI PON EL EVENTO FUE AGREGADO
			
			

			
				<fieldset class="info_fieldset">
					<div id="note"></div>
					<div id="fields">
					<!--AQUI EMPIEZA EL FOR>-->
                                        <%  for(int i=0;i<eventos.length;i++){%>
					<form name="listaEvento" action="evento">
						<label><%=eventos[i].getNombre()%></label><br />
						<input type="submit" value="Borrar" onclick="" />
						<input type="hidden" value="<%=eventos[i].getId()%>" name="id" id="id" /><br />
					<form>
                                        <% } %>
					<!--AQUI TERMINA EL FOR>-->

					</div>
				</fieldset>
			</div>
			
					
				<div id="footer">
					<p>
						ACM MTY 2013
					</p>
				</div>
			</div>
		</div>
		<div id="clearer"></div>

	</div>
</body>
</html>
