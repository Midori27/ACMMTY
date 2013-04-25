<%-- 
    Document   : actualizaMiembroMesa
    Created on : Apr 15, 2013, 11:58:11 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.MiembroMesa" %>
<%
    MiembroMesa miembro = (MiembroMesa) request.getAttribute("miembro");
    if(miembro==null) response.sendRedirect("/AdminMesaDirectiva");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualiza Miembro Mesa</h1>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="ActualizaMiembroMesa" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%=miembro.getId()%>">
            <label for="periodo">Periodo</label>
            <input type="text" name="periodo" value="<%=miembro.getPeriodo()%>"><br />
             <label for="nombre">Nombre</label>
            <input type="text" name="nombre" value="<%=miembro.getNombre()%>"><br />
             <label for="posicion">Posicion</label>
            <input type="text" name="posicion" value="<%=miembro.getPosicion()%>"><br />
            <label for="foto">Foto</label><input type="file" name="foto"><br />
            <img src="ImagenServidor/<%=miembro.getFoto()%>" height="100" width="100">
            <input type="hidden" name="fotoSubida" value="<%=miembro.getFoto()%>">
            <input type="submit" value="Actualizar">
        </form>
    </body>
</html>