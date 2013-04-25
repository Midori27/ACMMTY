<%-- 
    Document   : actualizaEvento
    Created on : Apr 16, 2013, 5:35:29 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento, Servlet.Evento.AdminEventos, net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList" %>
<%
    Evento evento = (Evento) request.getAttribute("evento");
    if(evento==null) response.sendRedirect("/AdminEventos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualiza Evento</h1>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="ActualizaEvento"  method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="<%=evento.getId()%>"
                <label for="nombre">Nombre Evento</label><input type="text" name="nombre" value="<%=evento.getNombre()%>"/><br />
                <label for="fecha">Fecha del Evento</label>
                <input type="date" name="fecha" value="<%=evento.getFechaString()%>"><br /><br />
                <label>Lugar</label><input type="text" name="lugar" value="<%=evento.getLugar()%>"/><br />
                <label for="descripcion">Descripción del Evento</label><input class="textbox"  type="text" name="descripcion"  id="descripcion" value="<%=evento.getDescripcion()%>"/>
                <br /><br />
                <label for="maxIntegranesEquipo">Integrantes por Equipo</label><input type="text" name="integrantesPorEquipo" value="<%=evento.getMaxIntegrantesEquipo()%>"/>
                <br />
                <label for="imagen">Imagen</label><input type="file" name="imagen"><br />
                <img src="<%="ImagenServidor/"+evento.getImagen()%>" height="100" width="100">
                <input type="hidden" name="imagenSubida" value="<%=evento.getImagen()%>">
                <input type="submit" value="Actualiza evento">
        </form>
    </body>
</html>
