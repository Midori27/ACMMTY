<%-- 
    Document   : verNoticia
    Created on : May 1, 2013, 11:42:41 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento, Modelo.Comentario" %>
<%
    Evento evento = (Evento) request.getAttribute(Evento.NOMBRE_TABLA);
   
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>verEvento</h1>
        <h2><%=evento.getNombre()%></h2>
        <img src="ImagenServidor/<%=evento.getImagen()%>">
        <p><%=evento.getDescripcion()%></p>
         <%@include file="/WEB-INF/Includes/comentariosEvento.jsp"%>
        <form action="CreaComentarioEvento" method="post">
            <label for="descripcion">Comentario:</label><input type="text" name="descripcion">
            <input type="hidden" name="id" value="<%=evento.getId()%>">
            <input type="submit" value="Enviar">
        </form>
        
    </body>
</html>