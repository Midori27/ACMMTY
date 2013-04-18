<%-- 
    Document   : actualizaEvento
    Created on : Apr 16, 2013, 5:35:29 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento, Servlet.Evento.AdminEventos" %>
<%
    Evento evento = (Evento) request.getAttribute("evento");
    if(evento==null) response.sendRedirect("/AdminEventos");
    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null)mensaje="";
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3><%=mensaje%></h3>
        <form action="ActualizaEvento"  method="post">
            <fieldset class="info_fieldset">
                <input type="hidden" name="id" value="<%=evento.getId()%>"
                <label>Nombre Evento</label><input class="textbox" type="text" name="nombre"  id="nombre" value="<%=evento.getNombre()%>"/><br />
                <label>Fecha del Evento</label>
                <input type="date" class="textbox" name="fecha" id="fecha" value="mm-dd-aaaa"><br /><br />
                <label>Lugar</label><input class="textbox"  type="text" name="lugar"  id="lugar" value="<%=evento.getLugar()%>"/><br />
                <label>Descripción del Evento</label><input class="textbox"  type="text" name="descripcion"  id="descripcion" value="<%=evento.getDescripcion()%>"/>
                <br /><br />
                <label>Integrantes por Equipo</label><input class="textbox"  type="text" name="maxIntegrantesEquipo"  id="maxIntegrantesEquipo" value="<%=evento.getMaxIntegrantesEquipo()%>"/>
                <br />
                <input type="submit" value="Actualiza evento">
        </form>
    </body>
</html>
