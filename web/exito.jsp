<%-- 
    Document   : exito
    Created on : Mar 22, 2013, 6:16:31 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null){
        mensaje="";
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
		
		<%@include file="/WEB-INF/Includes/navegacion.jsp"%>
	</div>
	
	<div class="container">
		<!--Contenido -->
		<div id="contentInside">	
                    <h3><%=mensaje%></h3>
                    <a href="/PortalACM/index.jsp">Regresar a inicio</a>
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
