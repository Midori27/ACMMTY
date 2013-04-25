<%-- 
    Document   : creaEvento
    Created on : Apr 16, 2013, 5:35:16 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento, net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList" %>
<%
    Evento evento = (Evento) request.getAttribute("evento");
    if(evento==null)evento = new Evento();  
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crea Evento</h1>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="CreaEvento"  method="post" enctype="multipart/form-data">
                <label>Nombre Evento</label><input class="textbox" type="text" name="nombre"  id="nombre" value="<%=evento.getNombre()%>"/><br />
                <label>Fecha del Evento</label>
                <input type="date" class="textbox" name="fecha" id="fecha" value="<%=evento.getFechaString()%>"><br /><br />
                <label>Lugar</label><input class="textbox"  type="text" name="lugar"  id="lugar" value="<%=evento.getLugar()%>"/><br />
                <label>Descripción del Evento</label><input class="textbox"  type="text" name="descripcion"  id="descripcion" value="<%=evento.getDescripcion()%>"/>
                <br /><br />
                <label>Integrantes por Equipo</label><input class="textbox"  type="text" name="integrantesPorEquipo"  id="integrantesPorEquipo" value="<%=evento.getMaxIntegrantesEquipo()%>"/>
                <br />
                <label for="imagen">Imagen</label><input type="file" name="imagen"><br />
                <img src="ImagenServidor/<%=evento.getImagen()%>" height="150" width="150">
                <input type="hidden" name="imagenSubida" value="<%=evento.getImagen()%>">
                <input type="submit" value="Crea evento">
        </form>
    </body>
</html>
