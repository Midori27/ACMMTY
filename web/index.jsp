<%-- 
    Document   : index
    Created on : Feb 27, 2013, 10:39:17 AM
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
	<meta name="Description" content="Olìmpo - Portfolio minimal per web designers e non solo" />
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/scrollto.js"></script>
	
	<!--Librerias usadas para gallery view
	
	<!-- First, add jQuery (and jQuery UI if using custom easing or animation -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	
	<!-- Second, add the Timer and Easing plugins -->
	<script type="text/javascript" src="jsGV/jquery.timers-1.2.js"></script>
	<script type="text/javascript" src="jsGV/jquery.easing.1.3.js"></script>
	
	<!-- Third, add the GalleryView Javascript and CSS files -->
	<script type="text/javascript" src="jsGV/jquery.galleryview-3.0-dev.js"></script>
	<link type="text/css" rel="stylesheet" href="css/jquery.galleryview-3.0-dev.css" />
	
	<!-- Lastly, call the galleryView() function on your unordered list(s) -->
	<script type="text/javascript">
		$(function(){
			$('#myGallery').galleryView({
				transition_speed: 600,
				show_filmstrip: false,
				panel_animation: 'slide',
				show_infobar: false,
				panel_width: 1270,
				panel_height: 500,
			});
		});
	</script>
	
	
</head>

<body>

	<!-- Barra fija -->
	<div id="topbar">
		<!-- Logo ACM -->
		<img src="images/logo.png" class="logo" alt="ACM MTY" />
		
		<!-- Navegación de página -->
		<div id="navigation">
		  <ul>
			<li><a class="current">Inicio</a></li>
			<li><a href="eventos.html" title="#">Eventos</a></li>
			<li><a href="contact.html" title="#">Contacto</a></li>
			<li><a href="nosotros.html" title="#">Acerca de Nosotros</a></li>
		  </ul>
		</div>
		<!-- Final del menu de navegación -->
	</div>
	<!-- FINAL barra fija -->


	<div class="container">

		
		<!-- Contenido especial para home-->
		<div id="contenth">
			
			
			<ul id="myGallery">
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp1.jpg" alt="Lone Tree Yellowstone" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp2.jpg" alt="Is He Still There?!" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp4.jpg" alt="Noni Nectar For Green Gecko" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp7.jpg" alt="Flight of an Eagle Owl" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp14.jpg" alt="Winter Lollipops" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp26.jpg" alt="Day of Youth" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp27.jpg" alt="Sunbathing Underwater" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp28.jpg" alt="Untitled" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp41.jpg" alt="New Orleans Streetcar" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp49.jpg" alt="By The Wind of Chance" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp52.jpg" alt="Fishing on the Cloud" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp53.jpg" alt="Blue Lagoon" />
				<li><img src="http://www.spaceforaname.com/galleryview/img/photos/bp54.jpg" alt="Time" />
			</ul>
		
			<div id="contenth2">

				<!-- Noticias-->
				<p><a name="noticias"></a></p> 
				<div class="group">
					
					
					<h3>Noticias Febrero 2013</h3>
					
					<p>
						El <strong>hackaton</strong> de este año fue ttalmente un exito.
					</p>
					
					<div class="ventana">
						<img src="images/ACM/hackaton.jpg" alt="" />
					</div>
				</div>
				<!-- Fin de noticias -->
				
				
				<div id="footer">
					<p>
						ACM MTY 2013
					</p>
				</div>
			</div>
		</div>
		<!-- Final del Contenido -->
		
		<div id="clearer"></div>

	</div>
</body>
</html>

