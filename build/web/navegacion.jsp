<%-- 
    Document   : navegacion
    Created on : Mar 7, 2013, 8:30:19 AM
    Author     : juanjo
--%>

<%@page import="Controlador.ServletLogin,Controlador.ControladorQuery,Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="navigation">
		  <ul>
			<li><a href="index.jsp" >Inicio</a></li>
			<li><a href="eventos.jsp" title="Eventos">Eventos</a></li>
			<li><a href="contact.jsp" title="Contacto">Contacto</a></li>
			<li><a href="nosotros.jsp" title="Acerca">Acerca de Nosotros</a></li>
                        <% 
                            HttpSession se = request.getSession();
                            Integer idUsuario = (Integer) se.getAttribute(ServletLogin.ATRIBUTO_ID);
                            if(idUsuario == null){
                         %>
                        <li><a href="login.jsp" title="Ingresa">Login</a></li>
                        <li><a href="registro.jsp" title="Registro">Registrate</a></li>
                        <% }else {
                             ControladorQuery coq = new ControladorQuery();
                             Usuario us = coq.getUsuarioBd(idUsuario);
                             if(us.getTipo()==0){
                            %>
                        <li><a href="cuenta.jsp" title="Cuenta"><%=us.getNombreUsuario()%></a></li>
                        <li><form id="form" action="logout" method="post" style="display:inline;"><input type="submit" value="Logout" style="display:inline;"></form></li>
                        <li><a href="listaEventos.jsp" title="listaEventos">Listado eventos</a></li>
                        <li><a href="nuevoEvento.jsp" title="nuevoEvento">Nuevo evento</a></li>
                        <%}else{%>
                        <li><a href="cuenta.jsp" title="Cuenta"><%=us.getNombreUsuario()%></a></li>
                        <li><form id="form" action="logout" method="post" style="display:inline;"><input type="submit" value="Logout" style="display:inline;"></form></li>
                        <%}}%>
                  </ul>
</div>
