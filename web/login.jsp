<%-- 
    Document   : login
    Created on : Mar 3, 2013, 9:05:11 PM
    Author     : juanjo
--%>

<%@page import="Controlador.ServletLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = (String) request.getAttribute(ServletLogin.ATRIBUTO_ERR);
    if (mensaje == null){
        mensaje = "";
    }
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
	<script type="text/javascript" src="js/validacionLogin.js"></script>

	
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
		
			<h3>Login</h3>
	
			<p>
				Por favor proporciona tus credenciales para entrar al sistema.
			</p>
			
			<!-- forma de envio -->
                        <h3 style="color:red"><%=mensaje%></h3>
			<div id="form">
			<form id="form" action="login" onsubmit="return validateLogin(this)" method="post">
					<fieldset class="info_fieldset">
						<div id="note"></div>
						<div id="fields">
							<label>Nombre Usuario</label><input class="textbox" type="text" name="nombreUsuario"  id="nombreUsuario"/><br />
							<label>Contraseña</label><input class="textbox" type="password" name="password"  id="password"/><br />

							<br />


				
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
