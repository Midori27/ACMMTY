<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia noticia = (Noticia) request.getAttribute("noticia");
    if(noticia==null) response.sendRedirect("/AdminNoticias");
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
		
			<h3>Actualizar Noticia</h3>

			<p>
				Favor de ingresar la información de la actualización.
			</p>
			
			<!-- forma de envio -->
			<div id="form">
				%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
				<form action="ActualizaNoticia" method="post" enctype="multipart/form-data">
		            <input type="hidden" name="id" value="<%=noticia.getId()%>">
		            <label for="titulo">Titulo</label><input type="text" name="titulo" value="<%=noticia.getTitulo()%>">
		            <br>
		            <br>
		            <label for="descripcion">Descripcion</label><textarea name="descripcion"><%=noticia.getDescripcion()%></textarea>
		            <br>
		            <br>
		            <label for="imagen">Imagen</label><input type="file" name="imagen">
		            <br>
		            <br>
		            <img src="<%='ImagenServidor'/+noticia.getImagen()%>" height="100" width="100">
		            <input type="hidden" name="imagenSubida" value="<%=noticia.getImagen()%>">
		            <br>
		            <br>
	                <label>&nbsp;</label><input class="button" type="image" src="../../images/send.png" id="submit" value="Actualiza noticia" />	
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

