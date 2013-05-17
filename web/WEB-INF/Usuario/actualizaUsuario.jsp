<%-- 
    Document   : actualizaUsuario
    Created on : Apr 16, 2013, 4:24:55 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Usuario,Controlador.Query"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<%@include file="/WEB-INF/Includes/header.jsp"%>
<%@include file="/WEB-INF/Includes/errores.jsp"%>
        <!-- forma crear usuario -->
	<div class="row">
		<div class="large-8 large-centered columns">
			<form action="ActualizaUsuario" method="post">
				<fieldset>
					<legend>Actualiza usuario</legend>
						<div class="row">
							<div class="large-4 columns">
								<label>Nombre</label>
								<input type="text" placeholder="Tu nombre" name="nombre" value="<%=usuario.getNombre()%>">
							</div>
							<div class="large-4 columns">
								<label>Apellido Paterno</label>
								<input type="text" placeholder="Tu apellido paterno" name="apellidoP" value="<%=usuario.getApellidoP()%>">
							</div>
							<div class="large-4 columns">
								<label>Apellido Materno</label>
								<input type="text" placeholder="Tu apellido materno" name="apellidoM" value="<%=usuario.getApellidoM()%>">
							</div>
						</div>
						<div class="row">
							<div class="large-6 columns">
								<label>Email</label>
								<input type="text" placeholder="Tu email@dominio.com" name="email" value="<%=usuario.getEmail()%>">
							</div>
						</div>
						<div class="row">
							<div class="large-6 columns">
								<label>Password</label>
								<input type="password"  name="password">
							</div>
							<div class="large-6 columns">
								<label>Confirma password</label>
								<input type="password" name="confirmaPassword">
							</div>
						</div>
						<div class="row">
							<div class="large-offset-9 columns">
								<input class="small button" type="submit" value="Actualizar">
							</div>
						</div>
				</fieldset>
			</form>
		</div>
	</div>
	<!-- termina crear usuario -->
<%@include file="/WEB-INF/Includes/footer.jsp"%>
