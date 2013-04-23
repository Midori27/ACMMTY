<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento, net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList" %>
<%
    Evento evento = (Evento) request.getAttribute("evento");
    if(evento==null)evento = new Evento();  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<!-- Fonts de google -->
	<link href='http://fonts.googleapis.com/css?family=Numans' rel='stylesheet' type='text/css'/>
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link type="text/css" rel="stylesheet" href="../../css/style.css" />
	<title>ACM MTY</title>
	<meta name="Description" content="ACMMTY"
	<script type="text/javascript" src="../../js/jquery.js"></script> 
	<script type="text/javascript" src="../../js/validacionEvento.js"></script>

	
</head>

<body>

	<!-- Barra fija -->
	<div id="topbar">
		<!-- Logo ACM -->
		<img src="../../images/logo.png" class="logo" alt="ACM MTY" />
		
		<!-- Navegación de página -->
		<div id="navigation">
		  <ul>
			<li><a href="index.html" >Inicio</a></li>
			<li><a href="detail.html" title="Eventos">Eventos</a></li>
			<li><a href="contact.html" title="Contacto">Contacto</a></li>
			<li><a href="detail2.html" title="Acerca">Acerca de Nosotros</a></li>
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
				<li class="twitter"><a href="https://twitter.com/acmmonterrey"></a></li>
				<li class="facebook"><a href="http://www.facebook.com/acmmonterrey?fref=ts"></a></li>

			  </ul>
			</div>
			<!--Final Redes Sociales-->
			
			<div class="clearer"></div>
			
	
		</div>
		<!--Final barra izquierda-->
		
		<!-- Contenido -->
		<div id="contentInside">
		
			<h3>Crear Evento</h3>
			<%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>

			<p>
				Favor de proporcionar la información acerca del Evento.
			</p>
			
			<!-- forma de envio -->
			<div id="form">
				<%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
				<form action="CreaEvento"  method="post" enctype="multipart/form-data">
	                <label>Nombre Evento</label><input class="textbox" type="text" name="nombre"  id="nombre" value="<%=evento.getNombre()%>"/>
	                <br>
	                <br>
	                <label>Fecha del Evento</label>
	                <input type="date" class="textbox" name="fecha" id="fecha" value="<%=evento.getFechaString()%>" >
	                <br>
	                <br>          
	                <label>Lugar</label>
	                <input class="textbox"  type="text" name="lugar"  id="lugar" value="<%=evento.getLugar()%>"/>
	                <br>
	                <br>
	                <label>Descripción del Evento</label><input class="textbox"  type="text" name="descripcion"  id="descripcion" value="<%=evento.getDescripcion()%>"/>
	                <br>
	                <br>
	                
	                <label>Integrantes por Equipo</label><input class="textbox"  type="text" name="integrantesPorEquipo"  id="integrantesPorEquipo" value="<%=evento.getMaxIntegrantesEquipo()%>"/>
	                <br />
	                <br />
	                <label for="imagen">Imagen</label><input type="file" name="imagen"><br /><br>
	                <img src="ImagenServidor/<%=evento.getImagen()%>" height="150" width="150"><br><br>
	                <input type="hidden" name="imagenSubida" value="<%=evento.getImagen()%>">
	                <label>&nbsp;</label><input class="button" type="image" src="../../images/send.png" id="submit" value="Crea evento" />	
                </form>


					
			</div>
			<!-- final forma de envio -->
			
					
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

