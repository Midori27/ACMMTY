<%-- 
    Document   : actualizaUsuario
    Created on : Apr 16, 2013, 4:24:55 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Usuario,Controlador.Query"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualiza Usuario</h1>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="ActualizaUsuario" method="post">
            <label>Nombre</label><input class="textbox" type="text" name="nombre"  id="nombre" value="<%=usuario.getNombre()%>"/><br />
            <label>Apellido Paterno</label><input class="textbox" type="text" name="apellidoP"  id="apellidoP" value="<%=usuario.getApellidoP()%>"/><br />
            <label>Apellido Materno</label><input class="textbox" type="text" name="apellidoM"  id="apellidoM" value="<%=usuario.getApellidoM()%>"/><br />
            <label>Email</label><input class="textbox" type="text" name="email"  id="email" value="<%=usuario.getEmail()%>"/><br />
            <label>password</label><input class="textbox" type="password" name="password"  id="password" value="<%=usuario.getPassword()%>"/><br />		
            <input type="submit" value="Actualizar usuario">	
        </form>
    </body>
</html>
