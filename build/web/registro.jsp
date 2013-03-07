<%-- 
    Document   : registro
    Created on : Mar 5, 2013, 8:32:09 PM
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
	<script type="text/javascript" src="js/validacion.js"></script>

	
</head>

<body>

	<!-- Barra fija -->
	<div id="topbar">
		<!-- Logo ACM -->
		<img src="images/logo.png" class="logo" alt="ACM MTY" />
		
		<%@include file="navegacion.jsp"%>
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
		
			<h3>Registro de Usuario</h3>
	
			<p>
				Aqui podrás registrarte en nuestro sitio para poder confirmar tu asistencia a los eventos y de igual manera poder ser contactado sobre los mismos. 
			</p>
			
			<!-- forma de envio -->
			<div id="form">
			<form id="form" action="usuario" onsubmit="return validateRegistro(this)" method="post">
					<fieldset class="info_fieldset">
						<div id="note"></div>
						<div id="fields">
							<label>Nombre</label><input class="textbox" type="text" name="nombre"  id="nombre"/><br />
							<label>Apellido Paterno</label><input class="textbox" type="text" name="apellidoP"  id="apellidoP"/><br />
							<label>Apellido Materno</label><input class="textbox" type="text" name="apellidoM"  id="apellidoM"/><br />
							<label>Fecha de Nacimiento</label>
							<input type="date" class="textbox" name="fechaNacimiento" id="fechaNacimiento" value="mm-dd-aaaa"><br /><br />
							<label>Telefono</label><input class="textbox" type="text" name="telefono"  id="telefono"/><br />
							<label>Ciudad</label><select class="textbox" type="text" name="ciudad"  id="ciudad"/>
							  <option value="nada">Selecciona</option>
							  <option value="Monterrey">Monterrey</option>
							  <option value="Monclova">Monclova</option>
							</select><br /><br />
							<label>Estado</label><select class="textbox" type="text" name="estado"  id="estado"/>
							  <option value="nada">Selecciona</option>
							  <option value="Monterrey">Nuevo Léon</option>
							  <option value="Monclova">Coahuila</option>
							</select><br /><br />
							<label>Universidad</label><select class="textbox" type="text" name="universidad"  id="universidad"/>
							  <option value="nada">Selecciona</option>
							  <option value="ITESM">ITESM</option>
							  <option value="UDEM">UDEM</option>
							</select><br /><br />
							<label>Campus</label><select class="textbox" type="text" name="campus"  id="campus"/>
							  <option value="nada">Selecciona</option>
							  <option value="Monterrey">MTY</option>
							  <option value="Coahuila">COAH</option>
							</select><br /><br />
							<label>Carrera</label><select class="textbox" type="text" name="carrera"  id="carrera"/>
							  <option value="nada">Selecciona</option>
							  <option value="ITC">ITC</option>
							  <option value="ITE">ITE</option>
							</select><br /><br />
							
							<label>Mátricula</label><input class="textbox" type="text" name="matricula"  id="matricula"/><br />
							<label>Nombre de Usuario</label>
							<input class="textbox" type="text" name="nombreUsuario"  id="nombreUsuario"/><br /><br />

						    <label>Email</label><input class="textbox" type="text" name="email"  id="email"/><br />
							<label>password</label><input class="textbox" type="password" name="password"  id="password"/><br />		
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

