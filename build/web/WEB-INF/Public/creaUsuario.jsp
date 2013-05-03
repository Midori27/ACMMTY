<%-- 
    Document   : creaUsuario
    Created on : Apr 16, 2013, 4:25:13 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Usuario" %>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if(usuario==null)usuario = new Usuario();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crea Usuario</h1>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="CreaUsuario" method="post">
            <label>Nombre</label><input class="textbox" type="text" name="nombre"  id="nombre" value="<%=usuario.getNombre()%>"/><br />
            <label>Apellido Paterno</label><input class="textbox" type="text" name="apellidoP"  id="apellidoP" value="<%=usuario.getApellidoP()%>"/><br />
            <label>Apellido Materno</label><input class="textbox" type="text" name="apellidoM"  id="apellidoM" value="<%=usuario.getApellidoM()%>"/><br />
            <label>Nombre de Usuario</label>
            <input class="textbox" type="text" name="nombreUsuario"  id="nombreUsuario" value="<%=usuario.getNombreUsuario()%>"/><br /><br />
            <label>Email</label><input class="textbox" type="text" name="email"  id="email" value="<%=usuario.getEmail()%>"/><br />
            <label>password</label><input class="textbox" type="password" name="password"  id="password" value="<%=usuario.getPassword()%>"/><br />		
            <input type="submit" value="Crear usuario">	
        </form>
    </body>
</html>
