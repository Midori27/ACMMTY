<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Usuario,Controlador.Query"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if(usuario==null){
        Integer id = Integer.parseInt((String)request.getSession().getAttribute("id"));
        Query q = new Query();
        usuario = q.getUsuarioBD(id);
    }
    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null)mensaje = "";
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
		<img src="images/logo.png" class="logo" alt="ACM MTY" />
		
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
		
			<h3><%=mensaje%></h3>
			        <form action="ActualizaUsuario" method="post">
			            <label>Nombre</label><input class="textbox" type="text" name="nombre"  id="nombre" value="<%=usuario.getNombre()%>"/>
			            <br /><br />
			            <label>Apellido Paterno</label><input class="textbox" type="text" name="apellidoP"  id="apellidoP" value="<%=usuario.getApellidoP()%>"/>
			            <br /><br />
			            <label>Apellido Materno</label><input class="textbox" type="text" name="apellidoM"  id="apellidoM" value="<%=usuario.getApellidoM()%>"/><br /><br />
			            
			            <!--
			            <label>Fecha de Nacimiento</label>
			            <input type="date" class="textbox" name="fechaNacimiento" id="fechaNacimiento" value="<%=usuario.getFechaNacimiento().toString()%>"><br /><br />
			            <label>Telefono</label><input class="textbox" type="text" name="telefono"  id="telefono" value="<%=usuario.getTelefono()%>"/><br />
			            <label>Ciudad</label><select class="textbox" type="text" name="ciudad"  id="ciudad" />
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
			            <label>Mátricula</label><input class="textbox" type="text" name="matricula"  id="matricula" value="<%=usuario.getMatricula()%>"/><br />
			            
			            //-->
			            <label>Nombre de Usuario</label>
			            <input class="textbox" type="text" name="nombreUsuario"  id="nombreUsuario" value="<%=usuario.getNombreUsuario()%>"/>
			            <br /><br /><br />
			            <label>Email</label><input class="textbox" type="text" name="email"  id="email" value="<%=usuario.getEmail()%>"/>
			            <br /><br />
			            <label>password</label><input class="textbox" type="password" name="password"  id="password" value="<%=usuario.getPassword()%>"/>
			            <br /><br />
	                <label>&nbsp;</label><input class="button" type="image" src="../../images/send.png" id="submit" value="Actualizar Usuario" />	
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

