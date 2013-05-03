<%-- 
    Document   : verNoticia
    Created on : May 1, 2013, 11:42:41 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia, Modelo.Comentario" %>
<%
    Noticia n = (Noticia) request.getAttribute(Noticia.NOMBRE_TABLA);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>verNoticia</h1>
        <h2><%=n.getTitulo()%></h2>
        <img src="ImagenServidor/<%=n.getImagen()%>">
        <p><%=n.getDescripcion()%></p>
        <%@include file="/WEB-INF/Includes/comentariosNoticia.jsp"%>
        <form action="CreaComentarioNoticia" method="post">
            <label for="descripcion">Comentario:</label><input type="text" name="descripcion">
            <input type="hidden" name="id" value="<%=n.getId()%>">
            <input type="submit" value="Enviar">
        </form>
        
    </body>
</html>
