<%-- 
    Document   : contact
    Created on : Mar 7, 2013, 8:37:07 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
		
		<%@include file="/WEB-INF/Includes/navegacion.jsp"%>
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
			
			<h2>Testimonios</h2>
			
			<p>
				Este espacio puede ser usado para anuncios<span class="black"></span>
			</p>

		</div>
		<!--Final barra izquierda-->
		
		<!-- Contenido -->
		<div id="contentInside">
		
			<h3>Contacto</h3>
	
			<p>
				Si tienes alguna duda no dudes en enviarla y te contestaremos lo mas pronto posible.
			</p>
			
			<!-- forma de envio -->
			<div id="form" action="" onsubmit="return validateForm()" method="post">
					<fieldset class="info_fieldset">
						<div id="note"></div>
						<div id="fields">
							<label>Nombre</label><input class="textbox" type="text" name="name" value="" />
							<label>Correo</label><input class="textbox" type="text" name="email" value="" /><br />
							<label>Asunto</label><input class="textbox" type="text" name="subject" value="" /><br />
							<label>Mensaje</label><textarea name="message" rows="5" cols="25"></textarea><br />
							<label>&nbsp;</label><input class="button" type="image" src="images/send.png" id="submit" value="Send Message" />	
						</div>
					</fieldset>
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


