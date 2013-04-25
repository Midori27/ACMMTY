<%-- 
    Document   : pruebaMesaDirectiva
    Created on : Apr 15, 2013, 1:41:49 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.MiembroMesa, net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList" %>
<%
    MiembroMesa miembro = (MiembroMesa) request.getAttribute("miembro");
    if(miembro==null) miembro = new MiembroMesa();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crea Miembro Mesa</h1>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="Admin/CreaMiembroMesa" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%=miembro.getId()%>">
            <label for="periodo">Periodo</label>
            <input type="text" name="periodo" value="<%=miembro.getPeriodo()%>"><br />
             <label for="nombre">Nombre</label>
            <input type="text" name="nombre" value="<%=miembro.getNombre()%>"><br />
             <label for="posicion">Posicion</label>
            <input type="text" name="posicion" value="<%=miembro.getPosicion()%>"><br />
            <label for="imagen">Imagen</label><input type="file" name="foto"><br />
            <img src="ImagenServidor/<%=miembro.getFoto()%>" height="150" width="150">
            <input type="hidden" name="fotoSubida" value="<%=miembro.getFoto()%>">
            <input type="submit" value="Crea miembro">
        </form>
    </body>
</html>
