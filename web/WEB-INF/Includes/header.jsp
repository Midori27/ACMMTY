<%-- 
    Document   : navegacion
    Created on : Mar 7, 2013, 8:30:19 AM
    Author     : juanjo
--%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario us = (Usuario) request.getSession().getAttribute(Usuario.NOMBRE_TABLA);
%>
<!DOCTYPE html>
<!--[if IE 8]> 				 <html class="no-js lt-ie9" lang="en" > <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en" > <!--<![endif]-->

<head>
	<meta charset="utf-8" />
  <meta name="viewport" content="width=device-width" />
  <title>ACM-MTY</title>
  <link rel="stylesheet" href="css/font-awesome.min.css" />
  <link rel="stylesheet" href="css/foundation.css" />
  <link rel="stylesheet" href="css/myStyle.css" />

  <script src="js/vendor/custom.modernizr.js"></script>

</head>
<body>
    <nav class="top-bar">
        <!-- area del titulo -->
        <ul class="title-area">
                <!-- titulo -->
                <li class="name">
                    <h1><a href="Indice">ACM-MTY<i class="icon-home"></i></a></h1>
                </li>
                <!-- icono del menu -->
                <li class="toggle-topbar menu-icon">
                        <a href="#"><span>Menu</span></a>
                </li>
        </ul>
        <section class="top-bar-section">
                <!-- area izq navegacion -->
                <ul class="left">
                        <li class="divider"></li>
                        <li><a href="Noticias">Noticias</a></li>
                        <li class="divider"></li>
                        <li><a href="Eventos">Eventos</a></li>
                        <li class="divider"></li>
                        <li><a href="MesaDirectiva">ACM</a></li>
                        <li class="divider"></li>
                        <li><a href="Contacto">Contacto</a></li>
                        <li class="divider"></li>
                         
                </ul>
                <!-- area derecha navegacion -->
                <ul class="right">
                    <% if(us == null){ %>
                    <li><a href="Login">Login</a></li>
                    <li class="divider"></li>
                    <%} else {%>
                    <li class="has-dropdown"><a href="#"><i class="icon-user"></i><%=us.getNombreUsuario()%></a>
                        <ul class="dropdown">
                            <li><a href="ActualizaUsuario">Actualizar cuenta</a></li>
                            <% if(us.getTipo()==0) { %>
                            <li class="has-dropdown"><a href="#">Administrar</a>
                                <ul class="dropdown">
                                    <li><a href="AdminNoticias">Noticias</a></li>
                                    <li><a href="AdminEventos">Eventos</a></li>
                                    <li><a href="AdminMesaDirectiva">Mesa Directiva</a></li>
                                </ul>
                            </li>
                            <% } %>
                            <li><a href="Logout">Logout</a></li>
                        </ul>
                    </li>
                    <% }  %>
                </ul>
        </section>
    </nav>