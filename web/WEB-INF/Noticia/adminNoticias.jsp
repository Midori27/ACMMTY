<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia noticias[] = (Noticia[]) request.getAttribute("noticias");
    if (noticias==null)noticias = new Noticia[0];
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje==null)mensaje="";
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
		
			<h3>Administrar Noticias</h3>

			<p>
				Favor de seleccionar noticia.
			</p>
			
				<% for(int i=0; i<noticias.length;i++){%>
		        <%=noticias[i].getTitulo()%>
		        <h3><%=mensaje%></h3>

		        <br>
            	<br>
            	<br><input class="button" type="image" src="../../images/modificar.png" value="modificar"
            	onClick="window.location.href='ActualizaNoticia?id=<%=noticias[i].getId()%>'" />
            	<input class="button" type="image" src="../../images/eliminar.png"  value="Crea evento" 
            	onClick="window.location.href='BorraNoticia?id=<%=noticias[i].getId()%>'"/>
            	<input class="button" type="image" src="../../images/publicar.png"  value="Crea evento"
            	onClick="window.location.href='Pagina'"/>
            	<br>
		        
		        
		        <%}%>

					
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

