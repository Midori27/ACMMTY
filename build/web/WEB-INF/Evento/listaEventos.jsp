<%-- 
    Document   : listaEventos
    Created on : Mar 5, 2013, 10:34:48 PM
    Author     : juanjo
--%>

<%@page import="Controlador.ControladorQuery,Modelo.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ControladorQuery cq = new ControladorQuery();
    Evento[] eventos = cq.getEventosBd();
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
		
		<%@include file="navegacion.jsp"%>
	</div>
	<!-- FINAL barra fija -->

	<div class="container">

		<!-- Barra Izquierda -->
		<div id="sidebar">

			
			
			<div class="clearer"></div>
			

		</div>
		<!--Final barra izquierda-->
		
		<!-- Contenido -->
		<div id="contentInside">
		
			<h3>Administración de Eventos</h3>
	
			<p>
				Lista 
                        </p>
			
			

			
				<fieldset class="info_fieldset">
					<div id="note"></div>
					<div id="fields">
					<!--AQUI EMPIEZA EL FOR>-->
                                        <%  for(int i=0;i<eventos.length;i++){%>
					<form name="listaEvento" action="borraEvento">
						<label><%=eventos[i].getNombre()%></label><br />
						<input type="submit" value="Borrar" onclick="" />
						<input type="hidden" value="<%=eventos[i].getId()%>" name="id" id="id" /><br />
					</form>
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
