<%-- 
    Document   : eventos
    Created on : Mar 7, 2013, 8:37:19 AM
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
	<script type="text/javascript" src="js/contact_form.js"></script>
</head>

<body>

	<!-- Barra fija -->
	<div id="topbar">
		<!-- Logo ACM -->
		<img src="images/logo.png" class="logo" alt="ACM MTY" />
		
		<%@include file="navegacion.jsp"%>
	</div>
	
	<div class="container">

		<!--Inicio Barra izquierda -->
		<div id="sidebar">
		
			<div id="slogan">
				<h2>Hackaton</h2>
				<p>
					Hackathon Monterrey es el evento que reúne a los mejores hackers de la ciudad en un maratón de 24 horas, con el objetivo de desarrollar nuevas ideas en un explosivo encuentro colaborativo de productividad.

				</p>
			</div>
		</div>
		<!-- Final Barra izquierda -->
		
		<!--Contenido -->
		<div id="contentInside">	
			<img src="images/ACM/hackatonDetalle.jpg" class="detailImg" alt=""/>
			
			<h3>let the hacking begin!</h3>
			
			<p>
				Tú y tu equipo pueden crear el inicio de lo que podría convertirse en la próxima gran startup o la próxima gran utilidad para otros hackers.

A diferencia de otros eventos de fin de semana, en Hackathon Monterrey nos concentramos 100% en lo que puedas crear, ya que, como debes saberlo, tu producto es lo que hablará por ti. Buscamos sólo Doers que demuestren que pueden poner el ejemplo al país con soluciones de software.

Toma la oportunidad de hackear junto a los mejores devs, mentores y aporta a la comunidad de hackers tu sabiduría. Puedes crear una app móvil, o una web app, o hasta el nuevo gem que podrá servirle a otros devs a ser más productivos.

			</p>
			

		
				<div id="footer">
					<p>
						ACM MTY 2013
					</p>
				</div>
		</div>
		<!-- END CONTENT -->
		<div id="clearer"></div>

	</div>
	<!-- END CONTAINER -->
</body>
</html>

